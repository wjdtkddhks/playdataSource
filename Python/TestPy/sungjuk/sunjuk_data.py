# -*- coding:utf-8 -*-
import sqlite3
from sungjuk.sungjuk4 import Sungjuk

dbconn = sqlite3.connect('sungjuk.db')
dbcursor = dbconn.cursor()
dbcursor.execute('create table if not exists sungjuk \
                (hakbun text primary key, irum text, kor integer, eng integer, \
                 math integer, sum integer, avg real, grade text)')

jul = "=" * 60

def menu_in():
    check = True
    while True :
        sun = Sungjuk()
        check=sun.input_sungjuk()
        if check == False :
            del sun
            print('다시 입력해주세요.')
            continue
        dbcursor.execute('insert into sungjuk values(?,?,?,?,?,?,?,?)',
                         (sun.hakbun, sun.irum, sun.kor, sun.eng, sun.math, sun.sum, sun.avg, sun.grade))
        break
    dbconn.commit()

def menu_out():
    # dbcursor.execute('select count(*) from sungjuk')
    # cnt = dbcursor.fetchone()[0]
    res = dbcursor.execute('select * from sungjuk order by hakbun asc')
    lst = list(res)
    totalAvg = 0.0
    if len(lst) == 0:
        print('출력할 데이터가 없습니다.')
        return

    print()
    print(("*** 성적표 ***").center(55))
    print(jul)
    print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
    print(jul)
    for i in lst:
        print("  %5s%5s %5d %5d %5d %5d %7.2f %5s" % (i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7]))
        totalAvg += i[6]
    print(jul)
    print(("총학생수 = %d,   전체 평균 = %.2f"%(len(lst), totalAvg/len(lst))).center(55))


def menu_check():
    changeHakbun = input('출력할 학번을 입력해주세요 : ')
    res = dbcursor.execute('select * from sungjuk where hakbun = ?', (changeHakbun,))
    lst = list(res)
    if len(lst) == 0:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')
    else:
        print()
        print(("*** 성적표 ***").center(55))
        print(jul)
        print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
        print(jul)
        for i in lst:
            print("  %5s%5s %5d %5d %5d %5d %7.2f %5s" % (i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7]))
        print(jul)

    dbconn.commit()

def menu_update():
    changeHakbun = input('수정할 학번을 입력해주세요 : ')
    res = dbcursor.execute('select * from sungjuk where hakbun = ?', (changeHakbun,))
    lst = list(res)
    if len(lst) == 0 :
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')
    else:
        i = Sungjuk()
        while True :
            i.kor = i.num_check(input('수정할 국어점수를 입력해주세요 : '))
            if i.kor == False:
                continue
            i.eng = i.num_check(input('수정할 영어점수를 입력해주세요 : '))
            if i.eng == False:
                continue
            i.math = i.num_check(input('수정할 수학점수를 입력해주세요 : '))
            if i.math == False:
                continue
            i.progress_sungjuk()
            break
        dbcursor.execute('update sungjuk set kor=?, eng=?, math=?, sum=?, avg=?, grade=? where hakbun =?',
                         (i.kor, i.eng, i.math, i.sum, i.avg, i.grade, changeHakbun))
        print('학번 %s의 정보를 수정완료하였습니다.'%changeHakbun)

    dbconn.commit()

def menu_delete():
    changeHakbun = input('삭제할 학번을 입력해주세요 : ')
    res = dbcursor.execute('select * from sungjuk where hakbun = ?', (changeHakbun,))
    if len(list(res)) == 0:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')
    else:
        dbcursor.execute('delete from sungjuk where hakbun =?', (changeHakbun,))
        print('학번 %s의 정보를 삭제하였습니다.'%changeHakbun)

    dbconn.commit()

if __name__ == '__main__':
    while True:
        print()
        print('*** 메뉴 ***'.center(15))
        print('1. 성적정보 입력')
        print('2. 성적정보 출력')
        print('3. 성적정보 조회')
        print('4. 성적정보 수정')
        print('5. 성적정보 삭제')
        print('6. 프로그램 종료')
        print()
        menuin = input('메뉴를 선택하세요 : ')
        print()

        if menuin == '1':
            menu_in()
        elif menuin == '2':
            menu_out()
        elif menuin == '3':
            menu_check()
        elif menuin == '4':
            menu_update()
        elif menuin == '5':
            menu_delete()
        elif menuin == '6':
            print('프로그램 종료...')
            break
        else:
            print('1~6사이의 수를 입력해주세요.')


    dbcursor.close()
    dbconn.close()