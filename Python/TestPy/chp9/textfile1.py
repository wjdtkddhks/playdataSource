import os

if __name__ == '__main__':
    # path = 'c:/BigDeep'
    # if os.getcwd() != path :
    #     os.chdir(path)
    #     print(os.getcwd())
    fp = open('text.txt', 'wt', encoding='utf-8')
    print(fp.write('%d\n'%1))
    fp.write('%f\n'%3.14)
    fp.write('Hello World\n')
    fp.write('안녕 파이썬!')
    fp.close()