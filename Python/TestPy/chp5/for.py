jul = "="*10
fruit= ['apple', 'watermelon', 'peach', 'pear']
for m_f in fruit:
    print(m_f, end=" ")
print("\n")
t = [(1,2), (3,4), (5,6)]
for (a,b) in t:
    print(a+b)
print(jul)
dic = {"x":1, "y":2, "z":3}
for x in dic:
    print("key :", x, ", value :", dic[x])

print(jul)

for x in dic.values():
    print(x)
print(jul)
for a in t:
    print(a)

print(jul)

for x in 'abc':
    print(x)

print(jul)

for x in set('abcdfefdfwefdsff'):
    print(x)