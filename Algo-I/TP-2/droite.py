def droite(p1,p2):
    """function who generate the equation of a straigth line

    Args:
        p2 (float tuple): contain var (x1,y1) as in math
        p2 (float tuple): contain var (x2,y2) as in math

    Returns:
        none: if x == y because x is the same
       a,b,c: because d ≡ ax + by = c as (a = y1 coordinate minus y2) and (b = x2 coordinate minus x1)
    """
    (x1,y1) = p1
    (x2,y2) = p2
    
    if (p1 == p2):
        return None
    
    if ((x2-x1)==0): # Div by 0
        a = 1
    else:
        a = -(y2-y1)/(x2-x1)
    
    c = a* x1 + x2 * y1
    return (a,x2,c)


def appartient(d,p):
    """for a point to belongs to a line 

    Args:
        d (triple tuples): x,y,z coordinate of a straigth line to test
        p (double tuples): x1,y1 coordinate of a point to test

    Returns:
        boolean: return true if p ∈ d else return false
    """
    a,b,c = d
    (x,y) = p
    return a*x + b*y == c
    

def paralleles(d1,d2):
    """this function watch if d1 //d2

    Args:
        d1 (triple tuples): Value of d1
        d2 (triple tuples): Value of d2

    Returns:
        boolean: if d2 // d1 return true or not
    """
    a1,b1,c1 = d1
    a2,b2,c2 = d2
    
    if((b1!=0 and b2!=0 and c1!=0 and c2!=0) and (a1/b1/c1 == a2/b2/c2)):
        return True
    
    return (b1 == 0 and b2 == 0)


def intersection(d1,d2):
    """this function return a point where d1 belong d2 and test if it's the same straigth line

    Args:
        d1 (triple tuples): Frist straigth line
        d2 (triple tuples): second straigth line

    Returns:
        float: return coordinate in x and y if d1 belong d2
    """
    if d1 == d2:
        return None #watch if d1 is the same to d2
    
    a1,b1,c1 = d1
    a2,b2,c2 = d2
    
    a1 = a1/b1
    a2 = a2/b2
    c1 = c1/b1
    c2 = c2/b2      #calcul for change form in mx+p
    
    if a2-a1 == 0:
        return None # if d1 does not belong
    
    x = -(c2-c1)/(a2-a1)
    y = a1*x + c1
    return (-x,y)


def droite_normale(d,p):
    """this function watch if d ⊥ p

    Args:
        d (triple tuples): coordinate of straigth line
        p (double tuples): coordinate of a point
    
    Returns:
        float: return coordinate in a,b and c
    """
    if d[1] == 0:
        return(0,1,-p[1])
    elif d[0] ==0:
        return(1,0,-p[0])
    
    b = -(-d[1])
    a = -((b*d[1])/d[0])
    c = -(-a*p[0]-d[1]*p[1])
    
    return(a,b,c)


def symetrie_orthogonale(d,p):
    if appartient(d,p):
        return p
    normale = droite_normale(d,p)
    (xo,yo) = intersection(d, normale)
    return 2*xo -p[0], yo*2 -p[1]


def distance_droite_point(d,p):
    if appartient(d,p):
        return 0.0
    a,b,c = d
    return abs(a+b+c)/(a**2 + b**2)**(1/2)