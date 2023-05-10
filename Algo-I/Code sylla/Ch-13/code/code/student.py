class Student:
    """ represente un etudiant.
    """
    def __init__(self, last, first, age, section, ID):
        self.lastname = last
        self.firstname = first
        self.age = age
        self.section = section
        self.ID = ID
        

if __name__ == '__main__':
    s = Student('Baroud', 'Bill', 21, 'Computer Science', 14023)
    print(s)
