file = open('words.txt')

total = 0
nums = {}

for line in file:
    for c in line.strip():
        total += 1
        letter = c.upper()
        if letter in nums:
            nums[letter] += 1
        else:
            nums[letter] = 1

for letter in sorted(nums):
    print(letter, (nums[letter] / total) * 100)