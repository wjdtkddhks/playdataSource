n=100
sum = 0
counter = 1
while counter <=n:
    sum = sum+counter
    counter += 1
    if counter == 5:
        break
else:
    print("sum of 1 until %d : %d"%(n, sum))

print("counter :", counter)