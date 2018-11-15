# -*- coding:utf-8 -*-
import sqlite3

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()
res = dbcursor.execute('select * from tel order by id asc')

while True:
    name = input('수정할 이름 입력 > ')
    flag = 0
    for row in res:
        if row[1] == name :
            tell = input('수정할 전화번호 입력 > ')
            addr = input('수정할 주소 입력 > ')
            memo = input('수정할 메모 입력 > ')
            dbcursor.execute('update tel set tell=?, addr=?, memo=? where name=?', (tell, addr, memo, name))
            dbconn.commit()
            flag=1

    if flag != 0:
        break
    else:
        print('해당되는 이름이 없습니다.')

dbcursor.close()
dbconn.close()