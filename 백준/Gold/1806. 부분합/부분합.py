import sys

input = sys.stdin.readline
N, S = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
cur = 0
ans = N + 1

for right in range(N):
    cur += arr[right]

    while cur >= S:
        ans = min(ans, right - left + 1)
        cur -= arr[left]
        left += 1

print(0 if ans == N + 1 else ans)