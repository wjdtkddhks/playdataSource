# -*- coding:utf-8 -*-
import threading
import time

def Mythread(nsleep, a):
    for i in range(5):
        print("[%s]%d"%(threading.current_thread().getName(), i), ", nsleep=", nsleep, ", two=", a)
        time.sleep(nsleep)

if __name__ == '__main__':
    t1 = threading.Thread(target=Mythread, name="야옹이", args=(0.1, 3,))
    t2 = threading.Thread(target=Mythread, name="멍멍이", args=(0.2, 5,))
    t3 = threading.Thread(target=Mythread, name="꽥꽥이", args=(0.3, 6,))
    t1.start()
    t2.start()
    t3.start()
    main_thread = threading.current_thread()
    while True:
        tlist = threading.enumerate()
        if len(tlist) <= 2 :
            break

        for t in tlist:
            if t is main_thread:
                continue
            print(t)
        time.sleep(1)
