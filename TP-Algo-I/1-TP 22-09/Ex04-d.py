import math

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