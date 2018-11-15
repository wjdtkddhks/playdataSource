class Num:
    def __init__(self, num):
        self.num = num
    def __add__(self, num):
        self.num *=num
    def __sub__(self, num):
        self.num /=num

class Car:
    def __init__(self):
        self.price = 2000
        self._speed = 0
        self.__color = 'red'

if __name__ == '__main__':
    n=Num(100)
    print(n.num)
    n+100
    print(n.num)
    n-100
    print(n.num)
    print('==============')
    mycar = Car()
    print(mycar.price)
    print(mycar._speed)
    # print(mycar.__color)