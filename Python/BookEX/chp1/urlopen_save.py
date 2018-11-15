import urllib.request

url = "http://uta.pw/shodou/img/28/214.png"
savename = "test.png"

mem = urllib.request.urlopen(url).read()
# urlopen()은 파일로 저장이 아니라 데이터를 파이썬 메모리위에 올림(변수에 저장)
# 1.urlopen()으로 url 리소스 열고 2.read()로 데이터 읽어들임

with open(savename, "wb") as f:
    f.write(mem)

print("%s Saved" % savename)