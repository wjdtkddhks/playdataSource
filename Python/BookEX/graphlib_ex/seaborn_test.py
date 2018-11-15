import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np

uniform_data = np.random.rand(10, 12) #무작위(0~1)로 10행 12열 데이터 나옴
print(uniform_data)
sns.heatmap(uniform_data, cbar=True, vmin=0, vmax=1)
plt.show()

flights = sns.load_dataset("flights")
print(flights.head())
print(flights)
#pivot() => index: month, column: year, value:passengers
flights = flights.pivot("month", "year", "passengers")
print(flights)

plt.figure(figsize=(10,8)) # 가로 10인치, 세로 8인치
# flights:데이터, annot=True이면 값출력, fmt="d": 값을 정수형으로 출력,
# linewidth=5 : 줄간격, cbar=True : 색상바 출력(기본), cbar_kws: cbar 위치
sns.heatmap(flights, annot=True, fmt='d', vmin=0, vmax=650, linewidths=5,
            cbar=True, cbar_kws={"orientation": "horizontal"}, cmap="Reds")
plt.show()