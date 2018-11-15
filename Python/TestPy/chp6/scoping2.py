pi = 3.1415

def circle_area(r):
    global  pi
    pi = pi+0.0015
    result = pi*(r**2)
    return result

def cicle_area_with_pi(r):
    #global pi
    pi = 3.14
    result = pi * (r**2)
    return result

def cicle_area_without_pi(r):
    result = pi * (r**2)
    return result

def sum_areas():
    results = [cicle_area_with_pi(3), cicle_area_without_pi(3)]
    return sum(results)

if __name__ == '__main__':
    print("PI:", pi)
    print('반지름:', 3, "면적:",cicle_area_with_pi(3))
    print('반지름:', 3, "면적:", cicle_area_without_pi(3))
    print(sum_areas())