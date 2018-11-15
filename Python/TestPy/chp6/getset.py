class Car:
    def __init__(self):
        self._price = 0
        self._speed = 0
        self._color = None

    @property
    def price(self):
        return self._price

    @price.setter
    def price(self, value):
        self._price = value

    @property
    def speed(self):
        return self._speed

    @speed.setter
    def speed(self, value):
        self._speed = value

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, value):
        self._color = value

if __name__ == '__main__':
    mycar = Car()
    mycar.price = 2000
    mycar.speed = 20
    mycar.color = 'red'

    print("가격:", mycar.price)
    print("속도:", mycar.speed)
    print("색상:", mycar.color)



#     def get_price(self):
#         return self._price
#     def set_price(self, price):
#         self._price = price
#     def get_speed(self):
#         return self._speed
#     def set_speed(self, speed):
#         self._speed = speed
#     def get_color(self):
#         return self._color
#     def set_color(self, color):
#         self._color = color
#
# if __name__ == '__main__':
#     mycar = Car()
#
#     mycar.set_price(2000)
#     mycar.set_speed(20)
#     mycar.set_color('red')
#
#     print("가격:", mycar.get_price())
#     print("속도:", mycar.get_speed())
#     print("색상:", mycar.get_color())
