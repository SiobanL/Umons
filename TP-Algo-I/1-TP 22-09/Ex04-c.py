def ConvertKMtoM(d,timeM,timeS):
    #timeS = timeS + (timeM*60)
    #d = (d / 1.61)/1000
    #vMoy = d / timeS * 3.6
    return ((((d / 1.61)*1000) / (timeS + (timeM*60))) * 3.6)
    
print(ConvertKMtoM(10,43,30))