import json
import re
from konlpy.tag import Okt
from collections import Counter
import matplotlib.pyplot as plt
import matplotlib
from matplotlib import font_manager
import pytagcloud #pygame, simplejson 모듈 추가로 설치 필요
import webbrowser

def showGraph(wordInfo):
    font_location = "C:\Windows\Fonts\malgun.ttf"
    font_name = font_manager.FontProperties(fname=font_location).get_name()
    matplotlib.rc('font', family=font_name)

    plt.xlabel('주요단어')
    plt.ylabel('빈도수')
    plt.grid(True)

    Sorted_Dict_Values = sorted(wordInfo.values(), reverse=True) # 단어수 내림차순 정렬
    Sorted_Dict_Keys = sorted(wordInfo, key=wordInfo.get, reverse=True) #키순(단어)으로 내림차순 정렬
    print("Sorted_Dict_Values:", Sorted_Dict_Values)
    print("Sorted_Dict_Keys:", Sorted_Dict_Keys)

    plt.bar(range(len(wordInfo)), Sorted_Dict_Values, align="center")
    plt.xticks(range(len(wordInfo)), list(Sorted_Dict_Keys), rotation='70') # 막대바 x축 라벨

    plt.show()

def saveWordCloud(wordInfo, filename):
    print("dict(wordInfo).items():", dict(wordInfo).items())
    #dict(wordInfo).items()를 가지고 color, size, tag가 담긴 딕셔너리 구성
    taglist = pytagcloud.make_tags(dict(wordInfo).items(), maxsize=80) # wordcloud의 가장 큰 글자의크기 maxsize로 설정
    print("taglist:", taglist)
    pytagcloud.create_tag_image(taglist, filename, size=(640, 480), fontname="korean", rectangular=False)
    webbrowser.open(filename)

def main():
    # 여기서 파일의 경로는 실제 JSON 데이터가 저장된 경로이다
    # openFileName = 'chosun_facebook_2016-10-01_2017-03-12.json'
    openFileName = 'jtbcnews_facebook_2016-10-01_2017-03-12.json'

    cloudimagePath = openFileName + ".jpg"
    rfile = open(openFileName, 'r', encoding='utf-8').read()
    jsonData = json.loads(rfile)
    message = ""

    for item in jsonData:
        if 'message' in item.keys():
            print("before message:", item['message'])
            message += re.sub(r'[^\w]', ' ', item['message']) + ' '
            # print("after message:", message)

    nip = Okt()
    nous = nip.nouns(message)
    print("nous:", nous)

    count = Counter(nous) # Counter() : 명사 단어수를 카운트해서 사전식(key=명사, value=빈도수) 객체로 변환하는 클래스
    print("count:", count)

    wordInfo = dict()

    # Counter에 있는 most_common(n) 메소드를 사용하면 상위 n개를 리턴해준다.
    for tags, counts in count.most_common(50):
        if len(str(tags)) > 1:
            wordInfo[tags] = counts
            print("%s : %d" % (tags, counts))

    showGraph(wordInfo)
    saveWordCloud(wordInfo, cloudimagePath)

if __name__ == '__main__':
    main()
