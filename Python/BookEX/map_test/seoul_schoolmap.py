import folium
import pandas as pd
import urllib.request
import datetime
import json
import webbrowser
from map_test.config import *

def get_request_url(url):
    req = urllib.request.Request(url)
    req.add_header("X-Naver-Client-Id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode('utf-8')
    except Exception as e:
        print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return None

def getGeoData(address):
    base = "https://openapi.naver.com/v1/map/geocode"

    try:
        parameters = "?query=%s" % urllib.parse.quote(address)
    except:
        return None

    url = base + parameters
    retData = get_request_url(url)

    if retData == None:
        return None

    print("retData:", retData)

    jsonAddress = json.loads(retData)

    if 'result' in jsonAddress.keys():
        latitude = jsonAddress['result']['items'][0]['point']['y']
        longitude = jsonAddress['result']['items'][0]['point']['x']
    else:
        return None

    return [latitude, longitude]

def main():
    map = folium.Map(location=[37.5103, 126.982], zoom_start=12)

    filename = 'seoul_school.csv'
    df = pd.read_csv(filename, encoding='utf-8', index_col=0, header=0) #index_col = 0도 불러오겠다 column네임까지

    for index, row in df.iterrows(): # df.iterrow(): 데이터 행을 반복하며 인덱스와 데이터 반환
        if index == 20:
            break
        geoData = getGeoData(row['주소'])
        if geoData != None:
            folium.Marker(geoData, popup=row['학교명'], icon=folium.Icon(color='red')).add_to(map)

    svFilename = 'elementary_school.html'
    map.save(svFilename)
    webbrowser.open(svFilename)

if __name__ == '__main__':
    main()