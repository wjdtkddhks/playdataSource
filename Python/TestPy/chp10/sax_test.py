# -*- coding:utf-8 -*-
import sys, xml.sax
from xml.sax.handler import ContentHandler

class MyHandler(ContentHandler):
    _name_node = ['friends', 'address', 'name']

    def __init__(self, writer=sys.stdout):
        ContentHandler.__init__(self)
        self._writer = writer
        self._node = []

    def startElement(self, name, attrs):
        self._node.append(name)

    def endElement(self, name):
        self._node.pop()

    def characters(self, data):
        if self._node == self._name_node:
            self._writer.write(u'%s\n'%data)

if __name__ == '__main__':
    parser = xml.sax.make_parser()
    parser.setContentHandler(MyHandler())
    parser.parse('myfriend.xml')
