def calcPrice(BookNb,BookPrice,SendTaxFirst,SendTaxSecond,Promo):
    return (((BookNb*BookPrice)+(((BookNb-1)*SendTaxSecond))+SendTaxFirst)-(((BookNb*BookPrice)+(((BookNb-1)*SendTaxSecond))+SendTaxFirst)/100*Promo))

print(calcPrice(60,24.95,3,0.75,40))