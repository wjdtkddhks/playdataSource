import json

data = [{'a':'A', 'b':(2 , 4), 'c': 3.0}]
print('DATA:', repr(data))
print('DATA.type:', type(repr(data)))

data_str = json.dumps(data) #json.dumps - 해당파라미터를 json으로 변화
print('ENCODED:', data_str)
print('ENCODED.type:', type(data_str))

decoded = json.loads(data_str) #json.loads - json형태 파이썬객체로 다시 만듬
print('DECODED:', decoded)
print('DECODED.type:', type(decoded))

print('original:', type(data[0]['b']))
print('decoded:', type(decoded[0]['b']))