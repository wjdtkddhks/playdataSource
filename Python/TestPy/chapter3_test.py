# -*- coding:utf-8 -*-

mylist =[]
mylist.append(5);mylist.append(10);mylist.append(8);mylist.append(9)
print(mylist)
mylist.remove(mylist[0])
print(mylist)
mylist.insert(1, [10,20,30])
print(mylist)
print("==============================")
a=[10,20,30,40,50]
a.reverse()
print(a)
b=a.copy()
print(b)
print("==============================")
a_list=['a', 'd', 'f']
a_list[1:1] = ['b', 'c']
print(a_list)
a_list[-1] = 'e'
print(a_list)
a_list[-1] = [10,20,30,40]
print(a_list)
print(a_list[1:1])