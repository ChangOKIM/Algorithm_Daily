import sys

input = sys.stdin.readline

n, m = map(int, input().split())

n_list = list(map(int, input().split()))

prefix = [0] * (n + 1)

for i in range(1, n + 1):
    prefix[i] = n_list[i - 1] + prefix[i - 1]

for _ in range(m):
    start, end = map(int, input().split())

    print(prefix[end] - prefix[start-1])
