class Circle:
    __PI = 3.14

    @classmethod
    def calculate_area(cls, radius):
        area = cls.__PI * (radius**2) #area= Circle.__PI*(radius**2)
        return round(area, 2)

    @classmethod
    def calculate_circumference(cls, radius):
        circumference = 2 * cls.__PI * radius
        return round(circumference, 2)

if __name__ == '__main__':
    print("반지름:", 3, "면적:", Circle.calculate_area(3))
    print("반지름:", 3, "둘레:", Circle.calculate_circumference(3))