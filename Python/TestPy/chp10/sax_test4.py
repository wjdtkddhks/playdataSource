# -*- coding:utf-8 -*-
import xml.sax
from xml.sax.handler import ContentHandler

class MyHandler(ContentHandler):
    def __init__(self):
        self._tag = ""
        self._type = ""
        self._desc = ""
        self._data = ""
        ContentHandler.__init__(self)

    def startElement(self, name, attrs):
        self._tag = name

    def characters(self, data):
        if self._tag == 'type':
            self._type = data
        elif self._tag == 'description':
            self._desc = data

    def endElement(self, name):
        if self._tag == 'type':
            print('type :', self._type)
        elif self._tag == 'description':
            print('description :', self._desc)
            print('===================================')

        self._tag =""
        self._type=""
        self._desc=""

if __name__ == '__main__':
    parser = xml.sax.make_parser()
    parser.setContentHandler(MyHandler())
    parser.parse('movies.xml')