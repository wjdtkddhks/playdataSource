
mydic = {1:'a', 2:'b', 3:'c'}

if 1 in mydic:
    print(1)

if 'a' in mydic:
    print('a')

if 'a' in mydic.values():
    print('value: a')

if 'a' in mydic.items():
    print('items: a')

if 1 in mydic.items():
    print('items: 1')