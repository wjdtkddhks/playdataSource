import json
import math
import matplotlib.pyplot as plt
import matplotlib
from matplotlib import font_manager
import pandas as pd

def correlation(x, y):
    n = len(x)
    vals = range(n)

    x_sum = 0.0
    y_sum = 0.0
    x_sum_pow = 0.0
    y_sum_pow = 0.0
    mul_xy_sum = 0.0

    for i in vals:
        mul_xy_sum += float(x[i])*float(y[i])
        x_sum += float(x[i])
        y_sum += float(y[i])
        x_sum_pow += pow(float(x[i]), 2)
        y_sum_pow += pow(float(y[i]), 2)

    try:
        r = ((n*mul_xy_sum) - (x_sum * y_sum)) / math.sqrt( ((n * x_sum_pow) - pow(x_sum, 2)) * ((n * y_sum_pow) - pow(y_sum, 2)) )

    except :
        r = 0.0

    return r

def setScatterGraph(tour_table, fv_table, tourpoint):

    # tour_table에서 tour_table['resNm'] == tourpoint을 만족하는 데이터 추출
    tour = tour_table[tour_table['resNm'] == tourpoint]
    print("tour:", tour)
    merge_table = pd.merge(tour, fv_table, left_index=True, right_index=True)

    fig = plt.figure()

    fig.suptitle(tourpoint + "상관관계 분석")

    plt.subplot(1, 3, 1)
    plt.xlabel('중국인 입국수')
    plt.ylabel('외국인 입장객수')
    r1 = correlation(list(merge_table['china']), list(merge_table['ForNum']))
    plt.title("r = {:5f}".format(r1))
    # edgecolor: 테두리 색상, alpha: 투명도, s: 사이즈(크기), c:컬러(색상)
    plt.scatter(list(merge_table['china']), list(merge_table['ForNum']),
                edgecolors='red', alpha=0.75, s=100, c='black')

    plt.subplot(1, 3, 2)
    plt.xlabel('일본인 입국수')
    plt.ylabel('외국인 입장객수')
    r2 = correlation(list(merge_table['japan']), list(merge_table['ForNum']))
    plt.title("r = {:5f}".format(r2))
    plt.scatter(list(merge_table['japan']), list(merge_table['ForNum']),
                edgecolors='none', alpha=0.75, s=6, c='black')

    plt.subplot(1, 3, 3)
    plt.xlabel('미국인 입국수')
    plt.ylabel('외국인 입장객수')
    r3 = correlation(list(merge_table['usa']), list(merge_table['ForNum']))
    plt.title("r = {:5f}".format(r3))
    plt.scatter(list(merge_table['usa']), list(merge_table['ForNum']),
                edgecolors='none', alpha=0.75, s=6, c='black')

    # tight_layout() : subplot들이 Figure 객체의 영역 내에서 자동으로 최대 크기 출력하게 해준다.
    plt.tight_layout()

    plt.show()
    return [tourpoint, r1, r2, r3]

def main():
    font_location = "c:/Windows/fonts/malgun.ttf"
    font_name = font_manager.FontProperties(fname=font_location).get_name()
    matplotlib.rc("font", family=font_name)

    tpFileName = '서울특별시_관광지입장정보_2011_2016.json'
    jsonTP = json.loads(open(tpFileName, 'r', encoding='utf-8').read())
    tour_table = pd.DataFrame(jsonTP, columns=['yyyymm', 'resNm', 'ForNum'])
    tour_table = tour_table.set_index('yyyymm')
    print("===== tour_table ======")
    print(tour_table)
    print("=======================")

    #tour_table에서 resNm필드를 언데싱후 unique한 값 저장(리스트 형태로)
    resNm = tour_table.resNm.unique()
    print("resNm:", resNm, len(resNm))
    print()

    fv_CFileName = "중국(112)_해외방문객정보_2011_2016.json"
    jsonFV = json.loads(open(fv_CFileName, 'r', encoding='utf-8').read())
    china_table = pd.DataFrame(jsonFV, columns=['yyyymm', 'visit_cnt'])
    china_table = china_table.rename(columns={"visit_cnt":'china'})
    china_table = china_table.set_index("yyyymm")
    print("===== china_table ======")
    print(china_table)
    print("=======================")

    fv_JFileName = "일본(130)_해외방문객정보_2011_2016.json"
    jsonFV = json.loads(open(fv_JFileName, 'r', encoding='utf-8').read())
    japan_table = pd.DataFrame(jsonFV, columns=['yyyymm', 'visit_cnt'])
    japan_table = japan_table.rename(columns={'visit_cnt':'japan'})
    japan_table = japan_table.set_index('yyyymm')
    print("===== japan_table ======")
    print(japan_table)
    print("=======================")

    fv_UFileName = "미국(275)_해외방문객정보_2011_2016.json"
    jsonFV = json.loads(open(fv_UFileName, 'r', encoding='utf-8').read())
    usa_table = pd.DataFrame(jsonFV, columns=["yyyymm", 'visit_cnt'])
    usa_table = usa_table.rename(columns={'visit_cnt':"usa"})
    usa_table = usa_table.set_index("yyyymm")
    print("===== usa_table ======")
    print(usa_table)
    print("=======================")

    fv_table = pd.merge(china_table,japan_table, left_index=True, right_index=True)
    fv_table = pd.merge(fv_table, usa_table, left_index=True, right_index=True)
    print("===== fv_table ======")
    print(fv_table)
    print("=======================")

    r_list = []
    for tourpoint in resNm:
        r_list.append(setScatterGraph(tour_table, fv_table, tourpoint))

    r_table = pd.DataFrame(r_list, columns=['tourpoint', 'china', 'japan', 'usa'])
    r_table = r_table.set_index('tourpoint')
    r_table = r_table.drop('서울시립미술관 본관')
    r_table = r_table.drop('서대문자연사박물관')
    r_table.plot(kind='bar', rot=70) #막대그래프로 상관관계 표시
    plt.show()
    # plt.savefig('corretion.png') 저장하려면 이렇게 안에 파일명

if __name__ == "__main__":
    main()