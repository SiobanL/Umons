"""
Module utilisé à l'UMONS dans le cadre des cours de Programmation et
Algorithmique 1 et Structure de Données 1 pour faciliter le calcul
des temps CPU.

Auteur: Pierre Hauweele et Hadrien Mélot (Université de Mons), 2016
"""

import timeit
import pickle
import math


def __init_timer__(f, *args):
    fs = pickle.dumps(f)
    argss = pickle.dumps(args)
    setup = \
"""
import pickle
import copy
f = pickle.loads(%s)
args = pickle.loads(%s)
""" % (fs, argss)
    stmt = 'f(*copy.deepcopy(args))'
    return timeit.Timer(stmt, setup)


def __calibrate__(t):
    calibrate_test = 0
    n = 1

    while calibrate_test < 0.02:
        n *= 10
        calibrate_test = t.timeit(n)

    return n, calibrate_test


def cpu_time_cpy(f, *args):
    """ Retourne un temps CPU exprimé en millisecondes (ms)
            - f : fonction ou méthode à tester
            - *args : liste d'arguments pour f. Ces arguments ne sont pas
              modifiés, même si la fonction f a des effets de bord (ils sont
              copiés avant l'exécution).

            Exemples :
                cputime(math.sqrt, 4)
                   pour calculer le temps CPU de math.sqrt(4)
                cputime(str.upper, 'hello')
                   pour calculer le temps CPU de 'hello'.upper()
                cputime(myfunc, x, y, z)
                   pour calculer le temps CPU de myfunc(x, y, z)
    """
    t = __init_timer__(f, *args)

    n, cal_time = __calibrate__(t)

    res = min([cal_time] + t.repeat(2, n))

    return (res / n) * 1000


def cpu_time(f, *args, tot_time=0.02):

    fs = pickle.dumps(f)
    argss = pickle.dumps(args)
    setup_header = \
"""
import pickle
import copy
f = pickle.loads(%s)
args = pickle.loads(%s)
cpyied_args = []
idx = 0
""" % (fs, argss)
    stmt = 'f(*cpyied_args[idx]); idx += 1'
    n = 10
    time = 0
    while time < tot_time:
        setup_cpy = \
"""
for i in range(%s):
    cpyied_args.append(copy.deepcopy(args))
""" % (n,)
        setup = setup_header + setup_cpy
        time = timeit.timeit(stmt, setup, number=n)
        if time > 0.:
            n *= max(4, int(math.ceil(1.1 * tot_time / time)))
    return (time / n) * 1000


def calibrate(f, *args):
    """ Retourne un nombre de tests qui rend le calcul du temps CPU
        a priori raisonnable.
            - f : fonction ou méthode à tester
            - *args : liste d'arguments pour f. Ces arguments ne sont pas
              modifiés, même si la fonction f a des effets de bord (ils sont
              copiés avant l'exécution).

        Le nombre de tests retourné est une puissance de 10 (au minimum 10). Il
        sera d'autant plus grand si la fonction semble rapide.
    """
    t = __init_timer__(f, *args)

    n, cal_time = __calibrate__(t)

    return n


def cpu_time_without_copy(f, *args):
    """ Retourne un temps CPU exprimé en millisecondes (ms)
            - f : fonction ou méthode à tester
            - *args : liste d'arguments pour f.
            Cette version ne copie pas les arguments:
            il ne faut donc l'utiliser qu'avec des fonctions
            sans effet de bord !
    """
    fs = pickle.dumps(f)
    argss = pickle.dumps(args)
    setup = \
"""
import pickle
f = pickle.loads(%s)
args = pickle.loads(%s)
""" % (fs, argss)
    stmt = 'f(*args)'
    t = timeit.Timer(stmt, setup)

    calibrate_test = 0
    n = 1

    n, cal_time = __calibrate__(t)
    while calibrate_test < 0.02:
        n *= 10
        calibrate_test = t.timeit(n)

    res = min([calibrate_test] + t.repeat(2, n))

    return (res / n) * 1000

