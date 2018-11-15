import matplotlib.pyplot as plt

fig = plt.figure()
ax1 = fig.add_subplot(2,1,1)
ax2 = fig.add_subplot(2,1,2)

x = range(0, 100)
y = [y*y for y in x]

ax1.plot(x, y)
ax2.bar(x, y)

plt.show()