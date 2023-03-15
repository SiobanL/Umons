import hangmantui
import userinput


def print_state(hidden, tried_letters, tries):
    hangmantui.clear()
    print(tries, " tries left")
    hangmantui.hangman(tries)
    print("\n    ", hidden, "\n")


def start():
    hangmantui.clear()
    word = userinput.ask_word_in_dictionary()
    hangmantui.clear()
    tries = 10
    tried_letters = ""
    hidden = "*" * len(word)
    # While the game is not finished.
    while tries > 0 and "*" in hidden:
        # Show the game state.
        print_state(hidden, tried_letters, tries)
        # Ask for player move.
        l = userinput.ask_letter(tried_letters)
        tried_letters += l
        # Process the move.
        if l in word:
            hidden = userinput.replace(word, hidden, l)
            print("Good guess !")
        else:
            print("Bad guess.")
            tries -= 1
    # Game finished.
    print_state(hidden, tried_letters, tries)
    print()
    # What's the end-game reason ?
    if not "*" in hidden:
        print("You win!")
    elif tries == 0:
        print("You are dead!")
        print("The word was", word)


if __name__ == "__main__":
    start()
