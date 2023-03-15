from sys import argv
from os import remove


error: str = "Error 404: function or parameter not found"


def read(filename:str)-> str:
    with open(filename,"r") as f:
        return f.read()


def clear(string: str)-> str:
    return "".join([c for c in string.lower() if "a"<= c <="z"])


def encrypt_gap(text: str, pos: int)-> str:
    res: str = ""
    for char in clear(text):
        res += chr(((ord(char) - 97 - pos)%26)+97)
    return res


def decrypt_gap(text: str, pos: int)-> str:
    return encrypt_gap(text,-pos)


def readToDico(filename:str, mode: int)-> dict:
    """ This function read all data in a file and create a dict.
        There is 2 modes one for have date in the same direction
        as in the file or inverse these direction.

    Args:
        filename (str): file path
        mode (int): choice 1 = same direction as in the file
                    choice 2 = the opposite than in the file

    Returns:
        dict: return dictionnary
    """
    dico: dict = {}
    mode: tuple = (0,2) if mode == 0 else (2,0)
    with open(filename,"r") as f:
        for line in f:
         dico[line[mode[0]]] = line[mode[1]]
    return dico


def substitution(dico: dict, string: str)-> str:
    res: str = ""
    for char in string:
        res += dico.get(char,char)
    return res


def encrypt_substitution(text_filename, dico_filename)-> str:
    return substitution(readToDico(dico_filename,0),clear(read(text_filename)))


def decrypt_substitution(text_filename, dico_filename):
    return substitution(readToDico(dico_filename,1),clear(read(text_filename)))


def returnLastLetter(inputList: list, referenceList: list)-> tuple:
    for char in "abcdefghijklmnopqrstuvwxyz":
        if not (char in inputList):
            return (returnStr(referenceList), char)
    return None 


def returnStr(referenceList: list)-> str:
    t: list = []
    for i in range(0, len(referenceList)):
        if referenceList[i][1] == 0.:
            t.append(referenceList[i][0])
    return t[len(t)-1]


def find_key(text_filename: str, length: int, refDico: dict)-> dict:
    if refDico == {}:
        refDico: dict = {       # fench frequency dictionary: frequency for every letter in french
                        'a' : 9.42,  'b' : 1.02, 'c' : 2.64, 'd' : 3.39,
                        'e' : 15.87, 'f' : 0.95, 'g' : 1.04, 'h' : 0.77,
                        'i' : 8.41,  'j' : 0.89, 'k' : 0.0,  'l' : 5.34,
                        'm' : 3.24,  'n' : 7.15, 'o' : 5.14, 'p' : 2.86,
                        'q' : 1.06,  'r' : 6.46, 's' : 7.90, 't' : 7.26,
                        'u' : 6.24,  'v' : 2.15, 'w' : 0.0,  'x' : 0.30,
                        'y' : 0.24,  'z' : 0.32
                        }
    else:
        refDico: list = sorted(refDico.copy().items(), key=lambda x: x[1], reverse=True)
    tempDico: dict = {}
    text: str = clear(read(text_filename))
    for char in text:
        if char in tempDico:
            tempDico[char] += 1/len(text)
        else:
            tempDico[char] = 1/len(text)
    tempDico: list = sorted(tempDico.items(), key=lambda x: x[1], reverse=True)
    lastDicoItem: tuple = (returnLastLetter(tempDico,refDico))
    retDico: dict = {}
    for i in range(0,26 if length > 26 else length):  # alphabet contain 26 letters
        if i >= len(tempDico):
            retDico[lastDicoItem[0]] = lastDicoItem[1]
        else:
            retDico[refDico[i][0]] = tempDico[i][0]
    return retDico


def decodeAnalyse()-> str:
    analyDico: dict ={
                    'a' : 7.58,  'b' : 0.51, 'c' : 4.05, 'd' : 3.92,
                    'e' : 13.69, 'f' : 1.69, 'g' : 1.11, 'h' : 0.76,
                    'i' : 9.43,  'j' : 0.13, 'k' : 0.18, 'l' : 5.9 ,
                    'm' : 4.06,  'n' : 7.87, 'o' : 6.35, 'p' : 2.75,
                    'q' : 1.53,  'r' : 6.06, 's' : 7.66, 't' : 7.92,
                    'u' : 5.51,  'v' : 0.79, 'w' : 0.06, 'x' : 0.25,
                    'y' : 0.26,  'z' : 0.
                    }
    decodeDict: dict = find_key("analyse.txt",26,analyDico)
    with open("temp.txt","w+") as f:
        data: str = ""
        for char in decodeDict:
            currentData = char + " " + decodeDict[char] + "\n"
            data = currentData + data
        f.write(data)
    res = decrypt_substitution("analyse.txt","temp.txt")
    remove("temp.txt")
    return res


if __name__ == "__main__":
    if argv[1] == "d": 
        if argv[2] == "c":
            print(encrypt_gap(read(argv[3]),int(argv[4])))
        elif argv[2] == "d":
            print(decrypt_gap(read(argv[3]),int(argv[4])))
        else:
            print(error)
    elif argv[1] == "s":
        if argv[2] == "c":
            print(encrypt_substitution(read(argv[3]),int(argv[4])))
        elif argv[2] == "d":
            print(decrypt_substitution(read(argv[3]),int(argv[4])))
        else:
            print(error)
    elif argv[1] == "cle":
        print(find_key(read(argv[3]),26,{}))
    elif argv[1] == "analyse":
        print(decodeAnalyse())
    elif argv[1] == "zeroDay":
        print(encrypt_gap("Coucou c'est Sioébèan",22))
        print(decrypt_gap(read("decalage.txt"),21))
        print(encrypt_substitution("test.txt","dico.txt"))
        print(decrypt_substitution("decryptsubstitution.txt","dico.txt"))
        print(decodeAnalyse())
    else:
        print(error)


# def clear(string: str)-> str:
#     #return "".join([c for c in string.lower() if "a"<= c <="z"])       # faster function !
#     # return "".join(filter(lambda x: "a" <= x <= "z",string.lower()))  # slower than under
#     # res = ""                                                          # faster than upper
#     # for char in string.lower():                                       # but slower than 
#     #     if "a" <= char <= "z":                                        # return "".join([c for c in string.lower() 
#     #         res += char                                               # if "a"<= c <="z"])
#     # return res 