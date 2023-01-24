############ EXO-3 #########################
def TriFourNbTuple(a,b,c,d):
    a,b,c,d = d,c,b,a
    return a,b,c,d

def TriFourNb(a,b,c,d):
    temp =  a
    a = d
    d = temp
    temp = b
    b = c
    c = temp
    return a,b,c,d
   
print(TriFourNbTuple(1,2,3,4)) 
print(TriFourNb(1,2,3,4))
############################################
############ EXO-4-A #######################
from math import pi

def volume(rayon):
    return 4/3*pi*rayon**3

print(volume(5))
############################################
############ EXO-4-B #######################
def calcPrice(BookNb,BookPrice,SendTaxFirst,SendTaxSecond,Promo):
    return (((BookNb*BookPrice)+(((BookNb-1)*SendTaxSecond))+SendTaxFirst)-(((BookNb*BookPrice)+(((BookNb-1)*SendTaxSecond))+SendTaxFirst)/100*Promo))

print(calcPrice(60,24.95,3,0.75,40))
############################################
############ EXO-4-C #######################
def ConvertKMtoM(d,timeM,timeS):
    #timeS = timeS + (timeM*60)
    #d = (d / 1.61)/1000
    #vMoy = d / timeS * 3.6
    return ((((d / 1.61)*1000) / (timeS + (timeM*60))) * 3.6)
    
print(ConvertKMtoM(10,43,30))
############################################
############ EXO-4-D #######################
from math import *

def calcAR(HstartH, HstartM,stepOne,StepTwo,StepThree):
    HstartM = HstartM + (TempByStepAdd(stepOne,StepTwo,StepThree)/60)
    if HstartM >= 60:
        HstartH = HstartH + (HstartM // 60)
        HstartS = round(((HstartM %60) %1) *60)
        HstartM = (HstartM % 60) // 1
    print("Vous etes arrivée a: ",HstartH,"h",HstartM,"m", HstartS,"s")
    
    
def TempByStepAdd(stepOne,StepTwo,StepThree):
    Nwalk = 15 + (8*60) 
    Swalk = 12 + (7*60)
    
    return stepOne * Nwalk + StepTwo * Swalk + StepThree * Nwalk

calcAR(6,52,1,3,1)
############################################
############ EXO-6 #########################
print(type(14-14))
print(type(1 + 6.9))
print(type(1.0 + 2.0))
print(type(18/7+1))
print(type(((3+2)*2.5)/(4*2)))
print(type(3**-1/2))
print(type(0*0.0))
############################################
############ EXO-7 #########################
"""

(a) print(’’Bonjour’)                           |probleme de double guillemet
(b) ’bla’ * 3.0                                 |probleme de type (on ne peut pas multiplier un str par un float)
(c) ((1 + 4) / (6 * 2)                          |manque une parenthèse a la fin
(d) int(’’14’’)                                 |ligne ok
(e) int(’3+4i’)                                 |on ne peutn pas convertir une addition en int
(f) ’3 * 3’ * 3 ** 2                            |ligne ok
(g) 3 + 2 / 0 + 2                               |div par 0 imposssible et la raison est la priorité des opérations
(h) print(’Il y a ’ + 31 + ’jours en janvier’)  |probleme de type int et str

"""
############################################
############ EXO-9 #########################
print("Hello world!")
print("Aujourd'hui")
print("C'est \"dommage!\"")
print("Hum \\nn/")
############################################