import socket
import threading
import sys

class Server:

    connections=[]
    peers=[]
    def __init__(self):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.bind(('127.0.0.1',1000))
        sock.listen(1)
        while True:
            c,a=sock.accept()
            cThread=threading.Thread(target=self.handler,args=(c,a))
            cThread.daemon=True
            cThread.start()
            self.connections.append(c)
            self.peers.append(a[0])
            print(self.connections)
            print("hello")
            self.sendPeers()
    def handler(self,c,a):
        while True:
            data=c.recv(1024)
            for connection in self.connections:
                connection.send(data)
            if not  data:
                self.connections.remove(c)
                self.peers.remove(a[0])
                c.close()
                self.sendPeers()
                break
    def sendPeers(self):
        p=""
        for peer in peers:
            p+=peers+","
        for connection in connections:
            connection.send(b'\x11'+p.encode())
class Client:

    def sendMsg(self,sock):
        while True:

            sock.send(bytes(input(""),'utf-8'))
    def __init__(self,address):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.connect((address,1000))
        iThread=threading.Thread(target=self.sendMsg,args=(sock,))
        iThread.start()
        while True:
            data=ssock.recv(1024)
            if not data:
                break
            print(data.decode('utf-8'))
if (len(sys.argv) > 1) :
    c=Client('127.0.0.1')


s=Server()

