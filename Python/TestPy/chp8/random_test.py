# -*- coding:utf-8 -*-
from random import *

# seed(1) seed값이 주어지면 값이 동일, 시드가 따로 안 주어지면 시스템 시간이 시드가 됨
print('random:',random())
print('uniform:',uniform(1, 100))
print('randint:',randint(1, 100))
print('choice:',choice("123456789abcdefgh"))
sample_list = ['python', "java", 'c++', 'random', 'spring']
shuffle(sample_list)
print('after shuffle:',sample_list)
print('sample:', end=" ")
for i in sample(sample_list, 2):
    print(i, end=" ")