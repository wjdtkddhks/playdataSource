#레퍼런스 사이트 : https://docs.python.org/3/library/struct.html
import struct, os

struct_fmt = '=16s2fi'
struct_len = struct.calcsize(struct_fmt) #struct.calcsize() : struct_fmt를 처리한 크기를 구함

cities = []
with open('cities.dat', 'rb') as file:
    while True:
        buffer = file.read(struct_len) #struct_len값 만큼 읽어서 bytes타입의 객체로 변환
        if not buffer:
            break
        city = struct.unpack(struct_fmt, buffer)
        cities.append(city)
        #if(file.tell() == os.fstat(file.fileno()).st_size): #해당 파일에 대한 총 크기 구함
        #   break

    for city in cities:
        name = city[0].decode(encoding='utf-8').replace('\x00', '')
        print('City : {0}, lat/lng :{1} / {2}, Population : {3}'.format(name, city[1], city[2], city[3]))