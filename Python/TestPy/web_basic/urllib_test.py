import urllib.request

f = urllib.request.urlopen('http://www.python.org/')
print(f.read(300).decode('utf-8'))

local_filename, headers = urllib.request.urlretrieve('http://www.python.org/')
html = open(local_filename)
print(html.name) # 저장된 파일이름 출력