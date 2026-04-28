import sys

n, k = map(int, sys.stdin.readline().strip().split())

score = list(map(int, sys.stdin.readline().strip().split()))

score.sort(reverse = True)

print(score[k-1])