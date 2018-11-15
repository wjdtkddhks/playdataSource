# -*- coding:utf-8 -*-

person_list = []

while True:
    dic = {}
    dic["hakbun"] = input("학번 입력 =>")
    if dic["hakbun"] == 'exit':
        break
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

    person_list.append(dic)
    print()


jul = "="*60

print(("*** 성적표 ***").center(55))
print(jul)
print("%5s%5s%5s%5s%5s%5s%5s%5s"%('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
print(jul)
for index in person_list :
    print("  %5s%5s %5d %5d %5d %5d %7.2f %5s"%(index.get('hakbun'), index.get('irum'), index.get('kor'), index.get('eng'),
                                                index.get('math'), index.get('sum'), index.get('avg'), index.get('grade')))
print(jul)