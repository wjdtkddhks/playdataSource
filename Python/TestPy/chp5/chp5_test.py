# -*- coding:utf-8 -*-

while True :
    str = input("Enter word :")
    if str == 'quit':
        print('program quit')
        break;
    elif len(str) < 5:
        print('Too small')
    else:
        print(str)