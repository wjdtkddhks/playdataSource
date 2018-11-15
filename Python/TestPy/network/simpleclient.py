# -*- coding:utf-8 -*-
import socket
HOST = '127.0.0.1'
PORT = 55555

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))
s.send('Hello Python!!!'.encode(encoding='utf-8', errors='strict'))
data = s.recv(1024)
s.close()
print(data)
