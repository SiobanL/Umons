# -*- encoding:utf-8 -*-
"""Terminal User Interface for the hangman."""


def clear():
    """Clear the terminal screen."""
    print(chr(27) + "[2J")


def hangman(lives):
    """
    Display a hangman state on terminal with maximum 10 lives.

    lives is the remaining number of lives between 0 and 10. When lives is 0,
    the hangman is completed/dead.
    """
    # Top
    print("  __________")
    print("  | /     |")
    # Head
    if lives <= 5:
        print("  |/      O")
    else:
        print("  |/")
    # Arms and torso
    if lives <= 2:
        print("  |      /|\\")
    elif lives <= 3:
        print("  |      /|")
    elif lives <= 4:
        print("  |       |")
    else:
        print("  |")
    # Torso
    if lives <= 4:
        print("  |       |")
    else:
        print("  |")
    # Legs
    if lives <= 0:
        print("  |      / \\")
    elif lives <= 1:
        print("  |      /")
    else:
        print("  |")
    # Bottom / Stool
    if lives <= 6:
        print("  |       _")
    else:
        print("  |)")
    if lives <= 7:
        print(" /|\\     /|\\")
    elif lives <= 8:
        print(" /|\\     / \\")
    elif lives <= 9:
        print(" /|\\     /")
    else:
        print(" /|\\")


if __name__ == "__main__":
    for i in range(10, -1, -1):
        clear()
        print("%i lives left:" % i)
        hangman(i)
        print("")
