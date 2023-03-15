def caractere(s, i):
    return None if (len(s)<i)or(i==0) else s[i-1]


def caracteres(s,i,j):
    res = ""
    if i > len(s) or j >len(s):
        return None
    
    for pos in range(i,j):
        res += s[pos]
    return res


def change_caractere(s,i,a):
    res=""
    if i > len(s):
        return None
    
    for pos, char in enumerate(s):
        if pos == i-1:
            res += a
        else:
            res+= char
    return res


def change_caracteres(s,i,j,t):
    res = ""
    if i > len(s) or j >len(s):
        return None
    
    for pos, char in enumerate(s):
        if i-1 <= pos <= j-1:
            indicator = 0
            for c in t:
                if indicator == 0:
                    res+= c
                else:
                    break
        else:
            res+= char
    return res

print(change_caracteres("happy", 1, 3, "you"))