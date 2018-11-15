# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

from scrapy.exporters import CsvItemExporter, JsonItemExporter
import pymysql
import sys
import sqlite3

class HanbitBookPipeline(object):

    # CSV 파일 저장
    # def __init__(self):
    #     self.file = open("book_crawl.csv", 'wb')
    #     self.exporter = CsvItemExporter(self.file, encoding='utf-8')
    #     self.exporter.start_exporting()
    #
    # def close_spider(self, spider):
    #     self.exporter.finish_exporting()
    #     self.file.close()
    #
    # def process_item(self, item, spider):
    #     self.exporter.export_item(item)
    #     return item

    # JSON 파일 저장
    # def __init__(self):
    #     self.file = open("book_crawl.json", 'wb')
    #     self.exporter = JsonItemExporter(self.file, encoding='utf-8', ensure_ascii=False)
    #     self.exporter.start_exporting()
    #
    # def close_spider(self, spider):
    #     self.exporter.finish_exporting()
    #     self.file.close()
    #
    # def process_item(self, item, spider):
    #     print("pipelines:", item)
    #     self.exporter.export_item(item)
    #     return item

    # Mysql DB 저장
    # def __init__(self):
    #     try:
    #         self.conn = pymysql.connect(user='root', passwd='1234', db='employees', host='localhost', charset='utf-8'
    #                                     , use_unicode=True)
    #         self.cursor = self.conn.cursor()
    #     except pymysql.Error as e:
    #         print("Error %d: %s" % (e.args[0], e.args[1]))
    #         sys.exit(1)
    #
    # def process_item(self, item, spider):
    #     # create record if dosen't exist.
    #     self.cursor.execute(
    #         "select * from book_list where book_title = %s and book_author = % s and book_translator = %s and \
    #         book_pub_date = %s and book_isbn = %s", (str(item['book_title']), str(item['book_author']),
    #         str(item['book_translator']), str(item['book_pub_date']), str(item['book_isbn'])))
    #
    #     result = self.cursor.fetchone()
    #
    #     if result:
    #         print('data already exist')
    #     else:
    #         try:
    #             self.cursor.execute(
    #                 "insert into book_list(book_title, book_author, book_translator, book_pub_date, book_isbn) \
    #                 values (%s, %s, %s, %s, %s)", (str(item['book_title']), str(item['book_author']),
    #                 str(item['book_translator']), str(item['book_pub_date']), str(item['book_isbn'])))
    #             self.conn.commit()
    #             self.cursor.close()
    #             self.conn.close()
    #
    #         except pymysql.Error as e :
    #             print("Error %d: %s" % (e.args[0], e.args[1]))
    #             return item


    # sqlite3에 저장
    def __init__(self):
        try:
            self.conn = sqlite3.connect("hanbit_book.db")
            self.cursor = self.conn.cursor()
        except:
            print("Error1")
            sys.exit(1)

    def process_item(self, item, spider):
        for key in item:
            if len(item[key]) == 0:
                item[key] = 'null'
            else:
                item[key] = item[key][0]

        data = (str(item['book_title']), str(item['book_author']),
                str(item['book_translator']), str(item['book_pub_date']), str(item['book_isbn']))
        print("data:", data)

        sql = 'select * from book_list where book_title = ? and book_author = ? and book_translator = ? and \
                book_pub_date = ? and book_isbn = ?'

        self.cursor.execute(sql, data)
        result = self.cursor.fetchone()

        if result:
            print("data already exist")
        else:
            sql = 'insert into book_list values(null, ?,?,?,?,?)'

            try:
                self.cursor.execute(sql, data)
                self.conn.commit()
            except:
                print("Error2")
                return item
