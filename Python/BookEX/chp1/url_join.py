from urllib.parse import urljoin

base = "http://example.com/html/a.html"

print("1:", urljoin(base, "b.html"))
print("2:", urljoin(base, "sub/c.html")) #sub는 해당 경로에서 하위 폴더]
print("3:", urljoin(base, "../index.html"))
print("4:", urljoin(base, "../img/hoge.png"))
print("5:", urljoin(base, "../css/hoge.css"))
print("6:", urljoin(base, "/hoge.html"))
print("7:", urljoin(base, "http://otherExample.com/wiki")) # http://로 시작하면 base경로 무시하고 절대경로로 잡힘.
print("8:", urljoin(base, "//anotherExample.org/test"))