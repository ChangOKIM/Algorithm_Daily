import sys

def star15(init):
    if init > n:
        return

    empty = n - init
    stars = 2 * init - 1

    print(' ' * empty, end='')

    for i in range(stars):
        if i % 2 == 0:
            print('*', end='')
        else:
            print(' ', end='')

    print('')
    star15(init + 1)

n = int(sys.stdin.readline().strip())
star15(1)
