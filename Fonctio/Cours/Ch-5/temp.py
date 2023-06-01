def recurse(n: int):
    return n*recurse(n-1) if n > 0 else 1

print(recurse(9))