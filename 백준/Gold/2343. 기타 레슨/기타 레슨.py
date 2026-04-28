import sys
input = sys.stdin.readline

def can_record(limit):
    count, total = 1, 0
    for lec in lectures:
        if total + lec > limit:
            count += 1
            total = 0
        total += lec
    return count <= M

N, M = map(int, input().split())
lectures = list(map(int, input().split()))

left, right = max(lectures), sum(lectures)
res = right

while left <= right:
    mid = (left + right) // 2
    if can_record(mid):
        res = mid
        right = mid - 1
    else:
        left = mid + 1

print(res)