# -*- coding:utf-8 -*-
import xml.etree.ElementTree as et

tree = et.ElementTree(file='fruit.xml')
root = tree.getroot()
for origin in root.findall('origin'):
    if origin.attrib['name'] == 'Andes':
        origin.set('name', 'Canada')
    quantity = int(origin.find('quantity').text)
    price = int(origin.find('price').text)

    if quantity < 5 :
        root.remove(origin)

    total = quantity * price
    for res in origin.findall('basket'):
        print(res.get('name'), format(total, ','))

tree.write('fruit_res.xml', encoding="utf-8", xml_declaration=True)