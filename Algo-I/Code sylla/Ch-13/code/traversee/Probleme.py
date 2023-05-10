from Container import *
from Transportable import *
from Action import *

class Probleme:
    def __init__(self):
        self.rive_haut = Rive('A')
        self.rive_bas = Rive('B')
        self.bateau = Bateau()
        self.rive_haut.ajoute(Loup())
        self.rive_haut.ajoute(Chevre())
        self.rive_haut.ajoute(Chou())
        
    def __str__(self):
        res = str(self.rive_haut) + '\n'
        res += '~' * 30 + '\n'
        if self.bateau.haut:
            res += str(self.bateau) + '\n'
            res += ' ' * 3 + '~' * 24 + '\n'
            res += '\n'
        else:
            res += '\n'
            res += ' ' * 3 + '~' * 24 + '\n'
            res += str(self.bateau) + '\n'
        res += '~' * 30 + '\n'
        res += str(self.rive_bas)
        
        return res
        
    def rive_bateau(self):
        if self.bateau.haut:
            return self.rive_haut
        else:
            return self.rive_bas
            
    def rive_isolee(self):
        if self.bateau.haut:
            return self.rive_bas
        else:
            return self.rive_haut
                
    def est_perdu(self):
        return self.rive_isolee().analyse_danger()
        
    def est_gagne(self):
        return self.rive_haut.est_vide() and self.bateau.est_vide()
        
    def actions_possibles(self):
        res = []
        res.append(Deplacer(self.bateau))
        for elem in self.bateau.elements:
            res.append(Debarquer(self.rive_bateau(), self.bateau, elem))
        for elem in self.rive_bateau().elements:
            res.append(Embarquer(self.rive_bateau(), self.bateau, elem))
        
        return res
        
class ProblemeDifficile(Probleme):
    def __init__(self):
        super(ProblemeDifficile, self).__init__()
        self.bateau = GrandBateau()
        self.rive_haut.ajoute(Baton())
        self.rive_haut.ajoute(Feu())

if __name__ == '__main__':
    print('Probleme facile:'.upper())
    pb = Probleme()
    print(pb)
    print('\nProbleme difficile:'.upper())
    hard_pb = ProblemeDifficile()
    print(hard_pb)
    print('Actions:'.upper())
    for a in hard_pb.actions_possibles():
        print(a)
    