# -*- coding:utf-8 -*-
import xlsxwriter

wb = xlsxwriter.Workbook("xlsxwriter_chart.xlsx")
ws = wb.add_worksheet()
chart = wb.add_chart({'type': 'column'})

ws.write('A1', '성적표')
ws.write('A2', '이름')
ws.write('B2', '국어')
ws.write('C2', '영어')
ws.write('D2', '수학')

data = [('홍길동', 80, 70, 90), ('이기자', 90, 60, 80), ('김기자', 80, 80, 70)]

ws.write_row('A3', data[0])
ws.write_row('A4', data[1])
ws.write_row('A5', data[2])

chart.set_title({'name':'성적표'})
chart.set_x_axis({'name':'이름'})
chart.set_y_axis({'name':'점수'})

chart.add_series({'categories':'=Sheet1!$A$3:$A$5', 'values': '=Sheet1!$B$3:$B$5'})
chart.add_series({'categories':'=Sheet1!$A$3:$A$5', 'values': '=Sheet1!$C$3:$C$5'})
chart.add_series({'categories':'=Sheet1!$A$3:$A$5', 'values': '=Sheet1!$D$3:$D$5'})

ws.insert_chart('A8', chart)
wb.close()