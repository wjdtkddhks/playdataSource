# -*- coding:utf-8 -*-

print(192, 168, 145, sep="/")
print(192,168,145)
print('no new line', end='\t')
print('yes')
print("=============================")
print("%10.3e"%(123.5678))
print("%010o"%97)
print("%10.5o"%97)
print("%5x"%97)
print("%5.4x"%97)
print("=============================")
x=1.23456789
print("%-6.2f %05.2f %+06.1f"%(x,x,x))
print("only one percentage sign: %")
print("=============================")
a='apple'
b='banana'
c=('a', 'b', a)
d=set([1,2,3])
print('{0} and {1} and {2}'.format(a,c,d))
print('{who} and {who1}'.format(who=d, who1=c))
print("{0:<10}{1:5.2f}".format('apple:', 6.99))
print("{0:p^10}{1:<7.3f}".format('apple:', 6.99))
print("=============================")
s='python'
print(s.center(10,"*"))
print(s.ljust(10,"*"))
print(s.rjust(10,"*"))
print(s.zfill(10))
print("=============================")
str =input("input   nic_name : ")
print("U's nic_name : {0}".format(str))

va1=list(input("list output : "))
print(va1)

a=int(input("input a : "))
b=int(input("input b : "))
hap = a+b
print("hap : ", hap)
