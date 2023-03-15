import sort
from displayCpu import CpuPlot
import umons_cpu
import random
import sys

def bubble_sort(t):
    for i in range(len(t)):
        for j in range(len(t)-i-1):
            if t[j+1] <= t[j]:
                t[j],t[j+1] = t[j+1],t[j]
    
def draw_functions(*functions):
    input_list = [100, 200, 300, 500, 1000, 2000]
    afficheur = CpuPlot(input_list)
    times = []
    for f in functions:
        times = []
        for n in input_list:
            times.append(umons_cpu.cpu_time(f,[random.randint(0,100) for i in range(n)]))
        afficheur.prepare(times,f.__name__)
    afficheur.draw()
    input()

def lin_search(t,x):
    for i in range(len(t)):
        if t[i] == x:
            return i

def draw_search(list,x,*functions):
    afficheur = CpuPlot(list)
    times = []
    for f in functions:
        times = []
        for n in list:
            times.append(umons_cpu.cpu_time(f,list,x))
        afficheur.prepare(times,f.__name__)
    afficheur.draw()
    input()

sys.setrecursionlimit(90000)
l = sort.merge_sort(list(range(9000))) # ne fonctionne pas
print(l)
#draw_functions(sort.merge_sort,sort.insertion_sort,sort.selection_sort,bubble_sort)
#draw_functions(sort.merge_sort, sort.python_sort)  # impressionnant !

#list = range(200)
#draw_search(list,9999,lin_search,sort.dicho_search)