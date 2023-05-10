def pgcd(a, b):
    while b > 0:
        r = a % b
        a = b
        b = r
    return a

class Rational:
    """ represente un nombre rationel
        attributs: num, den
    """
    
    """ Contrat """
    
    def __init__(self, num = 0, den = 1):
        if not (type(num) == type(1) or type(num) == type(1.0) or type(num) == type('')):
            msg = 'Cannot create a rational with a numerator of ' + str(type(num))
            raise ValueError(msg)
        if not (type(den) == type(1) or type(den) == type(1.0)):
            msg = 'Cannot create a rational with a denominator of ' + str(type(den))
            raise ValueError(msg)
        if isinstance(num, float):
            self.float2rat(num)
        elif isinstance(num, str):
            self.str2rat(num)
        else:
            self.num = num
            self.den = den
            if den == 0:
                msg = 'Cannot create ' + str(self) + ': zero in denominator'
                raise ZeroDivisionError(msg)
        self.simplify()        

    
    def simplify(self):
        if self.den < 1:
            self.num *= -1
            self.den *= -1
        if self.den > 0:
            div = pgcd(self.num, self.den)
            self.num //= div
            self.den //= div
    
    def __str__(self):
        if self.den == 1:
            return '%d' % self.num
        s = '%d/%d' % (self.num, self.den)
        return s

    def get_denominator(self):
        return self.den
		
    def get_numerator(self):
        return self.num

    def float2rat(self, x):
        sx = str(x)
        dot = sx.find('.')
        nf = len(sx) - dot - 1
        self.den = 10 ** nf
        self.num = int(self.den * x)
        
    def str2rat(self, s):
        s = s.replace(' ', '')
        slash = s.find('/')
        dot = s.find('.')
        try:
            if slash != -1:
                self.num = int(s[:slash])
                self.den = int(s[slash+1:])
            elif dot != -1:
                x = float(s) 
                self.float2rat(x)
            else:
                self.num = int(s)
                self.den = 1
        except ValueError as e: 
            msg = 'Cannot create a rational from this str: ' + s
            raise ValueError(msg)

    def __repr__(self):
        s = 'Rational(%d, %d)' % (self.num, self.den)
        return s
    
    def __add__(self, other):
        if isinstance(other, Rational):
            return Rational(self.num * other.den + other.num * self.den, 
                            self.den * other.den)
        elif isinstance(other, int) or isinstance(other, float):
            return self + Rational(other)
        else:
            raise NotImplemented('Case not implemented')

    def __radd__(self, other):
        return Rational(other) + self
       
    def __mul__(self, other):
        if isinstance(other, Rational):
            return Rational(self.num * other.num, 
                            self.den * other.den)
        elif isinstance(other, int) or isinstance(other, float):
            return self * Rational(other)
        else:
            raise NotImplemented('Case not implemented')
            
    def __rmul__(self, other):
        return Rational(other) * self
 
    def __float__(self):
        return self.num / self.den
  
    """ Exercices supplementaires """
       
    def __sub__(self, other):
        if isinstance(other, Rational):
            return Rational(self.num * other.den - other.num * self.den, 
                            self.den * other.den)
        elif isinstance(other, int) or isinstance(other, float):
            return self - Rational(other)
        else:
            raise NotImplemented('Case not implemented')
    
    def __rsub__(self, other):
        return Rational(other) - self
      
    def __div__(self, other):
        if isinstance(other, Rational):
            return Rational(self.num * other.den, 
                            self.den * other.num)
        elif isinstance(other, int) or isinstance(other, float):
            return self / Rational(other)
        else:
            raise NotImplemented('Case not implemented')
                
    def __rdiv__(self, other):
        return Rational(other) / self

    def __getitem__(self, index):
        if index == 0:
            return self.num
        elif index == 1:
            return self.den
        else:
            raise IndexError('Bad index for [] operator: use ' + str(index) + ' but only 0 and 1 are accepted')

    def __setitem__(self, index, value):
        if index == 0:
            self.num = value 
        elif index == 1:
            if value == 0:
                msg = 'Cannot set zero in denominator'
                raise ZeroDivisionError(msg)
            self.den = value 
        else:
            raise IndexError('Bad index for [] operator: use ' + str(index) + ' but only 0 and 1 are accepted')
        self.simplify()
    
    def __eq__(self, other):
        self.simplify() # juste pour etre sur... mais a priori deja fait
        return self.num == other.num and self.den == other.den

    def __lt__(self, other):
        return float(self) < float(other)

    def __le__(self, other):
        return float(self) <= float(other)
    
