#1431번

import sys

n = int(sys.stdin.readline().strip())
gitars = [sys.stdin.readline().strip() for _ in range(n)]

def digit_sum(serial):
    return sum(int(ch) for ch in serial if ch.isdigit())

gitars.sort(key=lambda x: (len(x), digit_sum(x), x))

for gitar in gitars:
    print(gitar)
