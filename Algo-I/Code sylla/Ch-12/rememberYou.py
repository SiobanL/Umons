import shelve
from datetime import datetime

date = datetime.now()
db = shelve.open('rem_data')
if len(db) == 0:
    db['nb_connections'] = 1
    print('Bonjour !\nIl me semble que c\'est la première fois que nous discutons.')
    db['name'] = input('Comment vous appellez-vous ?\n')
    print('Joli prénom !')
    db['age'] = input('Si ce n\'est pas indiscret... quel âge avez-vous ?\n')
    print('Oh ! Vous ne les faites pas du tout !')
    print('Je suis désolé mais je dois y aller...')
    print('Mais revenez discuter avec moi plus tard !')
    db['first_time'] = datetime.now()
else:
    db['nb_connections'] += 1
    if db['nb_connections'] < 3:
        print('Bonjour', db['name'],'vous allez bien ?')
    elif db['nb_connections'] == 3:
        print('Déjà trois fois que nous discutons ! Et si on se tutoyait dorénavant ?')
    elif db['nb_connections'] < 6:
        print('Salut', db['name'],'tu vas bien ?')
        print('Si tu viens me voir au moins 6 fois, je te livrerai un secret...')
        print('Je t\'ouvrirai mon cerveau !')
        print('Mais pour le moment tu n\'es venu que', db['nb_connections'], 'fois')
    else:
        print('Mais revoici mon ami', db['name'],'!')
        print('Sans vouloir te vexer, je trouve que pour quelqu\'un qui a déjà')
        print(db['age'],'ans, tu passes trop de temps à discuter avec une machine...') 
        print('Voici le secret promis. Ceci est ce que je sais de toi:')
        for k in db:
            print('   ->', k, ':', db[k])
    
    delta = date - db['first_time']
    if delta.total_seconds() < 30:
        print('Je n\'ai pas encore fini ce que je dois faire... désolé.')
        print('Cela fait a peine', int(delta.total_seconds()), 'secondes que nous avons fait connaissance...')
        db['waited'] = False
    elif not db['waited']:
        db['waited'] = True
        print('Merci d\'avoir patienté ! Voilà... je suis prêt à discuter.')
        

print('Bye.')
db.close()    
