def cube(x):
    return x**3
def add(x, y):
    return x+y

if __name__ == "__main__":
    print('map1:',list(map(cube, range(1,5))))
    print('map1:',list(map(add, range(1,5), range(2,3))))
    print('filter1:', list(filter(lambda x : x%2==0, range(10))))