# -*- coding:utf-8 -*-
from public_data.config import *
import urllib.request
import datetime
import json
import math

def get_request_url(url):
    req = urllib.request.Request(url)

    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode('utf-8')
        else:
            print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
            return None

    except Exception as e:
        print(e)
        return None

def getTourPointVisitor(yyyymm, sido, gungu, nPagenum, nItems):
    end_point = "http://openapi.tour.go.kr/openapi/service/TourismResourceStatsService/getPchrgTrrsrtVisitorList"

    parameters = "?_type=json&serviceKey=" + access_key
    parameters += "&YM=" + yyyymm
    parameters += "&SIDO=" + urllib.parse.quote(sido)
    parameters += "&GUNGU=" + urllib.parse.quote(gungu)
    parameters += "&RES_NM=&paegNo=" + str(nPagenum)
    parameters += "&numOfRows=" + str(nItems)

    url = end_point + parameters
    retData = get_request_url(url)

    if retData == None:
        return None
    else:
        print(retData)
        return json.loads(retData)

def getTourPointData(item, yyyymm, jsonResult):
    addrCd = 0 if 'addrCd' not in item.keys() else item['addrCd']
    gungu = '' if 'gungu' not in item.keys() else item['gungu']
    sido = '' if 'sido' not in item.keys() else item['sido']
    resNm = "" if 'resNm' not in item.keys() else item['resNm']
    rnum = 0 if 'rnum' not in item.keys() else item['rnum']
    ForNum = 0 if 'csForCnt' not in item.keys() else item['csForCnt']
    NatNum = 0 if 'csNatCnt' not in item.keys() else item['csNatCnt']
    jsonResult.append({'yyymm':yyyymm, 'addrCd':addrCd, 'gungu':gungu,
                       "sido":sido, "resNm":resNm, "rnum":rnum, "ForNum":ForNum, "NatNum":NatNum})

    return

def main():
    jsonResult = []

    sido = "서울특별시"
    gungu = ''
    nItems = 100
    nStartYear = 2016
    nEndYear = 2017

    try:
        for year in range(nStartYear, nEndYear):
            for month in range(1, 13):
                yyyymm = "{0}{1:0>2}".format(str(year), str(month))
                nPagenum = 1

                while True:
                    jsonData = getTourPointVisitor(yyyymm, sido, gungu, nPagenum, nItems)
                    if jsonData['response']['header']['resultMsg'] == 'OK' :
                        nTotal = jsonData['response']['body']['totalCount']

                        if nTotal == 0:
                            break
                        for item in jsonData['response']['body']['items']['item']:
                            getTourPointData(item, yyyymm, jsonResult)

                        nPage = math.ceil(nTotal/ 100)
                        if nPagenum == nPage:
                            break

                        nPagenum += 1

                    else:
                        break

        with open('%s_관광자입장정보_%d_%d.json' % (sido, nStartYear, nEndYear), 'w', encoding='utf-8') as outfile:
            retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
            outfile.write(retJson)

    except AttributeError as e :
        print(e.args)

    print('%s_관광자입장정보_%d_%d.json Saved' % (sido, nStartYear, nEndYear))

if __name__ == '__main__':
    main()