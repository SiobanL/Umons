"""Used for all user input in a hangman."""


def belongs_to_dictionary(word :str)-> bool:
    """This function search if parameter is in file call words.txt

    Args:
        word (str): the word for search

    Returns:
        bool: return true if the word is in file
    """
    with open("words.txt", "r") as f:
        for line in f:                          # search for every line in words.txt
            if line.strip() == word.lower():    # check if every line = word.lower()
                return True

        return False


def ask_word_in_dictionary()-> str:
    """this function ask a word at user while this word is in dictionary

    Returns:
        str: return word who is in dictionary
    """
    word = input("Player 1, give me a word: ")

    while(not belongs_to_dictionary(word)):
        word = input("I don't kown this word, please enter another: ")
    return word


def ask_letter(tried_letters: list)-> str:
    """This function check if user input is the same as old input

    Args:
        tried_letters (str): contain old letter already tested

    Returns:
        str: return a good letter
    """
    tried_letter = input("Player 2, give me a letter: ").lower()

    while True:
        if not len(tried_letter) == 1 and tried_letter.isalpha():
            tried_letter = input("Player 2, give *one* *letter*: ")
        elif tried_letter in tried_letters:
            tried_letter = input("Player 2, give a *new* letter: ")
        else:
            return tried_letter