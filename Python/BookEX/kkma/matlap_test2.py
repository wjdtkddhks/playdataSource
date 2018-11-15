import matplotlib.pyplot as plt

# plt.plot([1,2,3,4], [1,2,3,4], 'r-', [1,2,3,4], [3,4,5,6], 'v-')
# plt.show()

plt.figure()
plt.subplot(2,2,1) # 1. 행수, 2.열수 3.위치
plt.plot([1,2,3,4], [1,2,3,4])
plt.subplot(2,2,2)
plt.plot([5,6,7,8], [5,6,7,8])
plt.subplot(2,2,3)
plt.plot([9,10,11,12], [9,10,11,12])
plt.subplot(2,2,4)
plt.plot([13,14,15,16], [13,14,15,16])
plt.show()