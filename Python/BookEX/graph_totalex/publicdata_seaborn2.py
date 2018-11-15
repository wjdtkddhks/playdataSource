import matplotlib.pyplot as plt
from matplotlib import font_manager
import seaborn as sns
import pandas as pd
import json
import matplotlib

def eachGraph(file_name):
    font_location = "c:/windows/fonts/malgun.ttf"
    font_name = font_manager.FontProperties(fname=font_location).get_name()
    matplotlib.rc("font", family=font_name)

    title = file_name[:2]
    print(title)

    jsonFV = json.loads(open(file_name, 'r', encoding='utf-8').read())
    data_table = pd.DataFrame(jsonFV, columns=['yyyymm', 'visit_cnt'])
    print(data_table)
    data_table.yyyymm = pd.to_datetime(data_table.yyyymm, format="%Y%m")
    data_table['year'] = data_table.yyyymm.dt.year
    data_table['month'] = data_table.yyyymm.dt.month

    data_table = data_table.set_index(["month", "year"])["visit_cnt"].unstack(fill_value=0)
    heat = sns.heatmap(data_table)
    plt.title(title)
    plt.show()

    return data_table, title

def main():
    file_list = ["중국(112)_해외방문객정보_2011_2016.json",
                 "일본(130)_해외방문객정보_2011_2016.json",
                 "미국(275)_해외방문객정보_2011_2016.json"]

    table_list = []
    title_list = []

    for file in file_list:
        table, title = eachGraph(file)
        table_list.append(table)
        title_list.append(title)

    print(table_list)
    print(title_list)
    number = len(table_list)
    print(number)

    plt.figure()
    plt.suptitle('외국인 방문객 분석')
    i = 1
    for table, title in zip(table_list, title_list):
        plt.subplot(1, number, i)
        plt.title(title)
        sns.heatmap(table)
        i += 1

    plt.show()

if __name__ == '__main__':
    main()