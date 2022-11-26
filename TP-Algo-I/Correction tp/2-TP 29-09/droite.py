import math

def is_equal(f1, f2, eps = 1e-6):
    return abs(f1 - f2) < eps

def droite(p1, p2):
    x1, y1 = p1
    x2, y2 = p2
    if is_equal(x1, x2) and is_equal(y1, y2):
        return None
    a, b = (y1 - y2, x2 - x1)
    c = a * x1 + b * y1
    return (a, b, c)

def appartient(d, p):
    a, b, c = d
    x, y = p
    return is_equal(a * x + b * y, c)

def paralleles(d1, d2):
    a1, b1, c1 = d1
    a2, b2, c2 = d2
    if is_equal(a1, 0) or is_equal(a2, 0):
        return a1 == a2
    return is_equal(float(b1) / a1, float(b2) / a2)

def intersection(d1, d2):
    a1, b1, c1 = d1
    a2, b2, c2 = d2
    det = a1 * b2 - b1 * a2
    if is_equal(det, 0):
        return None
    x = (c1 * b2 - b1 * c2) / det
    y = (a1 * c2 - c1 * a2) / det
    return (x, y)

def droite_normale(d, p):
    a, b, c = d
    x, y = p
    a1, b1 = (-b, a)
    c1 = a1 * x + b1 * y
    return (a1, b1, c1)

def symetrie_orthogonale(d, p):
    d_normale = droite_normale(d, p)
    xi, yi = intersection(d, d_normale)
    x, y = p
    return (2 * xi - x, 2 * yi - y)

def distance_droite_point(d, p):
    d_normale = droite_normale(d, p)
    xi, yi = intersection(d, d_normale)
    x, y = p
    return math.sqrt((x - xi)**2 + (y - yi)**2)
