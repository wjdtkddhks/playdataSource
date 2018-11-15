import if_test

jul = "="*20

r=list(range(10))
r1=list(range(2,8))
r2=list(range(2,20,3))
print("r :", r)
print("r1 :", r1)
print("r2 :", r2)

a=2
b=8
r=list(range(a, b, a))
print("r :", r)

print(jul)

fruit = ['apple', 'banana', 'orange','grape']
dic={"x":1, "y":2, "z":3}

for i in range(len(fruit)):
    print("%s. %s"%(i,fruit[i]), end=" ")
print()
for s in enumerate('abc'):
    print(s, end=" ")
print()
for i, res in enumerate(fruit, 100):
    print(i, res, end=" ")
print()
for i in enumerate(fruit, 100):
    print(i, end=" ")
print()
for i in enumerate(dic, 100):
    print(i, end=" ")
print()
print(jul)

for x, y in zip([1,2,3], [10,20,30]):
    print(x+y, end=" ")
print()
for x, y, z in zip([1,2,3], ['a'], [10,20,30]):
    print(x+z, y, z, end=" ")
print()

print(list(zip({'a':1, 'ad':2, 'c':3}, [1,2,3])))

print(list(zip('abc', ['z', 'y', 'x'])))

keys =['cat', 'dog', 'duck']
values =['야옹', '멍멍', '꽥꽥']
print(zip(keys, values))

print(jul)

dic1 = {'one': 1, 'two':2, 'three': 3}
for key, value in dic1.items():
    print(key, value)