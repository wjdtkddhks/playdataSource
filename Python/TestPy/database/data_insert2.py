# -*- coding:utf-8 -*-
import sqlite3, time

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()

data = [('홍기자', '010-111-1234', '서울', str(time.asctime(time.localtime(time.time()))), '테스트1'),
        ('서기자', '010-111-2365', '수원', str(time.asctime(time.localtime(time.time()))), '테스트2'),
        ('민기자', '010-111-5678', '부산', str(time.asctime(time.localtime(time.time()))), '테스트3')
        ]

sql = 'insert into tel(name, tel, addr, input_time, memo) values(?,?,?,?,?)'
# sql = 'insert into tel values(null, ?,?,?,?,?)'
dbcursor.executemany(sql, data)

dbconn.commit()

for row in dbcursor.execute('select * from tel'):
    print(row)

dbcursor.close()
dbconn.close()