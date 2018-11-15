import numpy as np
import pandas as pd

s = pd.Series(np.random.randn(5))
print(s)
print()

s = pd.Series(np.random.randn(5), index=['a', 'b', 'c', 'd', 'e'])
print(s)
print()

d = {'a': 0, 'b':1, 'c':2}
print(pd.Series(d))
print()

print(pd.Series(d, index=['a', 'c', 'B', 'b'])) # index에서 설정 순서대로 나옴, 없으면 Nan으로 나옴
print()

print(pd.Series(7, index=['a', 'b', 'c', 'd', 'e']))
print()

s = pd.Series([1,2,3,4,5], index=['a', 'b', 'c', 'd', 'e'])
print(s)
print("s[0]:", s[0])
print("s['a']:", s['a'])
print("s[:3]", s[:3])
print("s[[4,1]]", s[[4,1]])
print()

print(np.power(s, 2))

