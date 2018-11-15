class Emp:
    empno=0
    result=0

if __name__ == '__main__':
    a1=Emp()
    a1.empno='a111'
    a1.result=80
    a2 = Emp()
    a2.empno = 'b222'
    a2.result = 70
    a3 = Emp()
    a3.empno = 'c333'
    a3.result = 60

    print('a1:', a1.empno, a1.result)
    print('a2:', a2.empno, a2.result)
    print('a3:', a3.empno, a3.result)

    print('a2.__class__.result:', a2.__class__.result)
    print('a3.__class__.result:',a3.__class__.result)
    print('Emp.result:',Emp.result)
    print('==========================')
    a1.__class__.result=1000
    print('a2.__class__.result:', a2.__class__.result)
    print('a3.__class__.result:', a3.__class__.result)
    print('Emp.result:', Emp.result)
    print('==========================')
    a4=Emp()
    print('a4.result:', a4.result)
    print(Emp.__class__)
    print('Emp.__class__.name:', Emp.__class__.__name__)
    print(a1.__class__)
    print('a1.__class__.name:', a1.__class__.__name__)