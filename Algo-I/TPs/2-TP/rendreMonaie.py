def rendreMonaie(price,given):
    twenty , ten, five, two, one = given
    price = (twenty *20+ ten*10 + five*5 + two*2 + one) - price
    
    if price < 0:
        return None
    else:
        twenty = price // 20
        price = price % 20
    
        ten = price // 10
        price = price %10
    
        five = price //5
        price = price %5
    
        two = price // 2
        price = price %2
    
        one = price
    
    return (twenty, ten, five, two, one)

print(rendreMonaie(222,(10,5,5,5,5)))