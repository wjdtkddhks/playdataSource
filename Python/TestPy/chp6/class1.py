class Test:
    def empty(self):
        self.data = []
    def add(self, x):
        self.data.append(x)

class Test02:
    _b = 100
    def __m(self):
        return 'a'
    def k(self):
        print(self.__m(), self._b, Test02._b)

if __name__ == "__main__":
    my04=Test02()
    print(Test02._b)
    print(my04._b)
    my04._b=6
    my04.k()
    Test02._b =70
    my04.k()
    print('====================')
    my01 = Test()
    my02 = my01
    my03 = Test()
    my01.empty()
    my03.empty()
    for i in range(1, 6):
        my01.add(i)

    print("my01 data:", my01.data)
    print("my02 data:", my02.data)
    print("my03 data:", my03.data)

    y=Test02()
    y.k()
    print('y.b1:',y._b)
    print('Test02()._b1:', Test02._b)
    y._b=2
    print('y.b2:',y._b)
    print('Test02()._b2:', Test02._b)
    Test02._b = 30
    print('y.b2:', y._b)
    print('Test02()._b2:', Test02._b)