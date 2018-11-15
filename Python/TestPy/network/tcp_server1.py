# -*- coding:utf-8 -*-
import socket
import threading

bind_ip = '127.0.0.1'
bind_port = 9999

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((bind_ip, bind_port))
server.listen(5)

print('[*] Listening on %s : %d'%(bind_ip, bind_port))

def handle_client(client_socket):
    bufsize = 1024
    data = client_socket.recv(bufsize)
    print('[*] Received %s'%data.decode())
    client_socket.send('hello client'.encode(encoding='utf-8', errors='strict'))
    client_socket.close()

while True:
    client_socket, addr = server.accept()
    print('[*] Accepted connection from : %s: %d'%(addr[0], addr[1]))
    st = threading.Thread(target=handle_client, args=(client_socket,))
    st.start()