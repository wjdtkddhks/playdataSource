# -*- coding:utf-8 -*-
import urllib.request, json, pickle

url = "https://graph.facebook.com/v3.1/1103817353103042/feed?fields=attachments,message,picture,link,name,caption,description,source&format=json&access_token=500769250397137|6pVGexBLViHGs8SWjS7hbDhh1P4&limit=5&__paging_token=enc_AdApd7618ZCt6j8nROTHtmI3o6zysO4CcP525HZBj6eeM87YNbMg9fhGpPszFnpGzARXZB8tmCYgnKepRdrcw5iIPQ8L66nhABcazQSmO5unZC7x0QZDZD"

request_url = urllib.request.Request(url)
data = urllib.request.urlopen(request_url)
if data.getcode() == 200:
    print("Bring data Success!!")
    data = json.loads(data.read().decode('utf-8'))

else:
    print("Bring data failure")

for d in data['data']:
    print(d)
    print("============================================")
# f = open('facebook_url', 'wb')
# pickle.dump(data, f)