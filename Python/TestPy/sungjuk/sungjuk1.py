# -*- coding:utf-8 -*-
dic = {}

dic["hakbun"] = input("학번 입력 =>")
dic["irum"] = input("이름 입력 =>")
dic["kor"] = int(input("국어점수 입력 =>"))
dic["eng"] = int(input("영어점수 입력 =>"))
dic["math"] = int(input("수학점수 입력 =>"))
dic["sum"] = dic.get("kor")+dic.get("eng")+dic["math"]
dic["avg"]= dic.get("sum")/3


if dic["avg"]>=90:
    dic["grade"]='수'
elif 80<=dic["avg"]<90:
    dic["grade"]='우'
elif 70 <= dic["avg"] < 80:
    dic["grade"] = '미'
elif 60 <= dic["avg"] < 70:
    dic["grade"] = '양'
else :
    dic["grade"] = '가'

subject = ['학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급']
#dic = {'hakbun':hakbun, 'irum':irum, 'kor':kor, 'eng':eng, 'math':math, 'sum':sum, 'avg':avg, 'grade':grade}
jul = "="*60

print(("*** 성적표 ***").center(55))
print(jul)
print("%5s%5s%5s%5s%5s%5s%5s%5s"%('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
print(jul)
print("  %5s%5s %5d %5d %5d %5d %7.2f %5s"%(dic.get('hakbun'), dic.get('irum'), dic.get('kor'), dic.get('eng'),
                                            dic.get('math'), dic.get('sum'), dic.get('avg'), dic.get('grade')))
print(jul)