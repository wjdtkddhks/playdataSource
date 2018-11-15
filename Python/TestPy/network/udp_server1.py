# -*- coding:utf-8 -*-
from socket import *

HOST = '127.0.0.1'
PORT = 21567
BUFSIZE = 1024
ADDR = (HOST, PORT)

udpServer = socket(AF_INET, SOCK_DGRAM)
udpServer.bind(ADDR)

while True:
    print('waiting for message...')
    data, addr = udpServer.recvfrom(BUFSIZE)
    udpServer.sendto(str(data).encode(encoding='utf_8', errors='strict'), addr)
    print('..received from and return to :', addr)

udpServer.close()