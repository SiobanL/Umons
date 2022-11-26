#!/usr/bin/python3
# -*- coding: utf-8 -*-
from math import pi
from uturtle import *


def polygon(t, length, n):
    angle = 360/n  # on calcule l'angle de la rotation après chaque côté.
    for i in range(n):  # pour chaque côté
        moveForward(t, length)  # on dessine la ligne
        turnRight(t, angle)  # on tourne pour dessiner le côté suivant


def circle(t, r):
    num_cote = 360  # on va dessiner un polygone avec beaucoup de côtés
    # chaque côté aura une longueur égale au périmètre du cercle divisé par le
    # nombre de côtés.
    long_cote = (2*pi*r)/n
    polygon(t, long_cote, num_cote)


def koch(t, x, seuil):
    if x < seuil:  # si on atteint le seuil, on dessine juste une ligne
        moveForward(t, x)
    else:
        m = x / 3.0  # on calcule la taille des nouvelles courbes de koch
        koch(t, m, seuil)  # on dessine une courbe de koch plus petite
        turnLeft(t, 60)  # on continue suivant la forme donnée dans l'énoncé
        koch(t, m, seuil)
        turnRight(t, 120)
        koch(t, m, seuil)
        turnLeft(t, 60)
        koch(t, m, seuil)


def flocon(t, x, seuil):
    # un flocon de koch est un triangle sur pointe dans lequel on remplace
    # chaque côté par une courbe de koch
    n = 3
    a = 360. / n
    for i in range(n):
        koch(t, x, seuil)
        turnRight(t, a)


def carre(t, x, seuil):
    if x < seuil:
        moveForward(t, x)
        # return termine la fonction et empêche d'exécuter la suite si on
        # rentre dans cette condition
        return
    # le code est très proche de koch mais avec une forme différente:
    #   _
    # _| |_ au lieu de _/\_ pour koch

    m = x / 3.0
    carre(t, m, seuil)
    turnLeft(t, 90)
    carre(t, m, seuil)
    turnRight(t, 90)
    carre(t, m, seuil)
    turnRight(t, 90)
    carre(t, m, seuil)
    turnLeft(t, 90)
    carre(t, m, seuil)


def arbre(t, x, a, n):
    if n == 0:
        # profondeur nulle, on ne fait rien
        return
    m = x * 0.8  # on rétrécit le prochain arbre
    # o = a * 0.7 # on diminue l'angle du prochain arbre
    o = a
    moveForward(t, x)  # on trace le tronc
    # premier arbre
    turnLeft(t, a)  # on va à gauche
    arbre(t, m, o, n - 1)  # on trace le sous arbre gauche
    # deuxième arbre
    turnRight(t, 2 * a)  # on va a droite
    arbre(t, m, o, n - 1)  # on trace le sous arbre droit
    # on revient à la racine de l'arbre sans tracer
    turnLeft(t, a)  # retour au centre
    dropPen(t)
    moveBackward(t, x)
    usePen(t)


bob = umonsTurtle()
# Les deux instructions suivantes rendent la tortue plus rapide.
bob.speed(0)
turtle.delay(0)

# circle(bob,200)
# circle(bob,150)
# circle(bob,100)
# circle(bob,50)
# koch(bob, 250, 5)
flocon(bob, 200, 4)
# carre(bob, 250, 5)
# turnLeft(bob, 90)
# arbre(bob, 60, 30, 7)

wait()
