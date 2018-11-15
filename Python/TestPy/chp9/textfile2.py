if __name__ == '__main__':
    fp = open('text.txt', 'rt', encoding='utf-8')

    # while True:
    #     line=fp.readline()
    #     if line == '':
    #         break
    #     print(line.strip())

    # lines = fp.readlines() #리스트 객체 반환
    # for line in lines:
    #     print(line.strip())

    contents = fp.read()
    print(contents)

    fp.close()