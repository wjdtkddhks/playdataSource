import urllib.request
from bs4 import BeautifulSoup
import datetime
import pandas as pd
from itertools import count

def get_request_url(url, enc='utf-8'):
    req = urllib.request.Request(url)

    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            try:
                rcv = response.read()
                ret = rcv.decode(enc)
            except UnicodeDecodeError:
                ret = rcv.decode(enc, 'replace')

            return ret

    except Exception as e:
        print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None

def KyochonAddress(sido1, result):

    for sido2 in count():
        Kyochon_URL = "http://www.kyochon.com/shop/domestic.asp?txtsearch=&sido1=%s&sido2=%s" % (str(sido1), str(sido2))
        print(Kyochon_URL)

        try:
            rcv_data = get_request_url(Kyochon_URL)
            soupData = BeautifulSoup(rcv_data, 'html.parser')

            storeTable = soupData.find(class_='list')
            store_trs = storeTable.findAll('dl')

            if store_trs :
                for store_tr in store_trs:
                    tr_tag = list(store_tr.strings)
                    if tr_tag[0] == '게시물이 없습니다.':
                        return

                    store_name = str(tr_tag[1])
                    store_address = str(tr_tag[3]).strip()
                    store_sido_gu =store_address.split()[:2]
                    store_address += str(tr_tag[4]).strip()
                    # print([store_name] + store_sido_gu + [store_address])
                    result.append([store_name] + store_sido_gu + [store_address])
        except:
            break

    return

def main():
    result = []

    print('KYOCHON ADDRESS CRAWLING START')
    for sido1 in range(1, 18):
        KyochonAddress(sido1, result)

    kyochon_table = pd.DataFrame(result, columns=('store', 'sido', 'gungu', 'store_address'))
    kyochon_table.to_csv("kyochon.csv", encoding="utf-8", mode='w', index=True)
    del result[:]

    print('FINISHED')

if __name__ == '__main__':
    main()