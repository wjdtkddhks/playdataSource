# -*- coding:utf-8 -*-
import xml.etree.ElementTree as et

tree = et.ElementTree(file="fruit.xml")
root = tree.getroot()
print('root.tag:', root.tag)
print('root[0].tag:', root[0].tag)
print('root[0][0].tag:', root[0][0].tag)
for child in root:
    print('tag:', child.tag, ', attributes:', child.attrib)
    for grandchild in child:
        print('\ttag:', grandchild.tag, ', attribute:', grandchild.attrib)

print('=================================')
for child in root:
    print('tag:', child.tag, ', attributes:', child.attrib)
    for grandchild in child:
        print('\ttag:', grandchild.tag, ', attribute:', grandchild.attrib, grandchild.text)