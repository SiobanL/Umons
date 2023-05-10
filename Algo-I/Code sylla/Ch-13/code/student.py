class Student:
    """ represente un etudiant.
    """
    def __init__(self, last, first, age, section, ID):
        self.lastname = last
        self.firstname = first
        self.age = age
        self.section = section
        self.ID = ID
        
    def __str__(self):
        s = 'Hello ! My name is ' + self.firstname + ' '
        s += self.lastname + ' and I\'m happy to study ' + self.section
        return s

if __name__ == '__main__':
    s = Student('Baroud', 'Bill', 21, 'Computer Science', 14023)
    print(s)
