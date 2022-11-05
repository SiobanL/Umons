def TriFourNbTuple(a,b,c,d):
    a,b,c,d = d,c,b,a
    return a,b,c,d

def TriFourNb(a,b,c,d):
    temp =  a
    a = d
    d = temp
    temp = b
    b = c
    c = temp
    return a,b,c,d
   
print(TriFourNbTuple(1,2,3,4)) 
print(TriFourNb(1,2,3,4))