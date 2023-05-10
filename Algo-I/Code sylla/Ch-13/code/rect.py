from point import Point

class Rectangle:
    """ represente un rectangle dans le plan
       attributs: width, height, corner
      (coin inferieur gauche, Point)
    """
    def __init__(self, w, h, c):
        self.width = w
        self.height = h
        self.corner = c
        
    def find_center(self):
        center_x = self.corner.x + self.width / 2.0
        center_y = self.corner.y + self.height / 2.0
        return Point(center_x, center_y)
        
p = Point(0, 0)
box = Rectangle(100, 200, Point(0, 0))
c = box.find_center()
print(c)
