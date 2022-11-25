from sys import argv


error = "Erro 404: not found function or parameter"


def read(filename:str)-> str:
    with open(filename,"r") as f:
        return f.read()


def readToDico(filename:str, mode: int)-> dict:
    """_summary_

    Args:
        filename (str): _description_
        mode (int): _description_

    Returns:
        dict: _description_
    """
    dico = {}
    mode = (0,2) if mode == 0 else (2,0)
    with open(filename,"r") as f:
        for line in f:
         dico[line[mode[0]]]=line[mode[1]]
    return dico


def clear(string: str)-> str:
    return "".join([c for c in string.lower() if "a"<= c <="z"])
    # return "".join(filter(lambda x: "a" <= x <= "z",string.lower())) # slower than under
    # res = ""                                                         # faster than upper
    # for char in string.lower():                                      # but slower than return "".join([c for c in string.lower() if "a"<= c <="z"])
    #     if "a" <= char <= "z":
    #         res += char
    # return res 


def chiffrement_decalage(text: str, pos: int)-> str:
    res = ""
    for char in clear(text):
        res += chr(((ord(char) - 97 - pos)%26)+97)
    return res


def dechiffrement_decalage(text: str, pos: int)-> str:
    chiffrement_decalage(text,-pos)


def substitution(dico: dict, string: str)-> str:
    res = ""
    for char in string:
        res += dico.get(char,char)
    return res


def chiffrement_substitution(text_filename, dico_filename)-> str:
    return substitution(readToDico(dico_filename,0),clear(read(text_filename)))


def dechiffrement_substitution(text_filename, dico_filename):
    return substitution(readToDico(dico_filename,1),clear(read(text_filename)))


def decouvre_cle(text_filename, i):
    dicoProba = {
                 'a' : 9.42,  'b' : 1.02, 'c' : 2.64, 'd' : 3.39,
                 'e' : 15.87, 'f' : 0.95, 'g' : 1.04, 'h' : 0.77,
                 'i' : 8.41,  'j' : 0.89, 'k' : 0.0,  'l' : 5.34,
                 'm' : 3.24,  'n' : 7.15, 'o' : 5.14, 'p' : 2.86,
                 'q' : 1.06,  'r' : 6.46, 's' : 7.90, 't' : 7.26,
                 'u':6.24,    'v' : 2.15, 'w' : 0.0,  'x' : 0.30,
                 'y' : 0.24,  'z' : 0.32
                }
    
    return


if __name__ != "__main__":
    if argv[1] == "d": 
        if argv[2] == "c":
            print(chiffrement_decalage(read(argv[3]),int(argv[4])))
        elif argv[2] == "d":
            print(dechiffrement_decalage(read(argv[3]),int(argv[4])))
        else:
            print(error)
    elif argv[1] == "s":
        if argv[2] == "c":
            print(chiffrement_substitution(read(argv[3]),int(argv[4])))
        elif argv[2] == "d":
            print(dechiffrement_substitution(read(argv[3]),int(argv[4])))
        else:
            print(error)
    elif argv[1] == "cle":
        print(decouvre_cle(read(argv[3]),int(argv[4])))
    else:
        print(error)

print(chiffrement_substitution("test.txt","dico.txt"))
print(dechiffrement_substitution("test2.txt","dico.txt"))
# print(chiffrement_decalage("abcdefghijklmnopqrstuvwxyz",2))
# print(clear(read("analyse.txt")))
# print(clear("CouCou c'est Sioéban"))