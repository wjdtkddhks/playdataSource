from bs4 import BeautifulSoup

html = """
<html><body>
    <ul>
        <li><a href="www.naver.com">네이버</a></li>
        <li><a href="www.daum.net">다음</a></li>
    </ul>
</body></html>
"""
soup = BeautifulSoup(html, 'html.parser')

lis = soup.find_all("a")
print(lis)
for a in lis:
    # href = a.attrs['href']
    href = a['href']
    text = a.string
    print('%s > %s' % (text, href))

print("=============================")
lis = soup.find('a') # 여러개라도 첫번째 하나만 반환
print(lis)
print('%s > %s' % (lis.string, lis['href']))