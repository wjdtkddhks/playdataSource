x = 50

def func():
    #global x
    #print("x is", x)
    x=2
    print('changed global x to', x)

def circle_area(r):
    #result = 3.14 * (r**2)
    result = 3.14 * (radius**2)
    return result

if __name__ == '__main__':
    radius = 3
    area = circle_area(radius)
    print("반지름: %d, 면적: %.2f"%(radius, area))
    func()
    print(x)