from bs4 import BeautifulSoup
from bs4 import UnicodeDammit
import urllib.request as req

url = "http://info.finance.naver.com/marketindex/"
res = req.urlopen(url)
soup = BeautifulSoup(res, 'html.parser')
print(soup.original_encoding)
country = soup.select("h3.h_lst > span.blind")
money = soup.select("div.point_up > span.value")
print(type(country))
for co, mo in zip(country, money):
    new_co = UnicodeDammit.detwingle(co.string)
    print("%s : %s" %(new_co, mo.string))