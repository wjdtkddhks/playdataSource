import pickle

if __name__ == '__main__':
    fp = open('binary.dat', 'wb')
    pickle.dump(1, fp)
    pickle.dump(3.14, fp)
    pickle.dump('Hello World', fp)
    pickle.dump('안녕 파이썬!', fp)
    pickle.dump([1,2,3], fp)
    pickle.dump({4,5,6}, fp)
    pickle.dump({"line":0, "rectangle":1, "triangle":2}, fp)
    fp.close()
