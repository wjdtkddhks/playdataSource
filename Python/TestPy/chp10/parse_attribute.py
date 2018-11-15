from xml.dom.minidom import parse

xmldoc = parse('items.xml')
itemlist = xmldoc.getElementsByTagName('item')
print('itemlist:', itemlist)

for item in itemlist:
    print(item.attributes['name'].value)