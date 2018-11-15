# -*- coding:utf-8 -*-
import socket
import threading

HOST = '127.0.0.1'
PORT = 12333
ADDR = (HOST, PORT)

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(ADDR)
server.listen(5)

def client_receive(cl_socket):
    BUFSIZE = 1024
    while True:
        msg = cl_socket.recv(BUFSIZE)
        if str(msg) == 'exit':
            break
        cl_socket.send(msg)

    print('client exit...')
    cl_socket.close()


while True:
    cl_socket, addr = server.accept()
    print('client accept socketIP: %s, socketPort: %d'%(addr[0], addr[1]))
    cl_thread = threading.Thread(target=client_receive, args=(cl_socket,))
    cl_thread.start()

server.close()

