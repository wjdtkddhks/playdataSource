if __name__ == '__main__':
    my_id=input('enter your id :')
    if my_id =='a1234':
        print('welcome ', my_id)
        print('wow come on!!!!')
    else:
        print('wrong~~')

    number =1
    if 1<=number<=10:
        print('correct')
    else:
        print('wrong')

    num = int(input('input number:'))
    if num >= 90:
        print('good')
    elif 70<=num<90:
        print('nomal')
    else :
        print('bad')

if __name__ != '__main__':
    print(__name__)
else:
    print('main')