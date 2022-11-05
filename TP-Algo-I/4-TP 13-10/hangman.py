"""
     ██╗  ██╗ █████╗ ███╗   ██╗ ██████╗ ███╗   ███╗ █████╗ ███╗   ██╗     ██████╗  █████╗ ███╗   ███╗███████╗
     ██║  ██║██╔══██╗████╗  ██║██╔════╝ ████╗ ████║██╔══██╗████╗  ██║    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝
     ███████║███████║██╔██╗ ██║██║  ███╗██╔████╔██║███████║██╔██╗ ██║    ██║  ███╗███████║██╔████╔██║█████╗  
     ██╔══██║██╔══██║██║╚██╗██║██║   ██║██║╚██╔╝██║██╔══██║██║╚██╗██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  
     ██║  ██║██║  ██║██║ ╚████║╚██████╔╝██║ ╚═╝ ██║██║  ██║██║ ╚████║    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗
     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝
                                                                              This module is an hangman game.
     realized by Limosani sioban
     last update: 15/10/2022
"""


from os import system as sys        # sys for os.system('cls') as sys('cls') for clear screen
from time import sleep as slp       # slp for sleep a few seconds
import hangmantui as hui            # hangman ui
import userInput as uio             # user input output


def logo()-> None:
    """
        This function draw and left or play the game    
    """
    sys("cls")
    print("-----------------------------------------------------------------------------\n"
          " _                                                                           \n"
          "| |                                                                          \n"
          "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __     __ _  __ _ _ __ ___   ___  \n"
          "| '_ \ / _` | '_ \ / _` | '_ ` _ \ / _` | '_ \   / _` |/ _` | '_ ` _ \ / _ \ \n"
          "| | | | (_| | | | | (_| | | | | | | (_| | | | | | (_| | (_| | | | | | |  __/ \n"
          "|_| |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|  \__, |\__,_|_| |_| |_|\___| \n"
          "                    __/ |                         __/ |                      \n"
          "                   |___/                         |___/                       \n"
          "-----------------------------------------------------------------------------\n"
          "\n"
          "                             ____________________  \n"
          "                            |                    | \n"
          "                            |     P - Play       | \n"
          "                            |                    | \n"
          "                            |--------------------| \n"
          "                            |                    | \n"
          "                            |     L - Leave      | \n"
          "                            |____________________| \n"
         )
    
    while True:                                                 # loop until the right choices are chosen
        match input("your choice: ").lower():
            case "l":                                           # case of player left the game
                print("GoodBye")
                slp(2.)
                sys("cls")
                exit()                                          # quit game and script
            case "p":                                           # case of player play the game
                break
            case _:                                             # defalut case
                print("wrong choice. Try only an option...")


def listToStr(list: list)-> str:
    """This function change a list in a str whith comma enter each letter execpt the last

    Args:
        list (list): list of str only

    Returns:
        str: return the list formated as a str
    """
    listStr = ""
    for item in list:
        listStr += item + ("" if item == list[len(list)-1] else ",")
    return listStr


def hideToVisible(word: str,triedLetters: list)-> str:
    """This function hide each letter not found

    Args:
        word (str): a word for compare each letter
        triedLetters (list): list of letter to compare

    Returns:
        str: return the word whit hide and show letter
    """
    hidenWord = ""
    for i in range(0,len(word)):
        if word[i] in triedLetters:
            hidenWord += word[i]
        else:
            hidenWord += "*"
    return hidenWord


while True:
    logo()
    slp(2.)
    sys("cls")                                                  # clear logo after 2sec of waiting

    word = uio.ask_word_in_dictionary()                         # ask for a word to make it guess
    lives = 10                                                  # set life at 10
    tried_letters = []                                          # set tried letters
    hideLetters= len(word) * "*"                                # set number of star for hide the word
    sys("cls")                                                  # clear screen for player two else he see the word

    while True:
        print("Your lifes count is: %i" %lives)                 #
        print("tried letters: %s" %listToStr(tried_letters))    #
        hideLetters = hideToVisible(word,tried_letters)         # print ui whit all game informations
        print("%s" %hideLetters)                                #
        hui.hangman(lives)                                      #

        if (hideLetters == word):                               # check if player has won or if he find a letter
            print("You won, congratulation ! your score is: %i" %lives)
            slp(4.)
            break
        elif (lives == 0):
            print("You lose. the word is: %s" %word)
            slp(4.)
            break
        else:
            tried_letters.append(uio.ask_letter(tried_letters)) # ask letter at player two and register this letter

        if not(tried_letters[len(tried_letters)-1] in word):
            lives -= 1

        sys("cls")                                              # clear screen for rewrite with all information in same place