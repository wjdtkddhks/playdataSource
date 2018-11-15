# -*- coding:utf-8 -*-

try:
    print('try-시작')
    a = int('string')
    print('try-종료')
except ZeroDivisionError:
    print('0으로 나루려 했거나')
except IOError:
    print("파일이 존재하지 않습니다.")
except ValueError:
    print('value error')
except:
    print('아님 다른 에러!!!')
else:
    print('else 왓어요')
finally:
    print('finally 왓어요')
