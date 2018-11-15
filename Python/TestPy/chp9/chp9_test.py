import pickle,os

def write_list():
    fp = open('test.dat', 'wb')
    price = {"java":2000, "python":3000}
    pickle.dump(price, fp)
    pickle.dump("java", fp)
    pickle.dump("python", fp)
    pickle.dump("java", fp)
    pickle.dump("python", fp)
    pickle.dump("python", fp)
    pickle.dump("java", fp)
    pickle.dump("python", fp)
    fp.close()

def read_list():
    fp = open('test.dat', 'rb')
    buylist = []
    while True:
        data = pickle.load(fp)
        if fp.tell() == os.fstat(fp.fileno()).st_size:
            break
        else:
            if type(data) != dict:
                buylist.append(data)
            else:
                price = data

    fp.close()
    sellbook = max(buylist)

    print("the best selling book:", sellbook, ", Total sales:", price.get(sellbook)*buylist.count(sellbook))

if __name__ == '__main__':
    write_list()
    read_list()

