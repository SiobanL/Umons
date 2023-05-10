from Transportable import *
from Container import *

class Action:
    def __init__(self, name):
        self.name = name
        
    def __str__(self):
        return self.name
        
    def realise_action(self):
        raise NotImplementedError
        
class Deplacer(Action):
    def __init__(self, b):
        self.name = 'Deplacer Bateau'
        self.bateau = b
        
    def realise_action(self):
        self.bateau.deplace()
        
        
class Embarquer(Action):
    def __init__(self, rive, b, elem):
        self.name = 'Embarquer ' + str(elem)
        self.rive = rive
        self.bateau = b
        self.element = elem
        
    def realise_action(self):
        self.rive.retire(self.element)
        self.bateau.ajoute(self.element)
        
class Debarquer(Action):
    def __init__(self, rive, b, elem):
        self.name = 'Debarquer ' + str(elem)
        self.rive = rive
        self.bateau = b
        self.element = elem
        
    def realise_action(self):
        self.bateau.retire(self.element)
        self.rive.ajoute(self.element)
        
if __name__ == '__main__':
    rive = Rive('A')
    c = Chevre()
    rive.ajoute(c)
    print(rive)

    b = Bateau()
    print(b)    
    
    a1 = Embarquer(rive, b, c)
    a2 = Deplacer(b)
    print(a1)
    a1.realise_action()
    print(a2)
    a2.realise_action()
    print(rive)
    print(b)
    
    