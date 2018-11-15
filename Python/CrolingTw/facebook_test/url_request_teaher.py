# -*- coding:utf-8 -*-
import urllib.request
import json
import datetime

def get_request_url(url):
    req = urllib.request.Request(url)

    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode("utf-8")
    except Exception as e:
        print(e)
        print("[%s] Error for url : %s" % datetime.datetime.now(), url)

if __name__ == '__main__':
    base = "https://graph.facebook.com/v3.1/"
    id= "1103817353103042"
    fields = "attachments,message,picture,link,name,caption,description,source"
    access_token = "500769250397137|6pVGexBLViHGs8SWjS7hbDhh1P4"
    limit = "10"

    url = base + id + "/feed?fields=" + fields + "&access_token=" + access_token + "&limit=" + limit

    res = get_request_url(url)
    json_res = json.loads(res)

    # f = open("facebook_url.json", "w", encoding="utf-8")

    print(json_res)
    # f.write(json.dumps(res))
    print("=========================================")
    for res in json_res["data"]:
        print(res)

        for key in res:
            print(key, ":", res[key])