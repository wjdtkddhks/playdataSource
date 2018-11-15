import pickle, os

if __name__ == '__main__':
    fp = open('binary.dat', 'rb')
    while True :
        if fp.tell() == os.fstat(fp.fileno()).st_size:
            break
        else:
            data = pickle.load(fp)
            print(data)
