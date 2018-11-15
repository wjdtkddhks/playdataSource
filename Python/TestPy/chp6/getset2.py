class Car:
    def __init__(self):
        self._price = 0
        self._speed = 0
        self._color = None

    def get_price(self):
        return self._price

    def set_price(self, price):
        self._price = price

    price = property(get_price, set_price)

    def get_speed(self):
        return self._speed

    def set_speed(self, speed):
        self._speed = speed

    speed = property(get_speed, set_speed)

    def get_color(self):
        return self._color

    def set_color(self, color):
        self._color = color

    color = property(get_color, set_color)

if __name__ == '__main__':
    mycar = Car()
    mycar.price = 2000
    mycar.speed = 20
    mycar.color = 'red'

    print("가격:", mycar.price)
    print("속도:", mycar.speed)
    print("색상:", mycar.color)
