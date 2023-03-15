# Pseudo code du tri à bulles

# Tant qu'il y a eu au moins un échange faire
    # Pour chaque paire i et j d'éléments consécutifs dans la liste faire
        # si i > j alors
            # échanger i et j
        # fin si
    # fin pour
# fin tant que


# Complexité de la recherche dichotomique

def dicho_search(t, x):
    start = 0  # O(1)
    end = len(t) - 1  # O(1)
    mid = start + (end - start) // 2  # O(1)
    while (end - start > 0) and x != t[mid]:  # log2(n) * O(1)
        if x < t[mid]:  # O(1)
            end = mid - 1  # O(1)
        else:
            start = mid + 1  # O(1)
        mid = start + (end - start) // 2  # O(1)
    if len(t) > 0 and x == t[mid]:  # O(1)
        return mid  # O(1)
    else:
        return None  # O(1)

# O(log2(n))

# [|1, 2, 3, 4, 5, 6, 7, 8|] 8
# [|1, 2, 3, 4|, 5, 6, 7, 8] -> [1, 2, 3, 4] 4
# [|1, 2|, 3, 4, 5, 6, 7, 8] -> [1, 2] 2
# [|1|, 2, 3, 4, 5, 6, 7, 8] -> [1] 1

# k = nbre d'iterations
# n = nombre d'éléments
# ici, n = 8
# 8 / 2 k fois = 8/(2**k) = 1
# 8 = 2**k
# => k = 3
# si n = 2**k
# k = log2(n)

def bubble_sort(liste):
    sorted = False
    while not sorted:
        sorted = True
        for i in range(len(liste)-1):
            if liste[i] > liste[i+1]:
                liste[i], liste[i+1] = liste[i+1], liste[i]
                sorted = False

import random
import umons_cpu
import sort

def test(n):
    """
    Produit une ligne avec les temps cpu pour des listes de taille n.
    """
    t1 = list(range(n))
    t2 = list(range(n, 0, -1))
    t3 = []
    for i in range(n):
        t3.append(random.randint(0, n))
    print('%7d %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f %7.2f' % (
        n,
        umons_cpu.cpu_time(sort.selection_sort, t1),
        umons_cpu.cpu_time(sort.insertion_sort, t1),
        umons_cpu.cpu_time(sort.merge_sort, t1),
        umons_cpu.cpu_time(bubble_sort, t1),
        umons_cpu.cpu_time(sort.selection_sort, t2),
        umons_cpu.cpu_time(sort.insertion_sort, t2),
        umons_cpu.cpu_time(sort.merge_sort, t2),
        umons_cpu.cpu_time(bubble_sort, t2),
        umons_cpu.cpu_time(sort.selection_sort, t3),
        umons_cpu.cpu_time(sort.insertion_sort, t3),
        umons_cpu.cpu_time(sort.merge_sort, t3),
        umons_cpu.cpu_time(bubble_sort, t3)))


def show_array():
    """
    Affiche le tableau de sort.py avec le tri à bulles ajouté.
    """
    print('Temps affiches en msec')
    print('      n '
          't1: sel '
          '    ins '
          '    mer '
          '    bub '
          't2: sel '
          '    ins '
          '    mer '
          '    bub '
          't3: sel '
          '    ins '
          '    mer'
          '    bub')
    for i in range(100, 901, 100):
        test(i)

import displayCpu

def make_graphic():
    """
    Crée un graphique avec les temps cpu pour les tris.
    """
    data = []
    res = [[], [], [], []]
    for n in range(100, 901, 100):
        print(n)
        data.append(n)
        t = []
        for i in range(n):
            t.append(random.randint(0, n))
        res[0].append(umons_cpu.cpu_time(sort.selection_sort, t))
        res[1].append(umons_cpu.cpu_time(sort.insertion_sort, t))
        res[2].append(umons_cpu.cpu_time(sort.merge_sort, t))
        res[3].append(umons_cpu.cpu_time(bubble_sort, t))
    plot = displayCpu.CpuPlot(data)
    plot.prepare(res[0], "selection")
    plot.prepare(res[1], "insertion")
    plot.prepare(res[2], "fusion")
    plot.prepare(res[3], "bulles")
    plot.draw()
    input('')

    
# make_graphic()
# show_array()
