import sys
input = sys.stdin.readline

M, N = map(int, input().split())
snacks = list(map(int, input().split()))

left, right = 1, max(snacks)
answer = 0

while left <= right:
    mid = (left + right) // 2
    pieces = sum(s // mid for s in snacks)
    if pieces >= M:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)