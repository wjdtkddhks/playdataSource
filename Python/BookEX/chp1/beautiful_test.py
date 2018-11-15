from bs4 import BeautifulSoup #https://www.crummy.com/software/BeautifulSoup/

html = """
<html><body>
    <h1>스크레이핑이란?</h1>
    <p>웹 페이지를 분석하는 것</p>
    <p>원하는 것을 추출하는 것</p>
</body></html>
"""

soup = BeautifulSoup(html, 'html.parser') # 1매개변수에는 분석할 것, 2매개변수에는 분석기종류 > BeautifulSoup 객체생성

h1 = soup.html.body.h1
p1 = soup.html.body.p
p2 = p1.next_sibling.next_sibling
block = p1.next_sibling #첫번째 next_sibling은 줄바꿈.공백임
print(type(h1))
print(h1)
print(block, end="")
print("h1 =", h1.name)
print("p1 =", p1.string)
print("p2 =", p2.string)