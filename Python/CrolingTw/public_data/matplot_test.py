# -*- coding:utf-8 -*-

import urllib.request
import datetime
import json
from public_data.config import *
import matplotlib.pyplot as plt
import matplotlib
from matplotlib import font_manager

def get_request_url(url):
    req = urllib.request.Request(url)
    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("[%s] Url Request Success!!!" % datetime.datetime.now())
            return response.read().decode('utf-8')
    except Exception as e:
        print(e)
        return None

def getNatVisitor(yyyymm, nat_cd, ed_cd):
    end_point = "http://openapi.tour.go.kr/openapi/service/EdrcntTourismStatsService/getEdrcntTourismStatsList"
    parameters = "?_type=json&serviceKey=" + access_key
    parameters += "&YM=" + yyyymm
    parameters += "&NAT_CD=" + nat_cd
    parameters += "&ED_CD=" + ed_cd

    url = end_point + parameters
    retData = get_request_url(url)
    print(retData)

    if retData == None:
        return None
    else:
        return json.loads(retData)

def main():
    jsonResult = []
    national_code = "275"
    ed_cd = "E"

    nStartYear = 2011
    nEndYear = 2017
    yyyymm = 0

    for year in range(nStartYear, nEndYear):
        for month in range(1, 13):
            yyyymm = "{0}{1:0>2}".format(str(year), str(month))

            jsonData = getNatVisitor(yyyymm, national_code, ed_cd)

            print(json.dumps(jsonData, indent=4, sort_keys=True, ensure_ascii=False))

            if jsonData['response']['header']['resultMsg'] == 'OK':
                krName = jsonData['response']['body']['items']['item']['natKorNm']
                krName = krName.replace(" ", "")
                iTotalVisitor = jsonData['response']['body']['items']['item']['num']
                print("%s_%s: %s" %(krName, yyyymm, iTotalVisitor))
                jsonResult.append({"nat_name":krName, "nat_cd":national_code,
                                   "yyyymm":yyyymm, "visit_cnt":iTotalVisitor})

    cnVisit = []
    VisitYM = []
    index = []
    i = 0
    for item in jsonResult:
        index.append(i)
        cnVisit.append(item['visit_cnt'])
        VisitYM.append(item['yyyymm'])
        i += 1

    with open("%s(%s)_해외방문객정보_%d_%d.json" %(krName, national_code, nStartYear, nEndYear-1), "w", encoding="utf-8") as outfile:
            retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
            outfile.write(retJson)

    font_location = "c:/Windows/fonts/malgun.ttf"
    font_name = font_manager.FontProperties(fname=font_location).get_name()
    matplotlib.rc('font', family=font_name)

    plt.xticks(index, VisitYM) #x축값 설정
    plt.plot(index, cnVisit) #cnVisit값이 y축에 나타남(index값은 plt.xticks()에 의해 무시됨)
    plt.xlabel('방문월')
    plt.ylabel('방문객수')
    plt.title("%s(%s)_해외방문객정보_%d_%d" %(krName, national_code, nStartYear, nEndYear-1))
    # plt.grid(True)
    plt.show()

if __name__ == '__main__':
    main()