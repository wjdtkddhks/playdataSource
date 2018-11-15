# -*- coding:utf-8 -*-
from sungjuk.sungjuk4 import Sungjuk
import re
sunlist = []
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
        sunlist.append(sun)
        break

def menu_out():
    totalAvg = 0.0
    if len(sunlist) == 0:
        print('출력할 데이터가 없습니다.')
        return
    print()
    print(("*** 성적표 ***").center(55))
    print(jul)
    print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
    print(jul)
    for i in sunlist:
        i.output_sungjuk()
        totalAvg += i.avg
    print(jul)
    print(("총학생수 = %d,   전체 평균 = %.2f"%(len(sunlist), totalAvg/len(sunlist))).center(55))


def menu_check():
    changeHakbun = input('출력할 학번을 입력해주세요 : ')
    for i in sunlist:
        if i.hakbun == changeHakbun:
            print()
            print(("*** 성적표 ***").center(55))
            print(jul)
            print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
            print(jul)
            i.output_sungjuk()
            print(jul)
            break
    else:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')

def menu_update():
    changeHakbun = input('수정할 학번을 입력해주세요 : ')
    for i in sunlist:
        if i.hakbun == changeHakbun:
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
                break
        print('학번 %s의 정보를 수정완료하였습니다.'%i.hakbun)
        break
    else:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')

def menu_delete():
    changeHakbun = input('삭제할 학번을 입력해주세요 : ')
    for i in sunlist:
        if i.hakbun == changeHakbun:
            sunlist.remove(i)
            print('해당학번 삭제를 완료하였습니다.')
            break
    else:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')

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
