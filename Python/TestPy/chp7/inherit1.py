class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def personInfo(self):
        return self.name + ": (age :" + str(self.age) + ")"

class Student(Person):
    def __init__(self, name, age, grade):
        # Person.__init__(self, name, age)
        super().__init__(name, age)
        self.grade = grade
    def getStudent(self):
        return self.personInfo() + ", grade : " + str(self.grade)

if __name__ == "__main__":
    x = Person('james', 15)
    y = Student('jone', 20, '우')
    # y.age = 10
    # y.name = 'domingo' #상속받은 게 아니라 y.age, y.name 새로운 필드를 만든것
    print(x.personInfo())
    print(y.personInfo())
