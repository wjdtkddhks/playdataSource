import xlsxwriter #해당 모듈은 쓰기만 가능, 읽기 불가능, 대신 속도 업

wb = xlsxwriter.Workbook('xlsxwriter1.xlsx')
ws = wb.add_worksheet('테스트')

ws.write('A1', 'korea')
ws.write(3, 3, "test1") #해당 모듈은 0부터 col, row 시작함
ws.write(4, 4, 'test2')
ws.write('B1', 10)
ws.write('B2', 20)
ws.write('B3', '=sum(B1:B2)')
ws.write('A2', 'fighting')

wb.close()