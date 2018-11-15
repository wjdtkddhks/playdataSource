def hello():
    return 3, 'abc', 'b'

n, s, d = hello()
print(n,s)
print(hello())

def repeat_msg(msg, abc=3):
    for i in range(abc):
        print(msg)

repeat_msg('hello')
print("=")
repeat_msg('hello', 2)
print("=")
repeat_msg('hello', abc=5)

def circle_area(pi, *radius):
    areas = []
    print(radius)
    for rad in radius:
        area = pi * (rad**2)
        areas.append(area)

    return areas
print("=")
print(circle_area(3.14, 3,4,5))
print("=")
print(circle_area(3.14, 6,7))
print("=")

def my_f(a, *args, **kwargs):
    print('a:', a)
    print('args:', args)
    print("kwargs:", kwargs)

my_f('반지름', 3, 4,id=123, pw=456)
print("=")
def circle_view(radius, *pi, **info):
    for item in pi:
        area = item*(radius**2)
        print("반지름:", radius, "PI:", item, "면적:", round(area,2))

    for key in info:
        print(key, ":", info[key])

circle_view(3, 3.14, 3.1415, line_color='파랑', area_color='노랑')


def my_d(a, *ar, **kwargs):
    print('a=', a)
    print('ar=', ar)
    print('kwargs= ', kwargs)

print('======case1======')
my_d(11)
print('======case2======')
my_d(11,22,33)
print('======case3======')
my_d(11,22,33, id='a123', pw=1234)

def abc(a, b):
    print("a:", a, end=" ")
    print("b:", b)

abc(1,2)
abc(b=1,a=2)
