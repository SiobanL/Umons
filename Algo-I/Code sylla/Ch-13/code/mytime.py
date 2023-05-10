class Time:
    """ represente un temps (heure).
        attributs: hour, minute, second
    """
    def __init__(self, hour=0, minute=0, second=0):
        self.hour = hour 
        self.minute = minute 
        self.second = second 

    def __str__(self):
        s = '%02d:%02d:%02d' % (self.hour, self.minute, self.second)
        return s
    
    def __add__(self, other):
        res = Time()
        secs = self.to_sec()
        if isinstance(other, Time):
            secs += other.to_sec()
        elif isinstance(other, int):
            secs += other
        else:
            raise NotImplemented('op + only for Time and int')
        res.update(secs)
        return res
       
    def __radd__(self, other):
        return self.__add__(other)
            
    def to_sec(self):
        mins = self.hour * 60 + self.minute
        secs = mins * 60 + self.second
        return secs
        
    def update(self, secs):
        mins, self.second = divmod(secs, 60)
        self.hour, self.minute = divmod(mins, 60)
        
    def add(self, other):
        secs = self.to_sec() + other.to_sec()
        self.update(secs)
        
if __name__ == '__main__':
    t = Time(20, 45)
    duration = Time(1, 35, 0)
    print('Le film debute a', t, 'et dure', duration)
    t.add(duration)
    print('Il se terminera a', t)
