# -*- coding:utf-8 -*-
class AgeException(Exception):
    def __init__(self, msg):
        self._message = msg

def input_age():
    age = int(input('나이를 입력해주세요: '))

    if age<0:
        raise AgeException('나이는 음수가 될수 없습니다.')
    elif age >150:
        raise AgeException('150세이상 살 수 있을까요?')
    else:
        return age

if __name__ == '__main__':
    try:
        age = input_age()
    except AgeException as e:
        print(e.args[0])
        print(e.args)
    else:
        print("나이는 %d세입니다."%age)