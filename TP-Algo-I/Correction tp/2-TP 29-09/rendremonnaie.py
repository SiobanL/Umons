def rendre_monnaie(prix, monnaie):
    x1, x2, x3, x4, x5 = monnaie # Décomposition du tuple en 5 nouvelles variables
    somme_client = x1 * 20 + x2 * 10 + x3 * 5 + x4 * 2 + x5
    rendre = somme_client - prix
    if rendre < 0:
        print("Pas assez d'argent")
    else:
        y1 = rendre // 20    # le nombre de billets de 20 que l'on peut retirer entièrement dans le montant à rendre
        rendre = rendre % 20 # on met à jour le montant à rendre en enlevant les billets de 20 ( = le reste de la division de ce montant par 20)
        y2 = rendre // 10    # le nombre de billets de 10 que l'on peut retirer entièrement dans le montant restant
        rendre = rendre % 10 # on met à jour le montant à rendre en enlevant les billets de 10 
        y3 = rendre // 5     # le nombre de billets de 5 que l'on peut retirer entièrement dans le montant restant
        rendre = rendre % 5  # on met à jour le montant à rendre en enlevant les billets de 5
        y4 = rendre // 2     # le nombre de pièces de 2 que l'on peut retirer entièrement dans le montant restant
        rendre = rendre % 2  # on met à jour le montant à rendre en enlevant les pièces de 2
        y5 = rendre          # nombre de pièce de 2
        return (y1, y2, y3, y4, y5)
