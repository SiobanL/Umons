class Rational(data,other):
    def __init__(self, a: str = None, b:int = 1) -> None:
        from math import gcd
        
        if type(a) == str:
            a = a.replace(" ","")
            for char in a:
                if char not in "./0123456789":
                    raise ValueError(f"Cannot create a rational from this str: {a}")

            if len(a) == 3 and a[1] == "/":
                self.a, self.b = int(a[0]), int(a[2])
                a, b = int(a[2]), int(a[0])
            else:
                a = float(a)
            self.a, self.b = a,b

        elif type(a) == float:
            i = 0
            while (a%1 != 0 and i <7):
                a = round((a)*(10),7)
                i+=1
            self.a, self.b = int(a), 10**i

        elif a == None:
            self.a, self.b = 0,b

        elif((type(a) != int) or (type(b) != int)):
            raise ValueError(f"Cannot create a rational with a numerator of {type(a)}" if type(a) != int else f"Cannot create a rational with a denominator of {type(b)}")

        elif b == 0:
            raise ZeroDivisionError(f"Cannot create {self.a}/{self.b}: zero in denominator")

        else:
            self.a, self.b  = a if a != None else 0, b

        gcdV = gcd(self.a,self.b)
        self.a, self.b = self.a // gcdV,self.b // gcdV
        
        if b < 0:
            self.a,self.b = -a,-b
         
    def __str__(self) -> str:
        if (self.a % self.b) == 0:
            return str(self.a//self.b)
        return f"{self.a}/{self.b}"

    def __repr__(self) -> str:
        return f"Rational({self.a}, {self.b})"

    def __add__(self, other):
        if type(other) != Rational:
            other = Rational(float(other))
        if self.b == other.b:
            return Rational(self.a+other.a,self.b)
        else:
            return Rational(self.a*other.b+other.a*self.b,self.b * other.b)
    
    def __radd__(self, other):
        return self.__add__(other)
    
    def __mul__(self, other):
        if type(other) != Rational:
            other = Rational(float(other))
        return Rational(self.a*other.a,self.b*other.b)
    
    def __rmul__(self, other):
        return self.__mul__(other)
    
    def __float__(self):
        return self.a/self.b
    
    def get_numerator(self)-> int:
        return self.a
    
    def get_denominator(self)-> int:
        return self.b