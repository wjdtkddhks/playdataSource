# -*- coding:utf-8 -*-
import sys, xml.sax
from xml.sax.handler import ContentHandler

class MyHandler(ContentHandler):
    _type = ['collection', 'movie', 'type']
    _desc = ['collection', 'movie', 'description']

    def __init__(self, writer=sys.stdout):
        self._writer = writer
        self._node = []
        ContentHandler.__init__(self)

    def startElement(self, name, attrs):
        self._node.append(name)

    def endElement(self, name):
        self._node.pop()

    def characters(self, data):
        if self._node == self._type:
            self._writer.write(u'type : %s\n'%data)
        elif self._node == self._desc:
            self._writer.write(u'description : %s\n' % data)
            self._writer.write(u'=========================\n')

if __name__ == '__main__':
    parser = xml.sax.make_parser()
    parser.setContentHandler(MyHandler())
    parser.parse('movies.xml')