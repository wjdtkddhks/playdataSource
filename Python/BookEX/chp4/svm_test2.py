from sklearn import svm, metrics
import  pandas as pd

xor_input = [
    # P, Q, result
    [0, 0, 0],
    [0, 1, 1],
    [1, 0, 1],
    [1, 1, 0],
]

# 학습을 위해 데이터와 레이블 분리하기

xor_df = pd.DataFrame(xor_input)
xor_data = xor_df.ix[:,0:1]
xor_label = xor_df.ix[:,2]

# 데이터 학습시키기
clf = svm.SVC()
clf.fit(xor_data, xor_label)

# 데이터 예측하기
pre = clf.predict(xor_data)
print("예측결과: ",  pre)

# 결과 확인하기
ac_score = metrics.accuracy_score(xor_label, pre)
print("정답률:", ac_score)