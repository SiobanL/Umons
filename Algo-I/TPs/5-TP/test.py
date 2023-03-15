import Serie5 as myList
import math

#Ex01-----------------------------------------------------+
print(myList.map(math.sqrt,[]))                          #|
print(myList.map(math.sqrt, [2.0, 4.0, 6.0, 100.0]))     #|
print(myList.map(str.upper, list("hello")))              #|
print(myList.prime_numbers(5))                           #|
print(myList.filter(str.isalpha, list('r2d2')))          #|
print(myList.reduce(math.pow, [2, 2]))                   #|
print(myList.reduce(math.pow, [2, 3, 4]))                #|
#---------------------------------------------------------+

#Ex02-----------------------------------------------------+
print(myList.prime_numbers(1))                           #|
print(myList.prime_numbers(12))                          #|
#---------------------------------------------------------+

#Ex03-----------------------------------------------------+
print(myList.is_prime(1))                                #|
print(myList.is_prime(2))                                #|
print(myList.is_prime(3))                                #|
print(myList.is_prime(33))                               #|
#---------------------------------------------------------+

#Ex04-----------------------------------------------------+
print(myList.insert([], 1))                            #|
print(myList.insert(list(range(6)),-1))                #|
print(myList.insert(list(range(6)), 3))                #|
print(myList.insert(list(range(6)),10))                #|
#---------------------------------------------------------+

#Ex05---------------------------------------------------------------------------------+
print(myList.produit_matriciel([[2, 0, 1], [3, 6, 2]], [[1, 5], [2, 6], [3, 7]]))    #|
print(myList.produit_matriciel([[1, 5], [2, 6], [3, 7]], [[2, 0, 1], [3, 6, 2]]))    #|
print(myList.produit_matriciel([[1.0, 2.5]], [[3.0], [4.5]]))                        #|
print(myList.produit_matriciel([[1.0, 2.5]], [[3.0, 4.5]]))                          #|
print(myList.produit_matriciel([[1, 5], [2, 6], [3, 7]], [[1, 5], [2, 6], [3, 7]]))  #|
#-------------------------------------------------------------------------------------+