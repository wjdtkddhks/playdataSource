from bs4 import BeautifulSoup

html = """
<html><body>
    <h1 id="title">스크레이핑이란?</h1>
    <p id="body" class="abc ddd">웹 페이지를 분석하는 것</p>
    <p>원하는 것을 추출하는 것</p>
</body></html>
"""

soup = BeautifulSoup(html, 'html.parser') # 1매개변수에는 분석할 것, 2매개변수에는 분석기종류 > BeautifulSoup 객체생성

title = soup.find(id="title")
body = soup.find(id="body")
print("#title=", title.string)
print("#body=", body.string)
print(body['class'])
print(title.attrs)
print(body.attrs)