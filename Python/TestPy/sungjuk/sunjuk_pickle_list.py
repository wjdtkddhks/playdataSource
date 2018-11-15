# -*- coding:utf-8 -*-
from sungjuk.sungjuk4 import Sungjuk
import pickle, os
jul = "=" * 60
file_name = os.path.join(os.getcwd(), 'sunlist.dat')
def menu_in():
    sf = open(file_name, 'ab')
    check = True
    while True :
        sun = Sungjuk()
        check=sun.input_sungjuk()
        if check == False :
            del sun
            print('다시 입력해주세요.')
            continue
        pickle.dump(sun, sf)
        break
    sf.close()

def menu_out():
    totalAvg = 0.0
    check= 0

    if not os.path.isfile(file_name):
        print('출력할 데이터가 없습니다.')
        return

    sf = open(file_name, 'rb')

    if os.fstat(sf.fileno()).st_size == 0 :
        print('출력할 데이터가 없습니다.')
        return

    print()
    print(("*** 성적표 ***").center(55))
    print(jul)
    print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
    print(jul)
    while True:
        if sf.tell() == os.fstat(sf.fileno()).st_size:
            break
        sun = pickle.load(sf)
        check += 1
        sun.output_sungjuk()
        totalAvg += sun.avg
    print(jul)
    print(("총학생수 = %d,   전체 평균 = %.2f"%(check, totalAvg/check)).center(55))
    sf.close()

def menu_check():
    if not os.path.isfile(file_name):
        print('조회할 데이터가 없습니다.')
        return
    sf = open(file_name, 'rb')

    if os.fstat(sf.fileno()).st_size == 0 :
        print('조회할 데이터가 없습니다.')
        return

    changeHakbun = input('출력할 학번을 입력해주세요 : ')

    while True:
        if sf.tell() == os.fstat(sf.fileno()).st_size:
            break
        data = pickle.load(sf)
        if data.hakbun == changeHakbun:
            print()
            print(("*** 성적표 ***").center(55))
            print(jul)
            print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
            print(jul)
            data.output_sungjuk()
            print(jul)
            sf.close()
            return

    print('해당 학번이 존재하지 않습니다. 확인해주세요.')
    sf.close()

def menu_update():
    if not os.path.isfile(file_name):
        print('조회할 데이터가 없습니다.')
        return
    sf = open(file_name, 'rb')

    if os.fstat(sf.fileno()).st_size == 0 :
        print('조회할 데이터가 없습니다.')
        return

    changeHakbun = input('수정할 학번을 입력해주세요 : ')
    checklist = []
    check = False
    while True :
        if sf.tell() == os.fstat(sf.fileno()).st_size:
            break
        i = pickle.load(sf)
        if i.hakbun == changeHakbun:
            check = True
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
        checklist.append(i)

    if check == True:
        sf2 = open(file_name, 'wb')
        for i in checklist:
            pickle.dump(i, sf2)
        sf2.close()
    else:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')

    sf.close()

def menu_delete():
    changeHakbun = input('삭제할 학번을 입력해주세요 : ')
    sf = open(file_name, 'rb')
    checklist = []
    check = False
    while True :
        if sf.tell() == os.fstat(sf.fileno()).st_size:
            break
        i = pickle.load(sf)
        if i.hakbun == changeHakbun:
            check = True
            print('해당학번 삭제를 완료하였습니다.')
            continue
        checklist.append(i)

    if check == True:
        sf2 = open(file_name, 'wb')
        for i in checklist:
            pickle.dump(i, sf2)
        sf2.close()
    else:
        print('해당 학번이 존재하지 않습니다. 확인해주세요.')

    sf.close()

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
            os.remove(file_name)
            print('프로그램 종료...')
            break
        else:
            print('1~6사이의 수를 입력해주세요.')
