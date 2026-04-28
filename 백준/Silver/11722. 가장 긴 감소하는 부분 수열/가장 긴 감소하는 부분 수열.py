import sys

n = int(sys.stdin.readline().strip())

dp = [1]*n

listup = list(map(int, sys.stdin.readline().strip().split()))

for i in range(n):
  for j in range(i):
    if listup[j] > listup[i]:
      dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
