import sys, bisect
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

lis = []
for x in arr:
    pos = bisect.bisect_left(lis, x)  # 여기만 다름
    if pos == len(lis):
        lis.append(x)
    else:
        lis[pos] = x

print(len(lis))