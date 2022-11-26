from droite import *

print("Test droite")
print(droite((-2, 0), (1, 1.5)))
print(droite((0, -3), (0, 5)))
print(droite((0, -1), (0, -1)))

print("Test appartient")
print(appartient((-0.5, 1, 1.0), (-2, 0)))
print(appartient((-0.5, 1, 1.0), (1, 1.5)))
print(appartient((-0.5, 1, 1.0), (0, 0)))

print("Test paralleles")
print(paralleles((0, 1, 1), (0, 2, 3)))
print(paralleles((-0.5, 1, 1.0), (0, 2, 3)))

print("Test intersection")
print(intersection((-0.5, 1, 1.0), (0, 2, 3)))
print(intersection((0, 1, 1), (0, 2, 3)))

print("Test droite_normale")
print(droite_normale((-0.5, 1, 1.0), (-2, 0)))
print(droite_normale((-0.5, 1, 1.0), (3, 4)))

print("Test symetrie_orthogonale")
print(symetrie_orthogonale((-0.5, 1, 1.0), (-2, 0)))
print(symetrie_orthogonale((-0.5, 1, 1.0), (3, 4)))

print("Test distance_droite_point")
print(distance_droite_point((-0.5, 1, 1.0), (3, 4)))
print(distance_droite_point((-0.5, 1, 1.0), (-2, 0)))
