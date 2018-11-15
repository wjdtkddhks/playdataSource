import matplotlib.pyplot as plt
from matplotlib import font_manager
import matplotlib

font_location = "C:\Windows\Fonts\malgun.ttf"
font_name = font_manager.FontProperties(fname=font_location).get_name()
matplotlib.rc('font', family=font_name)

plt.title('테스트')
plt.plot([1,2,3,4], [2,3,4,5], 'bo') # 하나만 주어지면 y축 값, 파라미터 두개면(1.x축, 2.y축), 세번째 파라미터는 그래프 모양
plt.xlabel("X-제목") # x축 따로 지정 안하면 0 부터 시작
plt.ylabel("Y-제목")
plt.show()
