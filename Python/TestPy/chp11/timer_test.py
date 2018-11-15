# -*- coding:utf-8 -*-
import threading

def thread_test():
    for x in range(5):
        print('python_Threading')

t=threading.Timer(5, thread_test)
t.start()
