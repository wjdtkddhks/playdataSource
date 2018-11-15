# -*-coding:utf-8 -*-
from http.server import BaseHTTPRequestHandler, HTTPServer

hostName = 'localhost'
hostPort = 8999

class MyServer(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()

        self.wfile.write(bytes("<html><head><title>Test</title></head>", "utf-8"))
        self.wfile.write(bytes("<body><p>Hello Python!</p>", "utf-8"))
        self.wfile.write(bytes("<p>U accessed path:%s</p>"%self.path, "utf-8"))
        self.wfile.write(bytes("</body></html", "utf-8"))

myServer = HTTPServer((hostName, hostPort), MyServer)
print("Server Starts - %s:%s"%(hostName, hostPort))

try:
    myServer.serve_forever()
except KeyboardInterrupt:
    pass