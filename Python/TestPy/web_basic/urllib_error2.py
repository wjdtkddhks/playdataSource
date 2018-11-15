import urllib.request

req = urllib.request.Request('http://www.python.org/index.html')
try:
    urllib.request.urlopen(req)
except urllib.error.URLError as e:
    print(e.code)
    print(e.read(400).decode())