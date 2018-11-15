from pandas import Series, DataFrame
import numpy as np

jul = '='*30
se1 = Series(np.arange(5.0), index=['a', 'b', 'c', 'd', 'e'])
print(se1)
print(jul)

se2 = se1.drop('c')
print(se2)
print(jul)

se2 = se1.drop(['b', 'd'])
print(se2)
print(jul)

data = {'state':['Ohio', 'Ohio', 'Ohio', 'Nevada', 'Nevada'],
        'year':[2000, 2001, 2002, 2001, 2002],
        'pop':[1.5, 1.7, 3.6, 2.4, 2.9]}
df = DataFrame(data, columns=['year', 'pop', 'state'], index=['00', '01', '02', '03', '04'])
print(df)
print(jul)
df2 = df.drop('04')
print(df2)
print(jul)
df2 = df.drop('pop', axis=1) # 열을 삭제할때는 axis 값 설정해야 함, axis 기본 default값은 0
print(df2)
print(jul)
df2 = df.drop(['02', '04'])
print(df2)
print(jul)