class A:
    def __init__(self):
        self.aa = 10

    def printA(self):
        print(self.aa)

class B(A):
    def __init__(self):
        # super().__init__()
        # A.__init__(self)
        super(B, self).__init__()
        self.bb = 20

    def printB(self):
        print(self.bb)

class C(B):
    def __init__(self):
        super().__init__()
        # B.__init__(self)
        # super(C, self).__init__()
        self.cc = 30
    def printC(self):
        print(self.cc)

if __name__ == '__main__':
    c = C()
    c.printA()
    c.printB()
    c.printC()
    print('a:', c.aa)
    print('b:', c.bb)
    print('c:', c.cc)