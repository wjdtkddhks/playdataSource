# -*- coding:utf-8 -*-
from xml.dom.minidom import parse

dom_doc = parse('movies.xml')
movies = dom_doc.getElementsByTagName('movie')
print("movies:", movies)
print("len(movies):", len(movies))
for index in range(len(movies)):
    type = movies[index].getElementsByTagName('type')
    description = movies[index].getElementsByTagName('description')
    print(type[0].firstChild.data, ":", description[0].firstChild.data)

for index in dom_doc.getElementsByTagName('type'):
    print('type:', index.firstChild.data)