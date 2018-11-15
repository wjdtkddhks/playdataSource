# -*- coding:utf-8 -*-

import datetime
# from dateutil.parser import parse
from datetime import time

completeTime = []
stratTime = []
processTime = []

lines = ["2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s",
         "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
         "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
         "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s",
         "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s", "2016-09-15 01:00:04.001 2.0s",
         "2016-09-15 01:00:07.000 2s"]


# lines = ["2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"]
# lines =["2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"]


def solution(lines):
    print(lines[0][14:16])
    print(lines[0][17:19])
    print(lines[0][20:23])
    for i in range(len(lines)):
        # completeTime.append(parse(lines[i][:23]))
        completeTime.append(
            datetime.datetime(int(lines[i][:4]), int(lines[i][5:7]), int(lines[i][8:10]), int(lines[i][11:13]),
                              int(lines[i][14:16]), int(lines[i][17:19]), int(lines[i][20:23]) * 1000))
        print("완료 시간 : %s" % completeTime[i])
        processTime.append(lines[i][24:-1])
        print("수행 시간 : %s" % processTime[i])
        stratTime.append(
            completeTime[i] - datetime.timedelta(seconds=float(processTime[i])) + datetime.timedelta(seconds=0.001))
        print("시작 시간 : %s" % stratTime[i])
        # print(completeTime[i])
        # print(stratTime[i])

    stratTime.sort()
    sTime = 0
    eTime = 0
    countS = 0
    countE = 0
    cnt = 0

    for i in range(len(stratTime)):
        sTime = stratTime[i] + datetime.timedelta(seconds=1) - datetime.timedelta(seconds=0.001)
        # print("sTime type = %s"%type(sTime))
        eTime = completeTime[i] + datetime.timedelta(seconds=1) - datetime.timedelta(seconds=0.001)
        for j in range(len(stratTime)):
            # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            if i == j:
                countS += 1
                print("1식")
            # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            elif i < j and stratTime[i] < stratTime[j] and stratTime[j] < sTime:
                countS += 1
                print("2식")
                # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            elif i < j and stratTime[i] == stratTime[j]:
                countS += 1
                print("3식")
                # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            elif i < j and sTime == stratTime[j]:
                countS += 1
                print("4식")

            elif i > j and stratTime[i] == completeTime[j]:
                countS += 1
                print("5식")
                # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            elif i > j and stratTime[i] < completeTime[j]:
                countS += 1
                print("6식")
                # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            elif i > j and stratTime[i] == stratTime[j]:
                countS += 1
                print("7식")
                # print("startTime[i] = %s startTime[j] = %s  stime = %s" %(stratTime[i],stratTime[j],sTime))
            # print("countS = %s" %countS)
        for k in range(len(stratTime)):
            # print("startTime[i] = %s startTime[k] = %s  etime = %s" %(stratTime[i],stratTime[k],eTime))
            if i == k:
                countE += 1
            elif i < k and stratTime[k] > completeTime[i] and stratTime[k] < eTime:
                countE += 1  # 비교 시작 시간 > 기준 완료 시간 + 비교 시작 시간 < 기준 완료 마감 시간
            elif i < k and stratTime[k] > completeTime[i] and stratTime[k] == eTime:
                countE += 1  # 비교 시작 시간 > 기준 완료 시간 + 비교 시작 시간 == 기준 완료 마감 시간
            elif i > k and completeTime[i] < completeTime[k]:
                countE += 1
            # print("countS = %s" %countS)
        if countE > countS and cnt < countE:
            cnt = countE
        elif countE < countS and cnt < countS:
            cnt = countS
        elif countE == countS and cnt < countE:
            cnt = countE

        print(cnt)
        countE = 0
        countS = 0
    return cnt


solution(lines)