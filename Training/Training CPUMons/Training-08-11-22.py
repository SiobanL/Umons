def find(mat: list, tag: str)->list:
    res = []
    for i in range(0,len(mat)):
        for j in range(0,len(mat[i])):
            if mat[i][j] == tag:
                res.append((i,j))
    return res


def posTerrain(n: int):
        
    return


def dateCor(date: str):
    day = int(date[0:2])
    month = int(date[3:5])
    year = int(date[6:])
    febFormat = 0
    
    if day > 31:
        return "bad format"
    if month > 12:
        return "bad format"
    if year <= 1900:
        return "bad format"
    
    if year % 4 == 0:
        febFormat = +1
        
    if ((month == 2) and (day > 28 + febFormat)):
        return "bad format"
    
    return "good format"

#################################################################
matrix = [
            [ "A" , "A" , "B" , "D" ],
            [ "C" , "P" , "U" , "A" ],
            [ "M" , "O" , "N" , "S" ],
            [ "A" , "B" , "D" , "A" ]
         ]
# print(find(matrix," "))

# print(posTerrain(4))

date = "03/04/2024"
print(dateCor(date))