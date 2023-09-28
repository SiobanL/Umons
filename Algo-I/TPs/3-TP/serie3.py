
"""
    this script draw different fractal as kosh fractal as the fct who have the same name,
    a flake is draw with this too. there is a fct square who draw square fractal and a 
    tree fct  who drax a tree for active any fct you have to comment/decomment the line 
    who call the function you want to use   
"""
from uturtle import *

samy = umonsTurtle()

def drawLeft(t):
    """get size of screen and center the turtle to left

    Args:
        t (turtle type): use a turtle
    """
    dropPen(t)
    moveBackward(t,(turtle.screensize()[0]/2)+45)
    usePen(t)


def stand_up(t):
    """stand up turlte

    Args:
        t (turtle type): usa a turtle
    """
    turnLeft(t,90)
    
    
def koch(t,x,seuil):
    """draw a kosch line

    Args:
        t (umonsTurtle): use a turtle
        x (integer): use a var for size in px
        seuil (integer): threshold of the line don't draw
    """
    if(x < seuil):
        moveForward(t,x)
        return
    
    koch(t,(1/3*x),seuil)
    turnLeft(t,60)
    koch(t,(1/3*x),seuil)
    turnRight(t,120)
    koch(t,x/3,seuil)
    turnLeft(t,60)
    koch(t,x/3,seuil)


def flake(t,x,seuil,side_Nb,n):
    """draw flake

    Args:
        t (umonsTurtle): use a turtle
        x (integer): use a var for size in px
        seuil (integer): threshold of the line don't draw
    """
    if n >= 1:
        koch(t,x,seuil)
        turnLeft(t,360/side_Nb)
        flake(t,x,seuil,side_Nb,n-1)
    
    
def square(t,x,seuil):
    """draw a square with kosh line adapted

    Args:
        t (umonsTurtle): use a turtle
        x (integer): use a var for size in px
        seuil (integer): threshold of the line don't draw
    """
    if(x < seuil):
        moveForward(t,x)
        return
            
    square(t,(x/2),seuil)
    turnLeft(t,90)
    square(t,(x/2),seuil)
    turnLeft(t,-90)
    square(t,(x/2),seuil)
    turnLeft(t,-90)
    square(t,(x/2),seuil)
    turnLeft(t,90)
    square(t,(x/2),seuil)
    

def tree(t,x,a,n):
    """draw a tree

    Args:
        t (Turtle type): use a turtle
        x (integer): length of trunk
        a (integer): angle
        n (integer): number of tree branch
    """
    if n <= 1:
        moveForward(t,x)
        moveBackward(t,x)
    else:
        moveForward(t,x)
        turnLeft(t,a)
        tree(t,x*0.7,a*0.7,n-1)
        turnRight(t,2*a)
        tree(t,x*0.7,a*0.7,n-1)
        turnLeft(t,a)
        moveBackward(t,x)


#-----------------------#
# drawLeft(samy)
# koch(samy,500,15)
#-----------------------#

#-----------------------#
# flake(samy,75,15,10,10)
#-----------------------#

#-----------------------#
# square(samy,150,10)
#-----------------------#

#-----------------------#
# stand_up(samy)
# tree(samy,100,45,6)
#-----------------------#

wait()