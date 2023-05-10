from Probleme import *

print('L\'énigme de la traversée...')
opt = input('Choisissez votre niveau facile (F) ou difficile (D) : ')
pb = Probleme()
if opt == 'D':
    pb = ProblemeDifficile()

perdu, raisons = pb.est_perdu()
while not pb.est_gagne() and not perdu:
    print(pb)
    actions = pb.actions_possibles()
    for i, a in enumerate(actions):
        print(i+1, a)
    choix = int(input('Entrez un nombre entre 1 et ' + str(len(actions)) + ' : '))
    if not 1 <= choix <= len(actions):
        print('Je ne comprend pas ce choix.')
    else:
        actions[choix-1].realise_action()
    perdu, raisons = pb.est_perdu()

if perdu:
    print(pb)
    print(raisons) 
    print('Perdu :-(')
else:
    print('Bravo !')