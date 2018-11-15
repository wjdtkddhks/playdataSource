def sum_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_n(n-1)

def pivona(n):
    if n <= 1:
        return 1
    else:
        return pivona(n-2) + pivona(n-1)


if __name__ == '__main__':
    print(sum_n(5))
    for i in range(0,10):
        print(pivona(i), end=" ")