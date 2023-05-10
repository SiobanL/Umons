import time

def slow_text_motion(s, sep, delay):
    words = s.split(sep)
    for w in words:
        print(w)
        time.sleep(delay)
    print('')

try:
    slow_text_motion('Hello.../This is.../a malicious script!', '/', 0.8)
    slow_text_motion('Try to find the exit.../before I erase all your data!!!', '/', 1.2)
    for i in range(10):
        print(10-i, end=' ')
        if i % 2 == 0:
            print('tic')
        else:
            print('tac')
        time.sleep(1)
except KeyboardInterrupt:
    print('Well done! You find the exit!')
else:
    print('You lose! I will erase all your data except if you try again right now...')
finally:
    print('Goodbye!')
