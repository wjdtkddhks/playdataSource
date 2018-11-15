class Person:
    name= 'python'
    age=20
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def aboutPerson(self):
        print("name:", self.name, ", age:"+ str(self.age))

    def __del__(self):
        print("__class__.name:", __class__.name, ", __class__.age:" + str(__class__.age))
        print('call del')

if __name__ == "__main__":
    per = Person('domingo', 59)
    per.aboutPerson()