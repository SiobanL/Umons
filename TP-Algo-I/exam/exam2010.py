# class Domino():
#     def __init__(self, x: int, y: int) -> None:
#         if 0 <= x <= 6 or 0 <= y <= 6:
#             self.x = x
#             self.y = y
#         else:
#             raise Exception("Erreur: un domino est compris entre 0 et 6")

#     # def __str__(self) -> str:
#     #     return f"[{self.x} | {self.y}]"
    
#     def __repr__(self) -> str:
#         return f"[{self.x} | {self.y}]"
    
#     # def __repr__(self) -> str:
#     #     return f"Dominos({self.x},{self.y})"

#     def inverse(self):
#         self.x, self.y = self.y, self.x

#     def conciliableAvec(self, other):
#         if isinstance(other, Domino):
#             return self.y == other.x or self.y == other.y
#         else:
#             raise Exception("Erreur: vous n'avez pas donné un dominos")
            
#     def compatibleAvec(self, other):
#         if isinstance(other, Domino):
#             return self.y == other.x
#         else:
#             raise Exception("Erreur: vous n'avez pas donné un dominos")


# def suite_dominos(dominos: list[Domino], debut: Domino):
#     if len(dominos) == 0:
#         return [debut]
#     else:
#         for i, d in enumerate(dominos):
#             if debut.conciliableAvec(d):
#                 if not debut.compatibleAvec(d):
#                     d.inverse()
#                 suite = suite_dominos(dominos[:i]+ dominos[i+1:],d)
#                 if suite != None:
#                     return [debut] + suite
#     return None


# domino0 = Domino(1,4)
# domino1 = Domino(1,2)
# domino2 = Domino(5,2)
# domino3 = Domino(3,4)
# domino4 = Domino(4,5)

# dominos = [domino0,domino1,domino2,domino3]

# print(suite_dominos(dominos,domino4))

# # domino0 = Domino(3,1)
# # domino1 = Domino(1,2)
# # domino2 = Domino(6,1)
# # domino3 = Domino(6,3)

# # print(f"{domino0.conciliableAvec(domino1)} && {domino0.compatibleAvec(domino1)}")
# # print(f"{domino0.conciliableAvec(domino2)} && {domino0.compatibleAvec(domino2)}")
# # print(f"{domino0.conciliableAvec(domino3)} && {domino0.compatibleAvec(domino3)}")

from random import randint

def randomFloat(k):
    res = "0."
    if randint(0, 1) == 0:
        res = "-" + res
    for i in range(k):
        d = randint(0,9)
        res += str(d)
    return float(res)


def getPoint():
    return (randomFloat(10), randomFloat(10))


def isInCircle(p):
    (x, y) = p
    return x**2 + y**2 <= 1


def monteCarlo(n = 10000):
    inside = 0
    for i in range(n):
        p = getPoint()
        if isInCircle(p):
            inside += 1
        ratio = float(inside) / n
    return 4.0 * ratio

print(monteCarlo())