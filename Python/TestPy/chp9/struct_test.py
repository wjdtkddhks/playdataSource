import struct

struct_fmt = '=16s2fi' #char[16], float[2], int
city_info = [
    ('서울'.encode(encoding='utf-8'), 37.566535, 126.977969, 9820000),
    ('뉴욕'.encode(encoding='utf-8'), 40.712784, -74.005941, 8400000),
    ('파리'.encode(encoding='utf-8'), 48.857351, -0.127758, 8300000)
    ]

with open('cities.dat', 'wb') as file:
    for city in city_info:
        # *는 리스트 요소를 하나씩 분리해서 매개변수로 입력시켜줌
        file.write(struct.pack(struct_fmt, *city))