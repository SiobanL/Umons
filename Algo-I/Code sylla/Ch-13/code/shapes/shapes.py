import turtle

def get_pen():
    turtle.setup(500, 500)
    t = turtle.Turtle()
    t.speed(0)
    return t

pen = get_pen()

class Point:
    """ represente un point dans le plan """

    def __init__(self, x, y):
        """ construit un point a partir de ses coordonees (x, y)
        """
        self.x = x
        self.y = y
        
    def __str__(self):
        """ retourne un str avec les informations du point
        """
        s = '(%g, %g)' % (self.x, self.y)
        return s
    
    def translate(self, v):
        """ Effectue une translation du point
            en appliquant le vecteur v
        """
        self.x = self.x + v.x
        self.y = self.y + v.y
        
    def attract_pen(self):
        """ attire le stylo (tortue) sur le point lui-meme
        """
        pen.pu()
        pen.goto(self.x, self.y)    
        pen.pd()
        
    def draw(self):
        """ dessine le point
        """
        self.attract_pen()
        for i in range(10):
            pen.fd(1)
            pen.rt(36)

class Rectangle:
    """ represente un rectangle dans le plan
    """
    def __init__(self, w, h, c):
        """ construit un rectangle a partir de sa largeur w
            sa hauteur h et de son coin inferieur gauche c
        """
        self.width = w
        self.height = h
        self.corner = c
        
    def find_center(self):
        """ retourne un point qui est le centre du rectangle
        """
        center_x = self.corner.x + self.width / 2.0
        center_y = self.corner.y + self.height / 2.0
        return Point(center_x, center_y)
        
    def draw(self):
        """ dessine le rectangle
        """
        self.corner.attract_pen()
        for i in range(2):
            pen.fd(self.width)
            pen.lt(90)
            pen.fd(self.height)
            pen.lt(90)

class Square(Rectangle):
    """ represente un carre dans le plan
    """
    def __init__(self, l, c):
        """ construit un carré a partir de la longueur l d'un de
            ses côtés et de son coin inferieur gauche c
        """
        self.width = l
        self.height = l
        self.corner = c
        

class Segment:
    """ represente un segment dans le plan 
    """
    def __init__(self, startPoint, endPoint):
        """ construit un segment a partir de ses deux extremites
        """
        self.start = startPoint
        self.end = endPoint
        
    def __str__(self):
        """ retourne un str avec les informations du segment
        """
        s = '%s -- %s' % (self.start, self.end)
        return s
            
    def draw(self, showPoints = False):
        """ dessine le segment
        """
        self.start.attract_pen()
        pen.goto(self.end.x, self.end.y)
        if showPoints:
            self.start.draw()
            self.end.draw()
   

