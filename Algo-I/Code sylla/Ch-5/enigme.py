def print_enigme(cig, meg):
    print('Voici une énigme mauvaise pour la santé.')
    print('Un fumeur peut confectionner 1 cigarette à partir de 3 mégots.')
    print('Il a', cig, 'cigarettes et', meg, 'mégots.')
    print('Combien de cigarettes pourra-t-il fumer au maximum ?')

def menu(cig, meg):
    print('\nFaites votre choix')
    print('  1. repondre à l\'énigme')
    print('  2. obtenir la solution')
    print('  3. avoir la solution et des explications détaillées')
    print('  4. redéfinir le nombre de mégots et de cigarettes')
    print('  5. quitter')
    
    ans = input('\nVotre choix (1-5) : ')
    if ans == '1':
        sol = int(input('Votre réponse : '))
        if sol != max_smoked_cig(cig, meg):
            print(sol, 'n\'est pas la bonne réponse :-(')
        else:
            print('Bravo !')
        menu(cig, meg)
    elif ans == '2':
        print('La solution est', max_smoked_cig(cig, meg))
        menu(cig, meg)
    elif ans == '3':
        print('Il a', cig, 'cigarettes et', meg, 'mégots.')
        sol = verbose_max_smoked(cig, meg)
        print('Au total, il a donc fumé', sol, 'cigarettes.')
        menu(cig, meg)
    elif ans == '4':
        cig = int(input('Nombre initial de cigarettes : '))
        meg = int(input('Nombre initial de mégots : '))
        print_enigme(cig, meg)
        menu(cig, meg)
    elif ans == '5':
        print('Bye !')
    else:
        print('Je n\'ai pas compris votre choix.')  
        menu(cig, meg)

def max_smoked_cig(cig, meg):
    """ On peut lire cette fonction comme une
        étape d'une simulation: 
          - si le fumeur peut le faire, il confectionne des cigarettes.
          - s'il lui en reste, il fume une cigarette.
          - s'il a encore de quoi faire une étape de la simulation,
            il effecture l'étape suivante (récursivement)
    """
    smoked = 0
    if meg >= 3:
        cig = cig + (meg // 3)
        meg = meg % 3    
    if cig > 0:
        smoked = smoked + 1
        cig = cig - 1
        meg = meg + 1
    if cig > 0 or meg >= 3:
        smoked = smoked + max_smoked_cig(cig, meg)
    return smoked
    
def verbose_max_smoked(cig, meg):
    smoked = 0

    if meg >= 3:
        print('Avec ses', meg, 'mégots, il confectionne', (meg // 3), 'cigarette(s).')
        cig = cig + (meg // 3)
        meg = meg % 3
        print('Il a donc', cig, 'cigarette(s) et', meg, 'mégot(s).')    
    if cig > 0:
        print('Il fume une cigarette.')
        smoked = smoked + 1
        cig = cig - 1
        meg = meg + 1
        print('Il a donc', cig, 'cigarette(s) et', meg, 'mégot(s).')    
    if cig > 0 or meg >= 3:
        smoked = smoked + verbose_max_smoked(cig, meg)
    else:
        print('Il ne peut plus rien faire.')
    return smoked


cig = 0
meg = 10        
        
print_enigme(cig, meg)
menu(cig, meg)
