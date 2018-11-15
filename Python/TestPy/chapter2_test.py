# -*- coding:utf-8 -*-

ge = set(['dominica','millo', 'ruri', 'ruse', 'ruo', 'polio']) #교양과목
me = set(['ruse', 'dominica', 'ruo', 'luccica', 'johan']) #전공과목

print("1 :",ge) #1.교양과목 수강학생
print("2 :",me) #2.전공과목 수강학생
print("3 :",ge&me) #3.모두 듣는 수강학생
print("4 :",ge-me) #4.교양과목만 수강학생