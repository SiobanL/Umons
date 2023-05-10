from tkinter import *
from token import Token
from random import randint

class Window:
    

    def __init__(self):
        """
        Crée la fenêtre principale incluant le titre, le nombre de pions blancs,
        les boutons pour créer et cacher les pions, et le canvas où sont dessinés les
        pions.
        """
        self.tk_window = Tk()
        title = 'Tentez de créer deux groupes ayant le même nombre de '
        title += 'jetons noirs après avoir caché et créé des jetons !'
        self.tk_window.title(title)
        self.tokens = {}
        self.hide = False
        self.nb_white_unhided = 0
        
        frame = Frame(self.tk_window, relief = RAISED, borderwidth = 1)
        frame.pack(fill = BOTH, expand = True)
                
        self.label_white = Label(frame, text = "Il y a " + str(self.nb_whites()) +\
             " jetons blancs")
        self.label_white.pack(side = LEFT)
        
        self.but_hide = Button(frame, text = "Cacher les jetons",\
             command = self.toggle_hide)
        self.but_hide.pack(side=RIGHT, padx=5, pady=5)
        
        self.but_create = Button(frame, text = "Créer des jetons",\
             command = self.create_tokens)
        self.but_create.pack(side=RIGHT)
        
        self.canvas = Canvas(self.tk_window, width=720, height=360, background='#009933')
        self.canvas.create_line(4, 0, 4, 360, width=3)
        self.canvas.create_line(0, 4, 720, 4, width=3)
        for i in range(1, 9):
            self.canvas.create_line(i*90, 0, i*90, 360, width=3)
            if i <= 6:
                self.canvas.create_line(0, i*60, 720, i*60, width=3)
        
        self._drag_data = {"x": 0, "y": 0, "item": None}
           
        self.canvas.bind("<Button-2>", self.right_click)    
        self.canvas.tag_bind("token", "<ButtonPress-1>", self.OnTokenButtonPress)
        self.canvas.tag_bind("token", "<ButtonRelease-1>", self.OnTokenButtonRelease)
        self.canvas.tag_bind("token", "<B1-Motion>", self.OnTokenMotion)
        self.canvas.pack()
        
    def rewrite_nb_whites(self):
        """
        Met à jour l'affichage du nombre de pions blancs. En mode caché,
        les pions blancs ne sont pas recalculés pour ne pas dénaturer l'énigme.
        """
        if not self.hide:
            self.label_white.config(text = "Il y a " + str(self.nb_whites()) +\
                 " jetons blancs")
            self.nb_white_unhided = self.nb_whites()
        else:
            self.label_white.config(text = "Avant de les manipuler, il y avait " +\
                 str(self.nb_white_unhided) + " jetons blancs")
            
        
    def nb_whites(self):
        """
        Calcule le nombre de pions blancs.
        """
        nb = 0
        for j in self.tokens:
            if self.tokens[j].color == "white":
                nb += 1
        return nb
        
    def create_tokens(self):
        """
        Créer aléatoirement des pions et les place dans le canvas.
        """
        self.canvas.delete("token")
        self.tokens.clear()
        nb = randint(5, 15)
        used = {}
        for i in range(nb):
            x = randint(0, 7) * 90 + 45
            y = randint(0, 5) * 60 + 32
            if (x, y) not in used:
                used[(x, y)] = ''
                self.add_token(x, y)
        self.label_white.config(text = "Parmi ces nouveaux jetons, il y a " +\
             str(self.nb_whites()) + " jetons blancs")
        self.nb_white_unhided = self.nb_whites()
        
    def add_token(self, x, y):
        """
        Ajoute un pion aux coordonnées (x, y)
        """
        j = Token(x, y, self.canvas)
        self.tokens[j.get_id()] = j
        if self.hide:
            j.hide()
        self.rewrite_nb_whites()
    
    def toggle_hide(self):
        """
        Bascule du mode caché au mode visible et inversément.
        """
        if not self.hide:
            self.hide = True
            self.but_hide.config(text = "Montrer les jetons")
            for j in self.tokens:
                self.tokens[j].hide()
        else:
            self.hide = False
            self.but_hide.config(text = "Cacher les jetons")
            for j in self.tokens:
                self.tokens[j].unhide()
        self.rewrite_nb_whites()
            
    
    def loop(self):
        """
        Lance la boucle principale de la GUI
        """
        self.tk_window.mainloop()
        
    def right_click(self, event):
        """
        Gère le click droit sur un pion : il va être retourné.
        """
        itemID = event.widget.find_closest(event.x, event.y)[0]
        if itemID in self.tokens:
            self.tokens[itemID].flip_color()
        self.rewrite_nb_whites()
                
    def OnTokenButtonPress(self, event):
        """
        Gère le début d'un drag and drop
        """
        # stocke l'item et sa position
        self._drag_data["item"] = self.canvas.find_closest(event.x, event.y)[0]
        self._drag_data["x"] = event.x
        self._drag_data["y"] = event.y

    def OnTokenButtonRelease(self, event):
        """
        Gère la fin d'un drag and drop
        """
        # réinitialise l'info d'un drag and drop
        self._drag_data["item"] = None
        self._drag_data["x"] = 0
        self._drag_data["y"] = 0

    def OnTokenMotion(self, event):
        """
        Gère un drag and drop en cours
        """
        # calcule combien cet objet a bougé
        delta_x = event.x - self._drag_data["x"]
        delta_y = event.y - self._drag_data["y"]
        # déplace l'objet
        self.canvas.move(self._drag_data["item"], delta_x, delta_y)
        # enregistre la nouvelle position
        self._drag_data["x"] = event.x
        self._drag_data["y"] = event.y