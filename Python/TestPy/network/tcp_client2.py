# -*- coding:utf-8 -*-
import socket

HOST = '127.0.0.1'
PORT = 12333
ADDR = (HOST, PORT)

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

while True:
    msg = input('msg> ')
    if msg == 'exit':
        break
    client.send(msg.encode(encoding='utf-8', errors='strict'))
    data = client.recv(4096)
    print('recvMsg >', data.decode())

client.close()

