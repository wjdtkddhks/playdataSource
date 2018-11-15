# -*- coding:utf-8 -*-
from socket import *

HOST = '127.0.0.1'
PORT = 21567
BUFSIZE = 1024
ADDR = (HOST, PORT)
udpClient = socket(AF_INET, SOCK_DGRAM)

while True:
    data = input('>')
    if not data:
        break

    udpClient.sendto(str(data).encode(encoding='utf_8', errors='stirct'), ADDR)
    data, ADDR = udpClient.recvfrom(BUFSIZE)
    if not data:
        break
    print(data.decode(), ADDR)
    print(type(data))
    print(type(data.decode()))

udpClient.close()