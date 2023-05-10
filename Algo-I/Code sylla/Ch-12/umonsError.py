class UmonsError(Exception):
    pass
    
def f(s):
    if s != 'umons':
        raise UmonsError('Wrong! Try something included in the name of this script.')
    print('You found the password. Congrats!')
    
pwdFound = False
while not pwdFound:
    try:
        s = input('Type password: ')
        f(s)
    except UmonsError as e:
        print(e)
    else:
        pwdFound = True
print('Bye')
        
        
