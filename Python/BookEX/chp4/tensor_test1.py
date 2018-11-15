# X와 Y의 상관관계를 분석하는 기초적인 선형 회귀 모델을 만들고 실행하는 예제

import tensorflow as tf

x_data = [1,2,3]
y_data = [1,2,3]

W = tf.Variable(tf.random_uniform([1])) # 숫자 1은 1차원 구조값
b = tf.Variable(tf.random_uniform([1]))

# name: 나중에 텐서보드등으로 값의 변화를 추적하거나 살펴보기 쉽게 하기 위해 이름을 붙여줍니다.
X = tf.placeholder(tf.float32, name="X")
Y = tf.placeholder(tf.float32, name="Y")
print("X:", X)
print("Y:", Y)

# X 와 Y의 상관관계를 분석하기 위한 가상 수식을 작성
# y = (W * x) + b
# W 와 X가 행렬이 아니므로 tf.matmul 이 아니라 기본 곱셉 기호를 사용
hypothesis = W * X + b

# 손실함수를 작성
# mean(h - Y)^2: 예측값과 실제값의 거리를 비용(손실) 함수로 작성
cost = tf.reduce_mean(tf.square(hypothesis - Y))

# tensorflow에 기본적으로 포함되어 있는 함수를 이용해 경사 하강법 최적화를 수행합니다.
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.1)

# 비용을 최소화 하는 것이 목표
train_op = optimizer.minimize(cost)

# 세션을 생성, 초기화
with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    # 최적화를 300번 수행
    for step in range(300):
        # sess.run을 통해 train_op 와 cost 그래프를 계산
        # 이때, 가상 수식에 넣어야 실제값을 feed_dict을 통해 전달
        _, cost_val = sess.run([train_op, cost], feed_dict={X:x_data, Y: y_data})

        print(step, cost_val, sess.run(W), sess.run(b))

    # 최적화가 완료된 모델에 테스트 값을 넣고 결과가 잘 나오는지 확인해봅니다.

    print("\n== Test ==")
    print("X: 5, Y:", sess.run(hypothesis, feed_dict={X:5}))
    print("X: 2.5, Y:", sess.run(hypothesis, feed_dict={X:2.5}))