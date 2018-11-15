from bs4 import BeautifulSoup
import urllib.request as req
import itertools

url = "http://www.cheogajip.co.kr/bbs/board.php?bo_table=store&page="
f = open("cheogazip_storelist.db", "w", encoding='utf-8')

for idx in itertools.count() :
    page_inx = idx+1
    if page_inx == 105 :
        print("Saved Success")
        break
    print(url+str(page_inx))
    f.write(url + str(page_inx)+"\n")
    res = req.urlopen(url + str(page_inx))
    soup = BeautifulSoup(res, 'html.parser')
    data_list = soup.select("tbody tr")
    # add_list = soup.select("td.td_subject")

    for tr_tag in data_list:
        td_tags = tr_tag.select("td")
        f.write("%s, %s, %s, %s\n" %(td_tags[0].string, td_tags[1].string, td_tags[2].string, td_tags[3].string))

    f.write("===========================\n")

f.close()
