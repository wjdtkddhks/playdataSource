# -*- coding:utf-8 -*-
import socket
HOST = '127.0.0.1'
PORT = 55555

s  = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print('서버를 실행합니다.')
s.bind((HOST, PORT))
s.listen(1)
conn, addr = s.accept()
print('conn:', conn)
print('Connected by', addr)
while 1:
    data = conn.recv(1024)
    if not data:
        break
    conn.send(data + b' : from server')
conn.close()