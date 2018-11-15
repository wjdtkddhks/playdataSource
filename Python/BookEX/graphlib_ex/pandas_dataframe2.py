import pandas as pd
import numpy as np

dict_data = {'city': ['서울', '부산', '대구'],
             'year': [2000, 2001, 2002],
             'pop': [4000, 1000, 2000]}

data = pd.DataFrame(dict_data)
print(data)
print('==========================')

data = pd.DataFrame(dict_data, columns=['year', 'city', 'pop'])
print(data)
print('==========================')
data = pd.DataFrame(dict_data, columns=['city', 'pop', 'year'], index=['one', 'two', 'three'])
print(data)
print('==========================')
print(data.index)
print('==========================')
print(data.columns)
print('==========================')
print(data['city'])
print('==========================')
print(data.ix['one'])
print('==========================')
print(data.loc['one'])
print('==========================')
print(data.ix['one']['year'])
print('==========================')
print(data.loc['one']['year'])

# iloc : index position(위치값)을 이용하여 추출
print('==========================')
print(data.iloc[0:2])
print('==========================')
print(data.iloc[1:])
print('==========================')
print(data.year.iloc[1])
print('==========================')
print(data.year.iloc[1:])
print('==========================')
data = pd.DataFrame(dict_data, columns=['city', 'pop', 'year', 'debt'], index=['one', 'two', 'three'])
print(data)
print('==========================')
data['debt'] = 10
print(data)
print('==========================')
data['debt'] = np.arange(3) # np.arange(3) => 0,1,2
print(data)
print('==========================')
val = pd.Series([100, 200, 300], index=['one', 'two', 'three'])
data['debt'] = val
print(data)
print('==========================')
val = pd.Series([100, 300], index=['one', 'three'])
data['debt'] = val
print(data)
print('==========================')
print(data.T) # 행, 열 자리 바뀜