import urllib.request

url = "http://uta.pw/shodou/img/28/214.png"
savename = "test.png"

urllib.request.urlretrieve(url, savename) # urlretrieve > 직접 파일로 다운
print('%s 저장되었습니다.' % savename)