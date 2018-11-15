import urllib.request

url = "http://api.aoikujira.com/ip/ini"
res = urllib.request.urlopen(url)
data = res.read() # read()로 읽어들인 데이터는 바이너리 타입
text = data.decode('utf-8')

print(data)
print("=======================")
print(text)