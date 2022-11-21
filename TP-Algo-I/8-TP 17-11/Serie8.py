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
            sumList = []
            for j in range(0,2):
                sumList.append(umons_cpu.cpu_time(f, items[j]))
            temp.append(sum(sumList))
        grhaps.prepare(temp,f.__name__)
    grhaps.draw()
    input()


def linear_search(lst: list, search_word: str)-> bool:
    for w in lst:
        if w == search_word:
            return True
    return False


def dichotomic_search(t, w):
    start = 0
    end = len(t) - 1
    mid = (end - start) // 2
    while (end - start > 1) and w != t[mid]:
        if w < t[mid]:
            end = mid - 1
        else:
            start = mid + 1
            mid = start + (end - start) // 2
    return len(t) > 0 and w == t[mid]



setrecursionlimit(5000)
illustration([list(range(50)),list(reversed(range(50))),random.shuffle(list(range(50)))],merge_sort,selection_sort,insertion_sort,bubble_sort)