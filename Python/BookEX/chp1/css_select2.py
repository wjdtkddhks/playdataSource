from bs4 import BeautifulSoup
fp = open('fruits-vegetables.html', encoding='utf-8')
soup = BeautifulSoup(fp, 'html.parser')

print(soup.select_one("li:nth-of-type(8)").string)
print(soup.select_one("#ve-list > li:nth-of-type(4)").string)
print(soup.select("#ve-list > li[data-lo='us']")[1].string)
print(soup.select("#ve-list > li.black")[1].string)

cond = {"data-lo":"us", "class":"black"}
print(soup.find("li", cond).string) #find에 추가정보 지정, li태그찾고, cond정보에 해당하는 부분 찾음.
print(soup.find(id="ve-list").find("li", cond).string)