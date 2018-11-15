# -*- coding:utf-8 -*-
import threading

def Mythead():
    for i in range(10000):
        print("demon:", i)

if __name__ == '__main__':
    t = threading.Thread(target=Mythead)
    t.setDaemon(True)
    t.start()
    # t.join()
    if t.is_alive():
        print("demon is alive")
        t.join(0.01)
    for i in range(10):
        print('main:', i)