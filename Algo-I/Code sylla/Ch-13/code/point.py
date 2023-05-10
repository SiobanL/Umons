class Point:
    """ represente un point dans le plan """

    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def __str__(self):
        s = '(%g, %g)' % (self.x, self.y)
        return s
    
    def translate(self, v):
        """ Effectue une translation du point
            en appliquant le vecteur v
        """
        self.x = self.x + v.x
        self.y = self.y + v.y
    
    def __eq__(self, other):
        if not isinstance(other, Point):
            return False
        return self.x == other.x and self.y == other.y
        
if __name__ == '__main__':
    p = Point(3, 4)
    print(p)
    p.translate(Point(2, -1))
    print(p)
