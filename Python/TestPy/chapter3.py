# -*-coding:utf-8 -*-

mystring = 'helloworld!'
print(mystring[0:5])
print(mystring[0:-6])
print(mystring[0:-7])
print('======================')
mystr = 'My name in python'
print(mystr[0:2])
print(mystr[3:])
print(mystr[:7])
print(mystr[0:-6])
print(mystr[-6:])
print(mystr[::])
print(mystr[::2])
print(mystr.upper())
print(len(mystr))
print(mystr.count('name'))
print(mystr.split())
print('===========tuple===========')
my_tuple = ('파이썬', (8,4,5), [1,2,3])
print(my_tuple[0][2])
print(my_tuple[1][2])
print(my_tuple[0:2])
print(my_tuple[::-1])
print(my_tuple.count(1))
print('===========list===========')
mylist=['a', 'b', [3.58, 'd', 4, '가']]
print('b' in mylist)
print('가' not in mylist)
print('d' in mylist[2])
print('pop 전:',mylist)
print(mylist.pop())
print('pop 후:',mylist)

mylist2 = ['a', 'd','f','z']
mylist2.sort()
print(mylist2)
print('===========set===========')
myset = {'a', 2, (1,2)}
print(type(myset))
print(myset)
print(tuple(myset))
print(type(tuple(myset)))