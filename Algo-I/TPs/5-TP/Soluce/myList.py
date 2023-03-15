import math

def map(func, sequence):
    """
    Retourne une liste contenant les elements de 'sequence' sur lesquels la 
    fonction 'func' a été appliquée.
    """
    result = []
    for elem in sequence:
        result.append(func(elem))
    return result

def filter(func, sequence):
    """
    Retourne une liste contenant les elements de 'sequence' qui respecte la 
    propriété représentée par la fonction booléenne 'func'.
    """
    result = []
    for elem in sequence:
        if func(elem):
            result.append(elem)
    return result

def reduce(f, sequence):
    """
    Retourne un element représentant la réduction de la liste 'sequence' par 
    la fonction 'func'.
    """
    acc  = sequence[0]
    for elem in sequence[1:]: # Plus besoin de considérer le premier
        acc = f(acc,elem)
    return acc

def prime_numbers(n):
    """
    Retourne une liste contenant les 'n' premiers nombres premiers.
    """
    if n == 0:
        return []
    else:
        primes = [2] # Le premier nombre premier est 2
        candidate = 3 # Le deuxième est 3
        # Tant qu'on n'a pas trouvé 'n' nombres premiers
        while len(primes) < n:
            # On vérifie si le candidat actuel est premier
            is_prime = True
            for prime in primes:
                if prime > math.sqrt(candidate):
                    break # On peut s'arreter de vérifier si on atteint la
                # racine
                if candidate % prime == 0:
                    is_prime = False # On peut s'arreter des qu'on trouve un
                    # diviseur
                    break
            if is_prime:
                primes.append(candidate)
            candidate += 2 # On sait que le seul nombre premier pair est 2 
    return primes

def is_prime(n):
    """
    Retourne True si 'n' est premier, False sinon.
    """
    if n == 0 or n == 1:
        return False
    # Pour chaque naturel entre 2 et n-1
    for i in range(2,n):
        # On peut s'arreter des qu'on trouve un diviseur
        if n % i == 0:
            return False
        # Plus besoin de vérifier si 'n' est premier quand on atteint un diviseur 
        # potentiel 'i' plus grand que la racine de 'n'.
        if i > math.sqrt(n):
            break
    # Si on sort de la boucle, c'est que nous n'avons pas trouvé de naturel qui
    # divise 'n'
    return True

# Version 1
def insert(seq, n):
    """
    Insère au bon endroit la valeur 'n' dans la liste triée 'seq'
    """
    seq.append(n) # On ajoute n à la fin
    p = len(seq) - 2
    # On va parcourir la liste et déplacer n à gauche tant
    # qu'il est plus petit que son prédecesseur
    while p >= 0 and seq[p] > seq[p+1]:
        # On inverse les éléments en position 'p' et 'p+1'
        seq[p],seq[p+1] = seq[p+1],seq[p]
        p -= 1

# Version 2
def insert_pop(seq, n):
    """
    Insère au bon endroit la valeur 'n' dans la liste triée 'seq'
    """
    acc = []
    # Dérouler
    while seq != [] and seq[-1] > n:
        acc.append(seq.pop())
    # Ajouter n
    seq.append(n)
    # Ré-enrouler
    while acc != []:
        seq.append(acc.pop())

def produit_matriciel(A,B):
    m = len(A) # nombre de lignes dans la matrice A
    n = len(B) # nombre de lignes dans la matrice B
    # Si une des deux listes est vide, le résultat sera vide
    if m == n and m == 0:
        return []
    # Si une seule des deux est vide ou que les dimensions ne sont pas
    # compatibles, on retourne None
    if m == 0 or n == 0 or len(A[0]) != n:
        return None
    p = len(B[0]) # Nombre de colonne dans la matrice B
    # On va créer une nouvelle matrice (vide au départ)
    C = []
    # Pour chaque ligne de la nouvelle matrice
    for i in range(m):
        line = []
        # Pour chaque colonne de la nouvelle matrice
        for j in range(p):
            # On calcule la somme donnée dans l'énoncé
            acc = 0
            for k in range(n):
                acc += A[i][k] * B[k][j]
            # On ajoute la valeur dans la ligne
            line.append(acc)
        # On ajoute la ligne dans la matrice
        C.append(line)
    return C

if __name__ == "__main__":
    l = [1,2,3,5,6,7]
    print("                     l =",l)
    print("   map (mise au carré) :", map(lambda x:x**2, l))
    print("filter (nombres pairs) :", filter(lambda x:x%2==0, l))
    print("     reduce (addition) :", reduce(lambda x,y:x+y, l))

    n = 10
    print()
    print(n,"premiers nombres premiers:",prime_numbers(n))
    print("filter (nombres premiers entre 30 et 50) :", filter(is_prime, range(30,50)))
    x=4
    print("Insérer",x,"dans",l,": ", end="")
    insert(l,x)
    print(l)
