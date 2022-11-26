# -*- encoding:utf-8 -*-


def belongs_to_dictionary(word):
    with open("words.txt", "r") as file:
        for line in file:
            if line.strip() == word:
                return True
    return False


def ask_word_in_dictionary():
    word = input("Player1, give some word: ")
    while not belongs_to_dictionary(word):
        word = input("I don't know this word, please give another word: ")
    return word


def is_one_letter(s):
    return len(s) == 1 and s.isalpha()


def ask_letter(tried_letters):
    letter = input("Player2, give some letter: ").lower()
    cont = True
    while cont:
        if not is_one_letter(letter):
            letter = input("Player2, give *one* *letter*: ")
        elif letter in tried_letters:
            letter = input("Player2, give a *new* letter: ")
        else:
            cont = False
    return letter


def replace(word, hidden, l):
    ret = ""
    for i in range(len(word)):
        if word[i] == l:
            ret += l
        else:
            ret += hidden[i]
    return ret


def replace2(word, hidden, l):
    ret = ""
    last_idx = -1
    idx = word.find(l)
    while idx != -1:
        ret += hidden[last_idx + 1:idx]
        ret += l
        last_idx = idx
        # On cherche a partir de last_idx+1
        idx = word.find(l, last_idx+1)
    ret += hidden[last_idx + 1:]
    return ret
