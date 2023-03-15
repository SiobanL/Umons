def somme1(n):
    if n == 0:
        return 0
    else:
        somme1(n-1)+n


def somme2(n):
    if n == 0:
        return 0
    else:
        return somme2(n)+n


def somme3(n):
    if n == 0:
        return 0
    else:
        return n+somme3(n-1)


def somme4(n):
    if n == 0:
        res = 0
    else:
        somme4(n)+n
        return res


def somme5(n):
    return somme5(n-1)+n
