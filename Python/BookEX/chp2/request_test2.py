import requests

r = requests.get("http://api.aoikujira.com/time/get.php")
text = r.text
print('type(text):', type(text))
print('text:', text)

bin = r.content
print('type(bin):', type(bin))
print('bin:', bin)

r2 = requests.get("http://wikibook.co.kr/wikibook.png")
with open("test.png", "wb") as f:
    f.write(r2.content)

print(r2)
print(type(r2))