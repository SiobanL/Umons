from math import sqrt as sq


def map(f,list: list)-> list:
    res = []
    for i in list:
        res.append(f(i))
    return res


def filter(f, list: list):
    res = []
    for i in list:
        if f(i):
            res.append(i)
    return res


def reduce(f, list: list):
    temp = list[0]
    for i in list[1:]:
        temp = f(temp, i)
    return temp


def prime_numbers(n: int)-> list:
    if n == 0:
        return []
    else:
        primes = [2]
        candidate = 3
        while (len(primes)< n):
            is_prime = True
            for prime in primes:
                if prime > sq(candidate):
                    break
                if candidate % prime == 0:
                    is_prime = False
                    break
            if is_prime:
                primes.append(candidate)
            candidate += 2
    return primes


def is_prime(n):
    return n in prime_numbers(n)


def insert(seq, n):
    if len(seq) == 0 or n >= seq[-1]:
        seq.append(n)
    else:    
        for i in range(len(seq)):
            if n < seq[i] :
                list_n = [n]
                seq = seq[0:i] + list_n + seq[i:]
                break 
    return seq

def produit_matriciel(matrixF: list, matrixS: list)-> list:
    if (len(matrixF[0]) != len(matrixS)):
        return None
    
    if (len(matrixF[0]) == len(matrixS) and len(matrixS) == 0):
        return []
    
    matrixR = []
    for i in range(len(matrixF)):
        matrixR.append([])
        for j in range(len(matrixS[0])):
            sum = 0
            for k in range(len(matrixS)):
                sum += matrixF[i][k]*matrixS[k][j]
            matrixR[i].append(sum)
    return matrixR