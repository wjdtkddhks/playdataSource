# -*- coding:utf-8 -*-
import json

jsonData = """
{
    "snapshot" : {
        "repos": "test.com/repositories/snapshots",
        "userId": "id",
        "passwd": "1234"
    },
    "release":{
        "repos": "test.com/repositories/release",
        "userId": "id",
        "passwd": "5678"
    },
    "component":{
        "test":"test.com"
    }
}
"""

data_json = json.loads(jsonData)
print('data_json.type:', type(data_json))
print('data_json:', data_json)
print('test:', data_json["component"]["test"])
data_str = json.dumps(data_json)
print('after dumps.type:', type(data_str))
print('after dumps:', data_str)