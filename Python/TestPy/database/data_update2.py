# -*- coding:utf-8 -*-
import sqlite3

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()
while True:
    name = input('수정할 이름 입력 > ')
    dbcursor.execute('select * from tel where name=?',(name,))
    lst = dbcursor.fetchall()
    if len(lst) != 0 :
        break
    print('해당 이름이 없습니다. 확인해주세요')

flag = 0
for row in lst:
    tell = input('수정할 전화번호 입력 > ')
    addr = input('수정할 주소 입력 > ')
    memo = input('수정할 메모 입력 > ')
    dbcursor.execute('update tel set tell=?, addr=?, memo=? where name=?', (tell, addr, memo, name))
    flag=1

dbconn.commit()
if flag == 0:
    print('해당되는 이름이 없습니다.')

dbcursor.close()
dbconn.close()