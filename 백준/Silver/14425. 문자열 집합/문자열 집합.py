import sys

n, m = map(int, sys.stdin.readline().strip().split())

s = {}
cnt = 0

for _ in range(n):
    s[sys.stdin.readline().strip()] = True

for _ in range(m):
    if sys.stdin.readline().strip() in s:
        cnt += 1

print(cnt)
