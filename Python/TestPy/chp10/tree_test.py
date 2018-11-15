# -*- coding:utf-8 -*-
import xml.etree.ElementTree

friend = xml.etree.ElementTree.parse('myfriend.xml')
friends = friend.findall("address")
print('friends:', friends)
for res in friends:
    print(res.find('name').text, ":", res.find('addr').text)

print('============')
iter_friend = friend.getiterator(tag="name")
print('iter_friend:', iter_friend)
for r in friend.getiterator(tag="name"):
    print('iterator:', r.text)