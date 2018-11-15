# -*- coding:utf-8 -*-
import socketserver
import threading

HOST = '127.0.0.1'
PORT = 8888
lock = threading.Lock()

class UserManager:

    def __init__(self):
        self.users = {}

    def addUser(self, username, conn, addr):
        if username in self.users:
            conn.send('이미 등록된 사용자입니다.\n'.encode())
            return None

        lock.acquire()
        self.users[username] = (conn, addr)
        lock.release()

        self.sendMessageToAll('[%s]님이 입장하였습니다.'%username)
        print('----대화 참여자수 [%d]'%len(self.users))
        return True

    def removeUser(self, username):
        if username not in self.users:
            return

        lock.acquire()
        del self.users[username]
        lock.release()

        self.sendMessageToAll('[%s]님이 퇴장하였습니다.' % username)
        print('----대화 참여자수 [%d]' % len(self.users))

    def messageHandler(self, username, msg):
        if msg[0] != '/':
            self.sendMessageToAll('[%s] %s'%(username, msg))

        if msg.strip() == '/quit':
            self.removeUser(username)
            return -1

    def sendMessageToAll(self, msg):
        for conn, addr in self.users.values():
            conn.send(msg.encode())

class MyTcpHandler(socketserver.BaseRequestHandler):
    user = UserManager()

    def handle(self):
        print('[%s] 연결됨'%self.client_address[0])

        try:
            username = self.registerUsername()
            msg = self.request.recv(1024)
            while msg:
                print(msg.decode())
                if self.user.messageHandler(username, msg.decode()) == -1:
                    self.request.close()
                    break
                msg = self.request.recv(1024)

        except Exception as e:
            print(e)

        print('[%s] 접속종료'%self.client_address[0])
        self.user.removeUser(username)

    def registerUsername(self):
        while True:
            self.request.send('로그인ID:'.encode())
            username = self.request.recv(1024)
            username = username.decode().strip()
            if self.user.addUser(username, self.request, self.client_address):
                return username

class MultiChatServer(socketserver.ThreadingMixIn, socketserver.TCPServer):
    pass

def runServer():
    print('Chat Server Start!!!(end:ctrl+c)')

    try:
        chat_server = MultiChatServer((HOST, PORT), MyTcpHandler)
        chat_server.serve_forever() #클라이언트 갯수에 상관없이 threading을 포함한 서버 소켓 구동시킴
    except KeyboardInterrupt:
        print('Chat Server end!!!')
        chat_server.shutdown()
        chat_server.server_close()

if __name__ == '__main__':
    runServer()
