# -*- coding:utf-8 -*-
import sqlite3
jul = '='*68
dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()

print("No \t 성명 \t  전화번호 \t    주소 \t  메모 \t     입력일자")
print(jul)
for row in dbcursor.execute('select * from tel order by id asc'):
    print(str(row[0]) + '\t' + str(row[1]) + '\t' + str(row[2]) + '\t' + str(row[3]) \
          + '\t' +  str(row[5]) + '\t' + str(row[4]))
print(jul)

dbcursor.execute('select * from tel order by id asc')
lst = dbcursor.fetchall()
print('type(lst):', type(lst))
for row in lst:
    print(row)