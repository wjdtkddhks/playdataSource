# -*- coding:utf-8 -*-
import threading

def thread_test():
    print("[%s] my python!!"%threading.current_thread().getName())
    t=threading.Timer(1, thread_test)
    t.start()

if __name__ == '__main__':
    t=threading.Thread(target=thread_test)
    t.start()