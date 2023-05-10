import time

def fast_even_test(n):
    return n % 2 == 0
    
def slow_even_test(n):
    time.sleep(4)
    return fast_even_test(n)
    
n = int(input('Veuillez entrer un nombre entier: '))
ans = input('Merci! Voulez-vous utiliser un test de parite lent (l) ou rapide (r) ? ')

even_test = fast_even_test
if ans == 'l':
    even_test = slow_even_test

print('He bien sachez que votre nombre...', end=' ')
if n > 0 and even_test(n):
    print('est positif et pair !')
else:
    print('n\'est pas positif et pair !')

print('Allez, pour etre sur je reteste... mais dans l\'autre sens.')
print('He oui, je confirme que votre nombre...', end=' ')
if even_test(n) and n > 0:
    print('est pair et positif !')
else:
    print('n\'est pas pair et positif !')

