#!/usr/local/bin/python
# -*- coding: utf-8 -*-


""" Module dimg

Ce module fournit un mécanisme simple permettant d'afficher une image
graphiquement, sans nécessiter de bibliothèque externe autre que
Tkinter, installé par défaut avec la distribution Python 2.6+ requise.

Par convention, nous désignons "image" toute liste de listes contenant
des triplets de la forme (rouge, vert, bleu) où chaque couleur est
codée par un entier positif inférieur à 255.

Si M est une image, M[0] représente la première colonne et M[2][5] 
correspond au triplet RGB situé en 3e colonne, 6e ligne.

Pour afficher une image, il suffit d'appeler la fonction
display_image(image) en fournissant l'image en paramètre.

>>> image = [[(4*line, 4*col, 3*line) for line in range(40)] \
                                      for col in range(60)]
>>> display_image(image)

Il est également possible de décorer une fonction ayant une image comme
retour via le décorateur @autodisplay. 

Si le module Python Imaging Library (Image) est installé, la fonction 
create_from_file prend en paramètre le chemin vers une image et retourne
une liste de listes de triplets correspondante. 


Des images pré-enregistrées sont disponibles à des fins de test dans ce module.
Les images disponibles sont préfixées par "img_". 
Pour obtenir la liste des images, entrez :
>>> filter(lambda x: x.startswith('img_'), dir(dimg))
"""

from Tkinter import Tk, mainloop, Frame, Canvas, StringVar, Label, \
                    Button, BOTH, LEFT, RIGHT, Scrollbar, HORIZONTAL, X, Y
from math import sin


img_gradient = [[(4 * i, 4 * j, 3 * i) for i in range(40)] 
                                      for j in range(60)]

img_damier = [[(255 * int((i + j) % 2 == 0),) * 3 for i in range(40)]
                                                  for j in range(60)]
img_damier_rouge = [[(r, 0, 0) for (r, g, b) in line] for line in img_damier]
img_lignes = [[(255 * int(i % 2 == 0),) * 3 for i in range(40)]
                                            for j in range(60)]
img_sinus = [[(int(255 * abs(sin(i + j))),) * 3 for i in range(40)] 
                                                for j in range(60)]
img_sinus_2 = [[(int(255 * abs(sin(i * j))),) * 3 for i in range(80)] 
                                                  for j in range(120)]


class App(object):
    """
    Représente une fenêtre Tkinter destinée à afficher une image.
    Se reporter aux docstrings des méthodes pour plus d'informations.
    """
    
    def __init__(self, parent, image):
        """
        Etant donnée une fenêtre Tkinter parente et une image
        au sens défini dans le module, affiche l'image.
        """
        
        self.image = image
        self.size = 8
        self.canvas_w = self.size * len(self.image)
        self.canvas_h = self.size * len(self.image[0])
        
        self.frame = Frame(parent)
        self.frame.pack(fill = BOTH)
        
        parent.title('Display Image')
        
        innerframe = Frame(self.frame)
        scroll_x = Scrollbar(innerframe, orient = HORIZONTAL)
        scroll_y = Scrollbar(innerframe)
        self.canvas = Canvas(innerframe,
            width = 800, # min(800, self.canvas_w), 
            height = 500, # min(500, self.canvas_h), 
            xscrollcommand = scroll_x.set, yscrollcommand = scroll_y.set,
            scrollregion = (0, 0, self.canvas_w, self.canvas_h)
        )
        scroll_y.pack(side = RIGHT, fill = Y, expand = 1)            
        self.canvas.pack(fill = BOTH, expand = 1)
        scroll_x.pack(fill = X, expand = 1)
        
        scroll_x.config(command = self.canvas.xview)
        scroll_y.config(command = self.canvas.yview)        
        self.canvas.bind('<Motion>', self.mouse_move)

        innerframe.pack()

        self.text_label = StringVar()
        Label(self.frame, textvariable = self.text_label).pack(side = LEFT)
    
        Button(self.frame, text = '-', 
            command = lambda: self.change_size(-4)).pack(side = RIGHT)        
        Button(self.frame, text = '+', 
            command = lambda: self.change_size(4)).pack(side = RIGHT)
            
        self.display_image()

    def change_size(self, increment):
        """
        Change the size of one pixel into the image by the given increment.
        """
        self.canvas.create_rectangle(0, 0, self.canvas_w, self.canvas_h, 
            fill = '#000000')
        self.size = max(3, self.size + increment)
        self.canvas_w = self.size * len(self.image)
        self.canvas_h = self.size * len(self.image[0])
        self.canvas.config(scrollregion = (0, 0, self.canvas_w, self.canvas_h))
        self.display_image()
        
    def mouse_move(self, event):
        """
        Event handler pour les mouvements de souris sur le canvas.
        """
        
        x_coord = int(self.canvas.canvasx(event.x) / self.size)
        y_coord = int(self.canvas.canvasy(event.y) / self.size)
        try:
            color = self.image[x_coord][y_coord]
            self.text_label.set('Valeur en (%d, %d) : (%d, %d, %d)' %
                (x_coord, y_coord, color[0], color[1], color[2]))
        except IndexError:
            pass
        
    def display_image(self):
        """
        Affiche implicitement l'image dans la fenêtre courante.
        """
        
        [(self.canvas.create_rectangle(i * self.size,
            j * self.size, i * self.size + self.size,
            j * self.size + self.size,
            fill = '#%02x%02x%02x' % self.image[i][j]) )
            for i in range(len(self.image))
            for j in range(len(self.image[0]))]
        
    def close(self):
        """
        Ferme la fenêtre courante.
        Notez que cela ne ferme pas l'éventuelle fenêtre parente.
        """
        self.frame.quit()



def display_image(image):
    """ Etant donnée une image, tente de créer une fenêtre Tk()
    dans laquelle afficher cette image. Aucune erreur n'est
    gérée par la fonction elle-même, elles sont renvoyées à la
    console et peuvent donc concerner aussi bien Tkinter que
    le codage de l'image.
    """
    window = Tk()
    window.resizable(False, False)
    window.maxsize(800, 600)
    App(window, image)
    window.mainloop()


def autodisplay(func):
    """ Décorateur affichant automatiquement 
    en tant qu'image le retour de la fonction décorée. 
    """
    def __innerfunc(*args, **kwargs):
        result = func(*args, **kwargs)
        display_image(result)
        return result
    __innerfunc.__name__ = func.__name__
    __innerfunc.__doc__ = func.__doc__
    return __innerfunc
    
    
def create_from_file(filename):
    """ Si le module Image (python-imaging-library) est disponible, 
    retourne une liste de listes de tuples correspondant à l'image
    ciblée par filename. Notez qu'aucune exception/erreur n'est gérée
    dans cette fonction. 
    """
    import Image
    fp = Image.open(filename)
    max_col, max_line = fp.size
    return [[fp.getpixel((col, line))[0:3] for line in range(max_line)]
            for col in range(max_col)]


if __name__ == '__main__':
    # Exemple de définition de fonction utilisant le décorateur autodisplay
    @autodisplay
    def test_image():
        return [[(4*line, 4*col, 3*line) 
                for line in range(40)] 
                for col in range(60)] 
    test_image()
        
