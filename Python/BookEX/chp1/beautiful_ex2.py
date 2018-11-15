from bs4 import BeautifulSoup
import urllib.request as req

url = "http://rss.joins.com/joins_news_list.xml"
res = req.urlopen(url)

soup = BeautifulSoup(res, 'html.parser')
jul = '='*60
title = soup.select('item > title')
description = soup.select('item > description')
for ti, di in zip(title, description):
    print('title:', ti.string)
    print('description:', di.string)
    print(jul)

"""
for item in soup.findAll('item'):
    print("title:", item.title.string)
    print("description:", item.description.string)
    print(jul)
"""