class MyScore:
    def __init__(self, kor, eng):
        self.kor = kor
        self.eng = eng
    def getTo(self):
        return (self.kor + self.eng)

class MyScore_Sub(MyScore):
    def __init__(self, kor, eng, mat):
        super().__init__(kor, eng)
        self.mat = mat
    def getTo(self):
        return (str(super().getTo()+self.mat))

if __name__ == '__main__':
    print(MyScore(57,68).getTo())
    print(MyScore_Sub(57, 68,100).getTo())