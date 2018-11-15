# -*- coding:utf-8 -*-
import urllib.request

response = urllib.request.urlopen('http://www.python.org')
print('response:', response)
print('url:', response.geturl())
headers = response.info()
print('date:', headers['date'])
print('headers:')
print('============')
print(headers)
print('============')
data = response.read()
print('length:', len(data))
print('data:')
print('============')
print(data.decode())
print('============')