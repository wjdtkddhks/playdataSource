# -*- coding:utf-8 -*-
from xml.dom.minidom import parse, parseString

dom = parse('myfriend.xml')
for name in dom.getElementsByTagName('name'):
    print(name.firstChild.data)

print('===============')
datasource = open('myfriend.xml')
dom2 = parse(datasource)
for name in dom.getElementsByTagName('addr'):
    print(name.firstChild.data)
