t = int(input())

dp = [[0 for _ in range(4)] for _ in range(10001)]

dp[0][0] = 1
for j in range(1, 4):
  for i in range(10001):
    dp[i][j] = dp[i][j-1]
    if i - j >= 0:
      dp[i][j] += dp[i-j][j]
      
for _ in range(t):
  n = int(input())
  print(dp[n][-1])