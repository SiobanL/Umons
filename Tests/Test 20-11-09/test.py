def multiply(s: str, nb: int)-> str:
    return s + multiply(s,nb-1) if nb-1>0 else s


def print_from_middle(s,nb=1):
    newS =""
    if nb < 0:
        newS = print_from_middle(s,nb-2) + s[len(s)//2-nb+1] + print_from_middle(s,nb+1)
    return newS


print(print_from_middle("recursivite",2))