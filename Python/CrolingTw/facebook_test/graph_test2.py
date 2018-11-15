# -*- coding:utf-8 -*-

import facebook, json

obj = facebook.GraphAPI(access_token="EAAHHcm1Iy9EBAFssCLudpDcHo5FUeSa7dzeHzZCK15SaVVZBuEkKTn2VmAEqsbyVcCIz3opOwKuZA7qSBN8hlSYHrx1zycpa78gATq4QouuzZAkh6Ffe09ZAVGGbwdffQCQAPZCP9WX3HfICM6vvRG9GrUIt1DvlIbC6xZAseEJ2TDHXmdszJ7YAjZAj4fvpt6zYRvhQ2XvZB7gZDZD", version="3.0")

res = obj.get_connections(id="me", connection_name="posts", limit=10)
f = open("facebook_posts.txt", "wt")
print(res)
for data in res["data"]:
    print(data)
    #print(data["id"], end=", ")
    #print(data["created_time"], end=", ")
    #print(data["message"])

res_j = json.dumps(res, indent=3)
f.write(res_j)

#feed?fields=attachments,message,picture,link,name,caption,description,source