import http.client

conn = http.client.HTTPConnection('www.daum.net')
conn.request('POST', '/index.html')
# conn.request('GET', '/index.html')
res = conn.getresponse()
print('status:', res.status, ', reason:', res.reason)
data = res.read()
print(len(data))
print(data.decode())