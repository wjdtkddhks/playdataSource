import json
import folium
import pandas as pd
import urllib.request
import webbrowser
from map_test.config import *

def get_request_url(url):
    req = urllib.request.Request(url)
    req.add_header("X-Naver-Client-Id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("success")
            return response.read().decode('utf-8')
    except Exception as e:
        print(e)
        print("Error")
        return None

def get_mapInfo(address):
    base = "https://openapi.naver.com/v1/map/geocode"

    try:
        parameters = "?query=%s" % urllib.parse.quote(address)
    except:
        return None

    url = base + parameters
    retData = get_request_url(url)
    print("retData:", retData)

    if retData == None:
        return None

    jsonAddress = json.loads(retData)

    if 'result' in jsonAddress.keys():
        latitude = jsonAddress['result']['items'][0]['point']['y']
        longitude = jsonAddress['result']['items'][0]['point']['x']
    else:
        return None

    return [latitude, longitude]

def main():
    map = folium.Map(location=[37.5103, 126.982], zoom_start=12)

    file_list = ["cheogajip_table2.csv", "goobne_table2.csv", "kyochon_table2.csv", "pericana_table2.csv"]
    color_list = ["black", "red", "orange", "blue"]
    file_name = "chickenstore_map.html"

    for file, color in zip(file_list, color_list):
        csv_data = pd.read_csv(file, encoding='utf-8', index_col=0, header=0)

        for index, data in csv_data.iterrows():
            if data['sido'] == '서울특별시':
                mapData = get_mapInfo(data['store_address'])
                if mapData != None:
                    folium.Marker(mapData, popup=(file.split("_")[0] + "_" + data['store']), icon=folium.Icon(color=color)).add_to(map)


    map.save(file_name)
    webbrowser.open(file_name)

if __name__ == "__main__":
    main()
