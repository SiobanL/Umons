def display_vigenere_square(square: list[str])-> None:
    for row in square:
        print(row)


def generate_vigenere_square()-> list[list]:
    # Create temp string of albphabet because it's an array of char
    alphabet: str = "abcdefghijklmnopqrstuvwxyz".upper()
    
    # Create empty 2D list
    square_res: list[list] = [[0] * 26 for _ in range(0,26,1)]
    
    for i in range(0, 26, 1):
        for j in range(0, 26, 1):
            # print i and j and i + j mod 26 to get the offset in alphabet
            # print("i: %d + j: %d mod 26 = %d" % (i, j, (i+j)%26))
            
            # fill the result square with correct letter
            square_res[i][j] = alphabet[(i+j) % 26]
    return square_res


def generate_key(text: str, key: str)-> str:
    # Get the key in upper case
    temp: str = key.upper()
    
    for i in range(len(key),len(text), 1):
        temp += key[i % len(key)]
    return temp


def decrypt_vigenere(text: str, key: str) -> str:
    msg:str = ""
    
    for i in range(0, len(text), 1):
        #   ord(text[i].lower()) - 97   : convert ascii to alphabet format, so x ∈ [0,25]
        #   - ord(key[i].lower())- 97   : shit with the position of the key letter in the alphabet
        #   + 26                        : normalise the calculation so that you always get a positive number
        #   (...) % 26                  : always get a number in [0,25]
        col: int = ((ord(text[i].lower()) - 97) - (ord(key[i].lower())- 97) + 26) % 26
        
        # Reverse process of encrypt
        # Debug :
        # print("col: %02d" %(col))
        msg += vigenere_square[0][col].lower()
    return msg

def encrypt_vigenere(text: str, key: str) -> str:
    msg:str = ""
    
    for i in range(0, len(text), 1):
        # Row is define by key letter in alphabet to select row in vigenere_square
        row: int = ord(key[i].lower())-97
        # colum is define by text letter in alphabet to select column in vigenere_square
        col: int = ord(text[i].lower())-97
        # Debug :
        # print("row: %02d | col: %02d" %(row, col))
        msg += vigenere_square[row][col]
    return msg



def main():
    # Write vigenere square (Debug)
    # display_vigenere_square(vigenere_square)
    
    # Define const
    decrypt_word = "appelernordtroupesville"
    encrypt_word = "RDJKPVFHUVUHLUYGSMBMCZY"
    key = generate_key("appelernordtroupesville", "rouge")
    
    # Test function with const
    if decrypt_word == decrypt_vigenere(encrypt_word, key): print("Word is correctly decrypted: ", end="")
    print(decrypt_vigenere(encrypt_word, key))
    if encrypt_word == encrypt_vigenere(decrypt_word, key): print("Word is correctly encypted: ", end="")
    print(encrypt_vigenere(decrypt_word, key))    


if __name__ == "__main__":
    # Crearte const global vigenere square
    vigenere_square = generate_vigenere_square()
    main()
