import sys
from itertools import combinations
input = sys.stdin.readline

#회원, 치킨종류
N, M = map(int, input().split())

faovorite = [list(map(int, input().split())) for _ in range(N)]

avail_3 = list(combinations([i for i in range(M)],3))

result = 0

for i in range(len(avail_3)):
    a, b, c = avail_3[i]
    total = 0
    for j in range(N):
        good = max(faovorite[j][a], faovorite[j][b], faovorite[j][c])
        total += good
    if total > result:
        result = total

print(result)