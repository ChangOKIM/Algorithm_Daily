import sys

input = sys.stdin.readline

n = int(input())

requests = list(map(int, input().split()))

m = int(input())

start, end = 0, max(requests)

answer = 0

while start <= end:

    mid = (start + end) // 2

    total = sum(min(req, mid) for req in requests)

    if total <= m:

        answer = mid

        start = mid + 1

    else:

        end = mid - 1

print(answer)