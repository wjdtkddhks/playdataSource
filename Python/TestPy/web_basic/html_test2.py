# -*- coding:utf-8 -*-
import http.client

conn = http.client.HTTPConnection('www.python.org')
conn.request('GET', '/')
res = conn.getresponse()
msg = res.msg # HttpMessage 객체를 리턴 받는다

print('type(msg):',type(msg))
print('msg.as_string():')
print('=====================')
print(msg.as_string()) #리턴 받은 것을 문자열로 출력한다.
print('=====================')
for key in msg.keys():
    print(key + ", " + msg.get(key))
conn.close()