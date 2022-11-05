from random import randint as r


def creer_enchevetremetns(bag, i, max_enchevetrements):
    res = []
    
    for k in range(r(1,max_enchevetrements)):
        x = r(0,len(bag))
        res.append((x,i))
        
    return list(set(res))


def creer_mikado(bag):
    res = []
    for i in range(len(bag)):
        res.append(creer_enchevetremetns(bag,i,len(bag)-1))
        
    return res


def peut_retirer(i, bag, jeu):
    if i not in bag:
        return False
    for (j) in jeu:
        if i == j:
            return False
    return True


def quel_ordre(bag, jeu):
    if len(bag) == 0:
        return []
    for i,b in enumerate(bag): 
        if peut_retirer(b, bag, jeu):
            jeu_filtre = list(filter(lambda x : x[0] != b, jeu)) 
            order = quel_ordre(bag[:i]+bag[i+1:],jeu_filtre)
            if order is not None:
                return [b]+order 
    return None


# beta test :)
bag = [0,1,2,3]
jeu = creer_mikado(bag)
# print(creer_enchevetremetns(bag,10,5))
# print(creer_mikado(bag))
print(quel_ordre(bag,jeu))