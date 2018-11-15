# -*- coding:utf-8 -*-
import sqlite3

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()
res = dbcursor.execute('select * from tel order by id desc')

name = input('삭제할 이름 입력 > ')
flag = 0
for row in res:
    if row[1] == name:
        dbcursor.execute('delete from tel where name=?',(name,))
        flag = 1

dbconn.commit()
if flag == 0:
    print('해당되는 이름이 없습니다.')

dbcursor.close()
dbconn.close()