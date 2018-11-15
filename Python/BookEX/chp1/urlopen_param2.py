import sys
import urllib.request as req
import urllib.parse as parse

if len(sys.argv) <=1 :
    print('USAGE: download-forecast-argv <Region Number>')
    sys.exit() # quit()
regionNum = sys.argv[1]
#sys.argv[0] > 스크립트 이름,

values = {
    'stnld' : regionNum
}
param = parse.urlencode(values)

API = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
url = API + "?" + param
print("url=", url)
data = req.urlopen(url).read().decode('utf-8')
print(data)