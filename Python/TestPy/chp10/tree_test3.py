# -*- coding:utf-8 -*-
import xml.etree.ElementTree as et

tree = et.ElementTree(file="fruit.xml")
root = tree.getroot()

for basket02 in root.iter('basket'):
    if basket02.attrib["classfication"] == 'vegetable':
        print('\t채소:', basket02.attrib['name'])
    else:
        print('\t과일:', basket02.attrib['name'])