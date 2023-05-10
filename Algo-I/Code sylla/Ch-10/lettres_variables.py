file = open('words.txt')

total = 0
num_A = 0
num_B = 0
num_C = 0
num_D = 0
num_E = 0
num_F = 0
num_G = 0
num_H = 0
num_I = 0
num_J = 0
num_K = 0
num_L = 0
num_M = 0
num_N = 0
num_O = 0
num_P = 0
num_Q = 0
num_R = 0
num_S = 0
num_T = 0
num_U = 0
num_V = 0
num_W = 0
num_X = 0
num_Y = 0
num_Z = 0


for line in file:
    for c in line.strip():
        total += 1
        if c.upper() == 'A':
            num_A += 1
        elif c.upper() == 'B':
            num_B += 1
        elif c.upper() == 'C':
            num_C += 1
        elif c.upper() == 'D':
            num_D += 1
        elif c.upper() == 'E':
            num_E += 1
        elif c.upper() == 'F':
            num_F += 1
        elif c.upper() == 'G':
            num_G += 1
        elif c.upper() == 'H':
            num_H += 1
        elif c.upper() == 'I':
            num_I += 1
        elif c.upper() == 'J':
            num_J += 1
        elif c.upper() == 'K':
            num_K += 1
        elif c.upper() == 'L':
            num_L += 1
        elif c.upper() == 'M':
            num_M += 1
        elif c.upper() == 'N':
            num_N += 1
        elif c.upper() == 'O':
            num_O += 1
        elif c.upper() == 'P':
            num_P += 1
        elif c.upper() == 'Q':
            num_Q += 1
        elif c.upper() == 'R':
            num_R += 1
        elif c.upper() == 'S':
            num_S += 1
        elif c.upper() == 'T':
            num_T += 1
        elif c.upper() == 'U':
            num_U += 1
        elif c.upper() == 'V':
            num_V += 1
        elif c.upper() == 'W':
            num_W += 1
        elif c.upper() == 'X':
            num_X += 1
        elif c.upper() == 'Y':
            num_Y += 1
        elif c.upper() == 'Z':
            num_Z += 1

print('A:', (num_A / total) * 100)
print('B:', (num_B / total) * 100)
print('C:', (num_C / total) * 100)
print('D:', (num_D / total) * 100)
print('E:', (num_E / total) * 100)
print('F:', (num_F / total) * 100)
print('G:', (num_G / total) * 100)
print('H:', (num_H / total) * 100)
print('I:', (num_I / total) * 100)
print('J:', (num_J / total) * 100)
print('K:', (num_K / total) * 100)
print('L:', (num_L / total) * 100)
print('M:', (num_M / total) * 100)
print('N:', (num_N / total) * 100)
print('O:', (num_O / total) * 100)
print('P:', (num_P / total) * 100)
print('Q:', (num_Q / total) * 100)
print('R:', (num_R / total) * 100)
print('S:', (num_S / total) * 100)
print('T:', (num_T / total) * 100)
print('U:', (num_U / total) * 100)
print('V:', (num_V / total) * 100)
print('W:', (num_W / total) * 100)
print('X:', (num_X / total) * 100)
print('Y:', (num_Y / total) * 100)
print('Z:', (num_Z / total) * 100)
