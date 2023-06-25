





def multiply(s: str, nb: int):
    if nb <= 1:
        return s
    else:
        return s + multiply(s, nb-1)


def print_from_midle(s: str,nb: int = 1)-> str:
    if nb == len(s):
        return s[(len(s)//2) + 1 - nb]
    else:
        return print_from_midle(s) + print_from_midle(s, nb + 1) + print_from_midle(s, nb + 2)


# print(multiply("a", 5))
string = "récursivité"
print(print_from_midle(string))
# print(string[5:5])
# print(string[4:6])
# print(string[3:7])
# print(string[2:8])
# print(string[1:9])
# print(string[0:10])