def plus_grand_bord2(w: str)-> str:
    res = ""
    for char in w:
        if not (char in res):
            res += char
    new = ""
    for i in range(len(res),len(w)):
        new += w[i]
        
    if (new[0] == w[0]):
        return new
    return None


def plus_grand_bord(w: str)-> str:
    pos = 0
    for i in range(1,len(w)):
        if w[:i] == w[-i:]:
            pos = i
    return w[:pos] if pos > 0 else None


def intersection(v: str,w: str)-> str:
    for i in range(0,len(w) if len(v)> len(w) else len(w)):
        pass
    return

def anagrammes(v: str, w: str)-> bool:
    return sorted(list(v)) == sorted(list(w))


###|Test-01|######################################
# print(plus_grand_bord("abdabda"))
# print(plus_grand_bord("souris"))
# print(plus_grand_bord("happy"))
# print(plus_grand_bord("aabdaabd"))
##################################################


###|Test-02|######################################
print(intersection("programme", "grammaire"))
print(intersection("cardinalite", "ordinateur"))
##################################################


###|Test-03|######################################
# print(anagrammes("marion", "romina"))
# print(anagrammes("happy", "papy"))
##################################################