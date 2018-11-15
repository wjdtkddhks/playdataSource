# -*- coding:utf-8 -*-
from datetime import *

d = date(2018, 9,12)
print("d:",d)
print("isoweekday:",d.isoweekday())
print("toordial:",d.toordinal())
print("속성:",d.year, d.month, d.day)
print("timetuple:",d.timetuple())
print('============================')
d = date.today() #날까지만 가져옴, 시간은 가져오지 못함. now()는 시간까지 가져옴
print("isoformat:",d.isoformat())
print("ctime:",d.ctime())
print("strftime:",d.strftime("%y/%m/%d"))
print("strftime:",d.strftime("%Y/%m/%d/%A"))
print("strftime:",d.strftime("%Y/%m/%d/%a"))
print("strftime:",d.strftime("%Y/%m/%d/%X"))
print("strftime:",d.strftime("%T"))
print('============================')
now_date1 = datetime.now()
print(now_date1)

date = datetime(2017, 12, 16, 12, 18, 30, 900000)
print(date)
print('%t', datetime.strftime(date, '%T'))

print(now_date1.year, now_date1.month, now_date1.day, now_date1.hour, now_date1.minute, now_date1.second, now_date1.microsecond)
print(date.year, date.month, date.day, date.hour, date.minute, date.second, date.microsecond)
print('============================')
print("now_date1.weekday() :",now_date1.weekday())
print("date.weekday() :",date.weekday())

print(now_date1.strftime('%y %m %d %H %M %S %a %b'))
print(now_date1.strftime('%Y %m %d %H %M %S %A %B'))
print(date.strftime('%y %m %d %H %M %S %a %b'))
print(date.strftime('%Y %m %d %H %M %S %A %B'))
print(datetime.strptime('2017-01-02 14:44', '%Y-%m-%d %H:%M'))
print('============================')
dt1 = datetime(2016, 2, 19, 14)
dt2 = datetime(2016, 1, 2, 13)
td = dt1-dt2
print("td:",td)

t0 = datetime(2017, 1, 1, 13)
d = timedelta(days=30, seconds=3600)
t1 = t0+d
print("t1:", t1)