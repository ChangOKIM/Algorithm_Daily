import sys

input = sys.stdin.readline

N = int(input().strip())

L = list(map(int, input().split()))

ans = []

for i in range(N, 0, -1):

    ans.insert(L[i-1], i)

print(*ans)