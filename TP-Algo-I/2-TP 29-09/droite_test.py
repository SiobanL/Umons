import droite as d

print("------")
print("Ex03: ")
print("------")
print(d.droite((-2, 0), (1, 1.5)))
print(d.droite((0, -3), (0, 5)))
print(d.droite((0, -1), (0, -1)))

print("------")
print("Ex04: ")
print("------")
print(d.appartient((-0.5, 1, 1.0), (-2, 0)))
print(d.appartient((-0.5, 1, 1.0), (1, 1.5)))
print(d.appartient((-0.5, 1, 1.0), (0, 0)))

print("------")
print("Ex05: ")
print("------")
print(d.paralleles((0, 1, 1), (0, 2, 3)))
print(d.paralleles((-0.5, 1, 1.0), (0, 2, 3)))

print("------")
print("Ex06: ")
print("------")
print(d.intersection((-0.5, 1, 1.0), (0, 2, 3)))
print(d.intersection((0, 1, 1), (0, 2, 3)))

print("------")
print("Ex07: ")
print("------")
print(d.droite_normale((-0.5, 1, 1.0), (-2, 0)))
print(d.droite_normale((-0.5, 1, 1.0), (3, 4)))

print("------")
print("Ex08: ")
print("------")
print(d.symetrie_orthogonale((-0.5, 1, 1.0), (-2, 0)))
print(d.symetrie_orthogonale((-0.5, 1, 1.0), (3, 4)))

print("------")
print("Ex09: ")
print("------")
print(d.distance_droite_point((-0.5, 1, 1.0), (3, 4)))
print(d.distance_droite_point((-0.5, 1, 1.0), (-2, 0)))