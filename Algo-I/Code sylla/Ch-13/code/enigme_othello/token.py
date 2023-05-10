import random

class Token:
    """
    Un Token représente un pion d'Othello. Il peut être du côté blanc
    ou noir, et peut-être caché. 
    
    En mode caché, le niveau de gris indique si le pion a été retourné (gris foncé)
    ou non (gris clair)
    """
    def __init__(self, x, y, canvas):
        """
        Crée un token placé (initialement) aux coordonnées (x, y) dans un canvas
        Sa couleur visible est générée aléatoirement
        """
        self.canvas = canvas
        self.color = "white"
        self.flipped = False
        self.hidden = False
        
        if random.randint(0, 1) == 0:
            self.color = "black"
        self.surface = self.canvas.create_oval(x-25, y-20, x+25, y+20,\
                       fill = self.color, tags = "token", width=2)
        
    def get_id(self):
        """
        Retourne l'ID du dessin du Token dans son canvas
        """
        return self.surface    
        
    def flip_color(self):
        """
        Retourne le pion d'Othello
        """
        if self.flipped:
            self.flipped = False
        else:
            self.flipped = True
            
        if self.color == "white":
            self.color = "black"
        else:
            self.color = "white"
            
        self.update_color()
        
    def hide(self):
        """
        Cache le pion en le coloriant en gris foncé s'il a été retourné et 
        et en gris clair sinon.
        """
        self.hidden = True
        self.update_color()
            
    def unhide(self):
        """
        Révèle la couleur d'un pion.
        """
        self.hidden = False
        self.update_color()
        
    def update_color(self):
        """
        Met à jour la couleur qui doit être affichée, en fonction du
        statut du pion (caché ou non).
        """
        if not self.hidden:
            self.canvas.itemconfig(self.surface, fill = self.color)
        else:
            if self.flipped:
                self.canvas.itemconfig(self.surface, fill = "#999999")
            else:
                self.canvas.itemconfig(self.surface, fill = "#BFBFBF")
        