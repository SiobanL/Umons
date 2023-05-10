file = open('words.txt')

total = 0
nums = [0] * 26

for line in file:
    for c in line.strip():
        total += 1
        letter = c.upper()
        index = ord(letter) - ord('A')
        nums[index] += 1

for i, n in enumerate(nums):
    print(chr(i + ord('A')), (nums[i] / total) * 100)
