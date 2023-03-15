"""Outil de décompression.
Usage:
    compress.py (-c|-d) -t <technique> --in <fichier> [--out <fichier>]
    
Options:
    -c              compresser
    -d              décompresser
    -t <TECHNIQUE>  Technique
    --in <FICHIER>  Entrée
    --out <FICHIER> Sortie (optionel)
    -h --help       Show this screen.
"""
from docopt import docopt


class badADNformat():
    """
        Mauvais format l'ADN est toujours sous le format
        -a : Adenine
        -c : Cytosine
        -t : Thymine
        -g : Guanine
    """


def read(filename: str)-> str:
    try:
        with open(filename) as f:
            return f.read()
    except FileNotFoundError:
        print("Mauvais format de fichier seulement *.txt accapté.")


def readADNFile(filename: str)-> list:
    with open(filename, "r+") as f:
        resLst: list = f.readlines()
    for i in range(0,len(resLst)-1):
        for item in resLst[i]:
            if  item in "bcefghijklmaopqrstuvwxysz":
                raise badADNformat()
            
    return


def lempelZiv(string: str)-> tuple:
    wlist: list = []
    concatenate: str = ""
    for word in string.split(" "):
        if word not in wlist:
            wlist.append(word)
        concatenate += str(wlist.index(word))
    return (concatenate, wlist)


# def createFile(dico:list, indexes:str)->None:
#     with open("saves.txt", "w+") as f:
#         temp: str = ""
#         for item in dico:
#             temp += item + "/"
#         line1 = temp + "\n"
#         temp = ""
#         for item in indexes:
#             temp += item + "/"
#         line2 = temp + "\n"
#         f.write(line1+line2)


# def decompressdLZ(lst: list):
#     with open("saves.txt","r+") as f:
#         temp = f.readlines()
#         dicoLst: list = temp[0].split("/")
#         # indexes: list = temp[1].split("/")
#         dico: dict = {}
#         for i in range(0,len(dicoLst)-1):
#             dico[len(dico)] = dicoLst[i]
#         res: str = ""
#         for i in lst:
#             res += dico[i] + " "
#     return res


def rle(string: str)-> str:
    res: str = ""
    charCount: dict = {}
    for char in string:
        if char in charCount:
            charCount[char] += 1
        else:
            charCount[char] = 1
    for item in charCount:
        res += str(charCount[item]) + item
    return res


if __name__ != "__main__":
    arguments = docopt(__doc__,version="Serie 10 V1.0")
    print(arguments)

# print(lempelZiv("bite ah aha aha ah boite bite grosse bite drole"))
# print(lempelZiv(read("test.txt")))
# res = lempelZiv(read("test.txt"))
# createFile(res[1],res[0])
# print(decompressdLZ([0,1,0,2,3,0]))
readADNFile('adn.txt')