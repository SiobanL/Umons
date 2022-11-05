def somme1(n):
    if n == 0:
        return 0
    else:
        somme1(n-1)+n
        
    # retourne toujours 0 lorsque n = 0 donc recursion infinie


def somme2(n):
    if n == 0:
        return 0
    else:
        return somme2(n)+n
    
    # on décremente jamais n donc recursion infinie


def somme3(n):
    if n == 0:
        return 0
    else:
        return n+somme3(n-1)

    # bonn fonction on additionne le chiffre a chaque passage

def somme4(n):
    if n == 0:
        res = 0
    else:
        somme4(n)+n
        return res
    # res est initialiser que lorsque l'on passe dans le cas n == 0 mais on ne décremente jamais donc donc c'est une récrsion infinie

def somme5(n):
    return somme5(n-1)+n

    # on a pas de cas de base donc on ne sort jamais de la récursion