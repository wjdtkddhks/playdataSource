# -*- coding:utf-8 -*-
import re

class Sungjuk:
    def __init__(self):
        self._hakbun = None
        self._irum = None
        self._kor = 0
        self._eng = 0
        self._math = 0
        self._sum = 0
        self._avg = 0
        self._grade = None

    def get_hakbun(self):
        return self._hakbun

    def set_hakbun(self, hakbun):
        self._hakbun = hakbun

    hakbun = property(get_hakbun, set_hakbun)

    def get_irum(self):
        return self._irum

    def set_irum(self, irum):
        self._irum = irum

    irum = property(get_irum, set_irum)

    def get_kor(self):
        return self._kor

    def set_kor(self, kor):
        self._kor = kor

    kor = property(get_kor, set_kor)

    def get_eng(self):
        return self._eng

    def set_eng(self, eng):
        self._eng = eng

    eng = property(get_eng, set_eng)

    def get_math(self):
        return self._math

    def set_math(self, math):
        self._math = math

    math = property(get_math, set_math)

    def get_sum(self):
        return self._sum

    def set_sum(self, sum):
        self._sum = sum

    sum = property(get_sum, set_sum)

    def get_grade(self):
        return self._grade

    def set_grade(self, grade):
        self._grade = grade

    grade = property(get_grade, set_grade)

    def get_avg(self):
        return self._avg

    def set_avg(self, avg):
        self._avg = avg

    avg = property(get_avg, set_avg)

    def hak_check(self, value):
        lenCh = re.compile(r'A(\d{3})\Z')
        if value == 'exit':
            return value
        if bool(lenCh.match(value)) == False :
            print('학번은 A+세자리정수입니다.')
            return False
        return value

    def num_check(self, value):
        try:
            if 0<=int(value)<=100:
                return int(value)
            else:
                print('0~100사이의 수를 입력해주세요.')
                return False
        except ValueError:
            print('0~100사이의 수를 입력해주세요.')
            return False

    def input_sungjuk(self):
        self._hakbun = self.hak_check(input('학번을 입력하세요 : '))
        if self.hakbun == False:
            return False
        elif self.hakbun == 'exit':
            return 'exit'
        self._irum = input('이름을 입력하세요 : ')
        self._kor = self.num_check(input('국어점수를 입력하세요 : '))
        if self._kor == False:
            return False
        self._eng = self.num_check(input('영어점수를 입력하세요 : '))
        if self._eng == False:
            return False
        self._math = self.num_check(input('수학점수를 입력하세요 : '))
        if self._math == False:
            return False

        self.progress_sungjuk()

    def progress_sungjuk(self):
        self._sum = self._kor + self._eng + self._math
        self._avg = self._sum / 3

        if self._avg >= 90:
            self._grade = '수'
        elif 80 <= self._avg < 90:
            self._grade = '우'
        elif 70 <= self._avg < 80:
            self._grade = '미'
        elif 60 <= self._avg < 70:
            self._grade = '양'
        else:
            self._grade = '가'

    def output_sungjuk(self):
        print("  %5s%5s %5d %5d %5d %5d %7.2f %5s" % (
        self._hakbun, self._irum, self._kor, self._eng, self._math, self._sum, self._avg, self._grade))



if __name__ == '__main__':
    sun = Sungjuk()
    sun.input_sungjuk()
    jul = "=" * 60
    print()
    print(("*** 성적표 ***").center(55))
    print(jul)
    print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
    print(jul)
    sun.output_sungjuk()
    print(jul)