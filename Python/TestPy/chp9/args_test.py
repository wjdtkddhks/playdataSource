import sys

if __name__ == '__main__':
    print('명령형 인자의 갯수:', len(sys.argv))

    for item in sys.argv:
        print(item, end=",")