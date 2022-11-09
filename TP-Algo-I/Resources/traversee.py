def init_problem(hard = False):
    """
       Initialise et retourne les variables définissant le problème
    """
    rive_A = ['Loup', 'Chevre', 'Chou']
    rive_B = []
    bateau = []
    boat_size = 1
    position_bateau = 'A'
    rules = []
    rules.append(('Chevre', 'Chou', 'La chevre mange le chou'))
    rules.append(('Loup', 'Chevre', 'Le loup mange la chevre'))

    if hard:
        rive_A.append('Baton')
        rive_A.append('Feu')
        boat_size = 2
        rules.append(('Baton', 'Loup', 'Le baton bat le loup'))
        rules.append(('Feu', 'Baton', 'Le feu brule le baton'))
    
    return rive_A, rive_B, bateau, position_bateau, rules, boat_size

def display_situation(rive_a, rive_b, bateau, pos_bateau, boat_size):
    print('\nRive A:', rive_a)
    print('~' * 30)
    places = boat_size - len(bateau)
    str_bateau = '   Bateau : ' + str(bateau) + ' -- ' + str(places) + ' place(s) libre(s)'
    if pos_bateau == 'A':
        print(str_bateau)
        print(' ' * 3 + '~' * 24)
        print('') 
    else:
        print('')
        print(' ' * 3 + '~' * 24)
        print(str_bateau)
    print('~' * 30)
    print('Rive B:', rive_b)

def get_user_choice(rive_a, rive_b, bateau, pos_bateau, boat_size):
    choices = []
    choices.append('Deplacer bateau')

    rive_bateau = rive_a
    if pos_bateau == 'B':
        rive_bateau = rive_b
    
    if len(bateau) > 0:
        for x in bateau:
            choices.append('Debarquer ' + x)
    if len(bateau) < boat_size:
        for x in rive_bateau:
            choices.append('Embarquer ' + x)

    print('\nQuelle est votre action ?')
    for i in range(len(choices)):
        print(str(i + 1) + '. ' + choices[i])
    opt = int(input('Entrez un nombre entre 1 et ' + str(len(choices)) + ' : '))
    if not 1 <= opt <= len(choices):
        return get_user_choice(rive_a, rive_b, bateau, pos_bateau, boat_size)
    else:
        return choices[opt-1]
        
def make_action(action, rive_a, rive_b, bateau, pos_bateau):
    """ 
        Retourne la valeur de pos_bateau car elle pourrait
        changer et que c'est une variable immuable
    """
    words = action.split()
    if words[0] == 'Deplacer':
        if pos_bateau == 'A':
            return 'B'
        else:
            return 'A'
    
    rive_bateau = rive_a
    if pos_bateau == 'B':
        rive_bateau = rive_b
    if words[0] == 'Embarquer':
        rive_bateau.remove(words[1])
        bateau.append(words[1])
    else:              # words[0] == 'Debarquer':
        rive_bateau.append(words[1])
        bateau.remove(words[1])
    return pos_bateau  # important !!!

def has_won(rive_A, bateau):
    return len(rive_A) == 0 and len(bateau) == 0
    
def check_lost(rive_A, rive_B, position_bateau, rules):
    rive_isolee = rive_A
    if position_bateau == 'A':
        rive_isolee = rive_B
    
    lost = False
    msg = ''
    for r in rules:
        guy1, guy2, event = r
        if guy1 in rive_isolee and guy2 in rive_isolee:
            lost = True
            msg += '  => ' + event + '\n'
    return lost, msg
    
def make_a_move(rive_A, rive_B, bateau, position_bateau, rules, boat_size):
    action = get_user_choice(rive_A, rive_B, bateau, position_bateau, boat_size)
    position_bateau = make_action(action, rive_A, rive_B, bateau, position_bateau)
    display_situation(rive_A, rive_B, bateau, position_bateau, boat_size)
    
    lost, msg = check_lost(rive_A, rive_B, position_bateau, rules)
    if lost:
        print('Malheureusement vous avez perdu !')
        print(msg)
    elif has_won(rive_A, bateau):
        print('Bravo ! Vous avez gagné !')
    else:
        make_a_move(rive_A, rive_B, bateau, position_bateau, rules, boat_size)

if __name__ == '__main__':
    print('L\'énigme de la traversée...')
    opt = input('Choisissez votre niveau facile (F) ou difficile (D) : ')
    hard = False
    if opt == 'D':
        hard = True 

    rive_A, rive_B, bateau, position_bateau, rules, boat_size = init_problem(hard)    
    display_situation(rive_A, rive_B, bateau, position_bateau, boat_size)
    make_a_move(rive_A, rive_B, bateau, position_bateau, rules, boat_size)
