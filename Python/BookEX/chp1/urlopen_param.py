import urllib.request
import urllib.parse

API = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp"
values = {
    'stnld' : 108
}
param = urllib.parse.urlencode(values)
url = API + "?" + param
print("url=", url)

data = urllib.request.urlopen(url).read().decode('utf-8')
print(data)