from random import *

lottolist = []
for i in sample(range(1, 46), 6):
    lottolist.append(i)

print(sorted(lottolist))

"""
def get_lotto_nuber():
    lotto_numbers = []
    while True:
        if len(lotto_number) == 6:
            break
            
        number = random.randint(1, 45)
    
        if number in lotto_numbers:
            cotinue
        else:
            lotto_numbers.append(number)
    
    return sorted(lotto_numbers)

아니면 중복되지 않는 set에 대입해서 일정수 이상 돌림.
"""