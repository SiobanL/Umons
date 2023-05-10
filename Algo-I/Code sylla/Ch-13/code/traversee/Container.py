from Transportable import *

class Container:
    def __init__(self):
        self.elements = []
        self.limit = 0     # 0 signifie pas de limite
        self.name = 'Container'
        
    def __str__(self):
        res = self.name + ': '
        for k in self.elements:
            res += str(k) + ' - '
        if self.limit > 0:
            res += 'reste ' + str(self.nombre_places()) + ' place(s)'
        return res
        
    def nombre_places(self):
        if self.limit == 0:
            return 999999
        else:
            return self.limit - len(self.elements)
            
    def est_vide(self):
        return len(self.elements) == 0

    def ajoute(self, element):
        if self.nombre_places() > 0:
            self.elements.append(element)
            
    def retire(self, element):
        self.elements.remove(element)
            
    def analyse_danger(self):
        danger = False
        raisons = ''
        for k in self.elements:
            for j in self.elements:
                att, raison = k.attaque(j)
                if att:
                    danger = True
                    raisons += raison + '\n'
        return danger, raisons
        
class Rive(Container):
    def __init__(self, name):
        super(Rive, self).__init__()
        self.name = 'Rive ' + name
        
        
class Bateau(Container):
    def __init__(self):
        super(Bateau, self).__init__()
        self.name = 'Bateau'
        self.haut = True
        self.limit = 1
    
    def deplace(self):
        if self.haut:
            self.haut = False
        else:
            self.haut = True
        
class GrandBateau(Bateau):
    def __init__(self):
        super(GrandBateau, self).__init__()
        self.limit = 2
        
if __name__ == '__main__':
    b = Bateau()
    b.ajoute(Loup())
    b.ajoute(Chou())
    g = GrandBateau()
    g.ajoute(Chevre())
    r = Rive('A')
    r.ajoute(Loup())
    r.ajoute(Chevre())
    r.ajoute(Chou())
    print(b)
    print(g)
    print(r)
    danger, raisons = r.analyse_danger()
    if danger:
        print(raisons)