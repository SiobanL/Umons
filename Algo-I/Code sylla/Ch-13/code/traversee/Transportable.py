class Transportable(object):
    def __init__(self, name):
        self.name = name
        self.hostiles = {}
        
    def __str__(self):
        return self.name
        
    def attaque(self, other):
        att = other.name in self.hostiles
        if att:
            return True, self.hostiles[other.name]
        else:
            return False, None
        
class Loup(Transportable):
    def __init__(self):
        super(Loup, self).__init__('Loup')
        self.hostiles['Chevre'] = 'Le loup dévore la chèvre'
        
class Chevre(Transportable):
    def __init__(self):
        super(Chevre, self).__init__('Chevre')
        self.hostiles['Chou'] = 'La chèvre mange le chou'
        
class Chou(Transportable):
    def __init__(self):
        super(Chou, self).__init__('Chou')
    
class Baton(Transportable):
    def __init__(self):
        super(Baton, self).__init__('Baton')
        self.hostiles['Loup'] = 'Le baton bat le loup'
        
class Feu(Transportable):
    def __init__(self):
        super(Feu, self).__init__('feu')
        self.hostiles['Loup'] = 'Le feu brule le baton'
    
if __name__ == '__main__':
    l = Loup()
    c = Chevre()
    
    print(l)
    print(c)
    att, raison = l.attaque(c)
    if att:
        print(raison)
    