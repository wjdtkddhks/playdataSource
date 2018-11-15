import pandas as pd

d = {'one': pd.Series([1,2,3], index=['a', 'b', 'c']), 'two':pd.Series([1,2,3,4], index=['a','b','c','d'])}
print(d)
print(d['one'])
print(d['one'][0])
print('1==========================')

df = pd.DataFrame(d)
print(df)

print('2==========================')
d = {'one': pd.Series([1,2,3]), 'two':pd.Series([1,2,3,4])}
df = pd.DataFrame(d)
print(df)

print('3==========================')
d = {'one':[1,2,3,4], 'two':[4,3,2,1]} # pd.Series 객체로 안하면 갯수 맞춰줘야 함.
df = pd.DataFrame(d)
print(df)

print('4==========================')
data2 = [{'a':1, 'b':2}, {'a':5, 'b':10, 'c':20}] # key가 DataFrame에서 column으로 작용.
print(pd.DataFrame(data2))
print('5==========================')
print(pd.DataFrame(data2, index=('first', 'second')))
print('6==========================')
print(pd.DataFrame(data2, columns=('a', 'b'), index=('first', 'second')))

print('7==========================')
pf = pd.DataFrame(data2, columns=('a', 'b'), index=('first', 'second'))
print(pf.rename(columns={'a':'col1', 'b':'col2'}))
print('8==========================')
print(pf.set_index("b"))

print('9==========================')
data1 = [{"name":"mark"}, {"name":"Eric"}, {"name":"Jennifer"}]
df1 = pd.DataFrame(data1)
print(df1)
print('10==========================')
df1['age'] = [10,11,12]
print(df1)

print('11==========================')
data3 = [{"sido":"서울"}, {"sido":"경기"}, {"sido":"인천"}]
df2 = pd.DataFrame(data3)
print(df2)
print('12==========================')
print(pd.merge(df1, df2, left_index=True, right_index=True))

print('13==========================')
df3 = pd.DataFrame({'고객번호':[1001, 1002, 1005, 1008, 1009],
                    '이름': ['둘리', '도우너', '희동', '마이콜', '영희']}, columns=['고객번호', '이름'])
print(df3)
df4 = pd.DataFrame({'고객번호':[1001, 1002, 1005, 1006, 1007],
                    '금액': [10000, 20000, 30000, 5000, 10000]}, columns=['고객번호', '금액'])
print('14==========================')
print(pd.merge(df3, df4))

print('15==========================')
print(pd.merge(df3, df4, how='outer')) # how default값은 inner


print('16==========================')
print(pd.merge(df3, df4, how='left'))


print('17==========================')
print(pd.merge(df3, df4, how='right'))

df1 = pd.DataFrame({
    '품종': ['setosa', 'setosa', 'virginica', 'virginica'],
    '꽃잎길이': [1.4, 1.3, 1.5, 1.3]}, columns=['품종', '꽃잎길이'])
print(df1)
print('18==========================')

df2 = pd.DataFrame({
    '품종': ['setosa', 'virginica', 'virginica', 'versicolor'],
    '꽃잎너비': [0.4, 0.3, 0.5, 0.3]}, columns=['품종', '꽃잎너비'])
print(df2)
print('19==========================')
print(pd.merge(df1, df2))

print('20==========================')

df3 = pd.DataFrame([[1,2], [3,4], [5,6]], index=['a', 'c', 'e'], columns=['대구', '부산'])
print(df3)
print('21==========================')

df4 = pd.DataFrame([[7,8], [9,10], [11,12], [13,14]], index=['b', 'c', 'd', 'e'], columns=['대구', '광주'])
print(df4)
print('22==========================')
print(pd.merge(df3, df4))

print('23==========================')
print(pd.merge(df3, df4, left_index=True, right_index=True))

print('24==========================')
print(pd.merge(df3, df4, how='outer', left_index=True, right_index=True))

print('25==========================')
data = pd.DataFrame([[1,2,3], [4,5,6], [7,8,9]])
print(data)
print('26==========================')
print(data.values)
print('==========================')
