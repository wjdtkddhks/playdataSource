L = [1,2,3]

def func1():
    try:
        num = L[1]
    except IndexError:
        print('IndexError')
    else:
        print('Keep Going')

if __name__ =='__main__':
    func1()
