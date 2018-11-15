# -*- coding:utf-8 -*-
fi = int(input('첫번째 숫자를 입력하시오 =>'))
se = int(input('두번째 숫자를 입력하시오 =>'))

if fi>=se:
    big = fi
    small = se
else:
    big = se
    small = fi
print("\n", end="")
for i in range(small, big+1):
    print('** %d단 **'%i, end="\t")
print("\n", end="")

for num in range(1, 10):
    for i in range(small, big+1):
        print('%d * %d = %d'%(i, num, i*num), end="\t")
    print("\n", end="")