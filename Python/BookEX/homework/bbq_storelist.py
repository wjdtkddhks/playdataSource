from bs4 import BeautifulSoup
import urllib.request as req
from selenium import webdriver

br = webdriver.Chrome("C:\BigDeep\ChromeDriver\chromedriver.exe")
br.implicitly_wait(3)
url = "https://www.bbq.co.kr/page/order/store-search.asp"
br.get(url)
frame_source = br.find_elements_by_css_selector("iframe")
for fr in frame_source:
    if fr.get_attribute("name") == "ifrmExec":
        url2= fr.get_attribute("src")

response = req.urlopen(url2)
soup = BeautifulSoup(response, 'html.parser')

name_list = soup.select("div.storeNearyByItem-title > span:nth-of-type(1)")
add_list = soup.select("div.storeNearyByItem-address")
tel_list = soup.select("a.storeNearyByItem-tel")

for name, add, tel in zip(name_list, add_list, tel_list):
    print("지점명: %s, 주소:%s, 전화번호:%s" % (name.string, add.string, tel.string))


