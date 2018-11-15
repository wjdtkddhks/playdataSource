# -*- coding:utf-8 -*-
import sqlite3, time

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()

name = input("이름 : ")
tel = input("전화번호 : ")
addr = input("주소 : ")
memo = input("메모 : ")
input_time = str(time.asctime(time.localtime(time.time())))

dbcursor.execute("insert into tel(name, tel, addr, input_time, memo) \
                 values ('" + name + "', '" +tel + "', '" + addr + "', '"+ input_time + "', '" + memo + "')")
# dbcursor.execute("insert into tel(name, tel, addr, input_time, memo) \
#                  values ('" + name + "', '" +tel + "', '" + addr + "', current_timestamp , '" + memo + "')")

dbconn.commit()

for row in dbcursor.execute('select * from tel'):
    print(row)