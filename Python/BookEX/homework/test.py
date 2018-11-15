from bs4 import BeautifulSoup
import urllib.request as req
from datetime import *

# url = "https://music.bugs.co.kr/chart/track/realtime/total?chartdate=20180906"
#
# response = req.urlopen(url)
# soup = BeautifulSoup(response, "html.parser")
#
# singer = soup.select("td.left > p.artist > a:nth-of-type(1)")
#
# for s in singer:
#     print(s.string)

start = input('조회할 시작날짜 입력(ex) yyyymmnn = 20170910) => ')
end = input('조회할 종료날짜 입력(ex) yyyymmnn = 20170910) => ')

startDate = datetime.strptime(start, "%Y%m%d")
endDate = datetime.strptime(end, "%Y%m%d")
count = timedelta(days=1)
print(startDate-endDate)
if startDate-endDate == timedelta(days=0) :
    print('good')