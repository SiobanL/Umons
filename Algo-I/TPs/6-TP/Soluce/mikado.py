from random import sample, randint

def creerEnchevetrements(bag, i, max):
    num = randint(0,max) # On suppose max < len(bag)
    elems = sample(bag, num) # On suppose i not in bag
    enchev = list(map(lambda x : (x,i), elems)) # On crée l'enchevetrement (x,i)
    # pour chaque candidat choisi
    return enchev

def creerMikado(bag):
    jeu = []
    for i,b in enumerate(bag): # On a besoin de la baguette et de son indice
        # On enlève b du bag.
        # Le nombre maximum d'éléments est donc len(bag)-1
        jeu += creerEnchevetrements(bag[:i]+bag[i+1:],b,len(bag)-1)
    return jeu

def peutRetirer(i, bag, jeu):
    if i in bag:
        under = list(map(lambda x : x[0], jeu)) # On récupère toutes les
        # baguettes qui sont sous une autre baguette
        return i not in under # On peut retirer i s'il n'y a pas de baguette
        # au-dessus
    return False # Si i n'est pas dans bag, on ne peut pas le retirer

def quelOrdre(bag, jeu):
    if len(bag) == 0:
        return [] # Si pas de baguette, on peut gagner en ne retirant aucune
        # baguette
    for i,b in enumerate(bag): # On essaye de retirer toutes les baguettes
        if peutRetirer(b, bag, jeu): # Si on peut en retirer une on vérifie
            # qu'il existe un ordre pour le jeu obtenu
            jeu_filtre = list(filter(lambda x : x[1] != b, jeu)) # On enlève les
            # enchevètrements avec cette bagette
            order = quelOrdre(bag[:i]+bag[i+1:],jeu_filtre)
            if order is not None:
                return [b]+order # S'il existe un ordre pour le jeu sans b,
                # l'ordre pour le jeu avec b est simplement le même mais en enlevant
                # cette baguette d'abord.
    return None # Si on n'a pas pu retirer de baguette, il n'y a pas de
    # solution.


if __name__ == '__main__':
    bag = list(range(5))
    jeu = creerMikado(bag)
    print("bag :",bag)
    print("jeu :",jeu)
    order = quelOrdre(bag,jeu)
    if order is None:
        print("Pas de solution")
    else:
        print("ordre :", order)
