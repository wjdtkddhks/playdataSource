from bs4 import BeautifulSoup
import urllib.request as req
from datetime import *

# https://music.bugs.co.kr/chart/track/realtime/total?chartdate=20170910
rank_list = []
start = input('조회할 시작날짜 입력(ex) yyyymmnn = 20170910) => ')
end = input('조회할 종료날짜 입력(ex) yyyymmnn = 20170910) => ')

startDate = datetime.strptime(start, "%Y%m%d")
endDate = datetime.strptime(end, "%Y%m%d")
count = timedelta(days=1)
print(startDate-endDate)

def url_process(url_date):
    url = "https://music.bugs.co.kr/chart/track/realtime/total?chartdate=" + url_date
    print(url)
    response = req.urlopen(url)
    soup = BeautifulSoup(response, 'html.parser')
    rank_tag = soup.select("div.ranking > strong")
    title_tag = soup.select("p.title > a")
    singer_tag = soup.select("td.left > p.artist > a:nth-of-type(1)")

    for rank, title, singer in zip(rank_tag, title_tag, singer_tag):
        rank_list.append(url_date + ", " + rank.string + "등:" + singer.string + ", " + title.string +"\n")

    rank_list.append("===========================================================\n")

def save_file():
    with open("bugsChart.db", 'w', encoding='utf-8') as outfile:
        for data in rank_list:
            outfile.write(data)


while True:
    # print(startDate.strftime("%Y%m%d"))
    url_date = startDate.strftime("%Y%m%d")
    url_process(url_date)
    startDate += count

    if startDate-endDate == timedelta(days=0):
        url_date = startDate.strftime("%Y%m%d")
        url_process(url_date)
        break

save_file()