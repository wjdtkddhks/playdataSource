# -*- coding:utf-8 -*-
import socket

bind_ip = '127.0.0.1'
bind_port = 9999

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((bind_ip, bind_port))
client.send('Hello Server!!!'.encode(encoding='utf-8', errors='strict'))
data = client.recv(4096)
print('data:',type(data))
print('data.decode:',type(data.decode()))
print(data.decode())