
circle_area = lambda radius, pi : pi * (radius**2)

print(circle_area(3, 3.14))

"""def circle_view(radius, print_format):
    area = 3.14*(radius**2)
    print_format(area)

def precise_low(value):
    print("결과값:", round(value,1))

def precise_high(value):
    print("결과값:", round(value,2))"""

circle_view = lambda radius, print : print(3.14*(radius**2))
precise_low = lambda value : print("결과값:", round(value, 1))
precise_high= lambda value : print("결과값:", round(value, 2))
print_a = lambda key, value : print("a+b:", key+value)

if __name__ == '__main__':
    circle_view(3, precise_low)
    circle_view(3, precise_high)

a = ['a', 'b', 'c']
print(a)
print('a' in a)
print('lambda:', (lambda x,y,z: x*y*z)(1,2,3))

b=[1,2,3]

print('b1:', [x*2 for x in b])
print('b2:', [x*2 for x in b if x==3])
print('b3:', [[x,x*2] for x in b])