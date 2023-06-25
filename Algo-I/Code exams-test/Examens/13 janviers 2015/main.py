def syracuse(n):
    if n != 1:
        print(n, end="| ")
        if n % 2 == 0:
            return syracuse(n /2)
        else:
            return syracuse(3*n+1)
    else:
        print(n)


def temp_vol(n, count= 0):
    if n != 1:
        if n % 2 == 0:
            count+=1
            return syracuse(n/2)
        else:
            count+= 1
            return syracuse(3*n+1)
    else:
        print(n)
        print(count)
    
t=[1,3,56]
t.sort()
# syracuse(3)
temp_vol(3)