# -*- coding:utf-8 -*-
import json

class jsonObject:
    def __init__(self, d):
        self.__dict__ = d

if __name__ == '__main__':
    f = open('./student.json', 'rt')
    data = json.loads(f.read(), object_hook=jsonObject)
    f.close()
    for student in data.student:
        print('%s : 총 %d점'%(student.name, (student.score.kor+student.score.eng+student.score.math)))