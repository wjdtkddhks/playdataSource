import json

s=u'''{"name":"Ruru",
"brothers":["Ruse", "Ruo"],
"addr": "Toronto"}'''

class JsonObject:
    def __init__(self, d):
        self.__dict__ = d

if __name__ == '__main__':
    data = json.loads(s, object_hook=JsonObject)
    print(type(data.name))
    print(data.name)
    print(data.addr)
    print(type(data.brothers))
    for brother in data.brothers:
        print(brother)