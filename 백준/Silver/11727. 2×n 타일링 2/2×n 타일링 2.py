import sys

n = int(sys.stdin.readline().strip())


dp = [0]*(n+1)
dp[1] = 1
if n>1:
  dp[2] = 3

sum = [0]*(n+1)
sum[1] = 1
if n>1:
  sum[2] = 4
if n>2:
  for i in range(2, n+1):
    if i % 2 == 0:
      dp[i] = (sum[i-1] + 2) %10007
      sum[i] = dp[i] + sum[i-1]
    else:
      dp[i] = (sum[i-1] + 1) %10007
      sum[i] = dp[i] + sum[i-1]

print(dp[n])