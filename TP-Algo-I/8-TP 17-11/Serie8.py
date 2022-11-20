from sys import setrecursionlimit
import random
from sort import *
from umons_cpu import *
from displayCpu import CpuPlot

def bubble_sort(t: list)-> None:
    for i in range(0,len(t)-1):
        for j in range(0,len(t)-i-1):
            if t[j] > t[j+1]:
                t[j], t[j+1] = t[j+1], t[j]


def illustration(items: list, *fs)-> None:
    points = [100,500,1000,1500,2000]
    grhaps = CpuPlot(points)
    for f in fs:
        temp = []
        for i in points:
            temp.append(umons_cpu.cpu_time(f, list(reversed(range(i)))))
        grhaps.prepare(temp,f.__name__)
    grhaps.draw()
    input()


setrecursionlimit(5000)
illustration(list(range(50)),merge_sort,selection_sort,insertion_sort,bubble_sort)
illustration(list(reversed(range(50))),merge_sort,selection_sort,insertion_sort,bubble_sort)
illustration(random.shuffle(list(range(50))),merge_sort,selection_sort,insertion_sort,bubble_sort)