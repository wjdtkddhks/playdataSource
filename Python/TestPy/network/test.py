
class Test :

    def __init__(self):
        self.mydic = {}


t1 = Test()
t2 = Test()
t1.mydic[1] = 'a'
print(t1.mydic[1])
print(t2.mydic[2])