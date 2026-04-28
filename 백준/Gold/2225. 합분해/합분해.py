n, k = map(int, input().split())

divi = 1000000000

dp = [[0 for _ in range(k+1)] for _ in range(n+1)]

for i in range(k +1):
  dp[0][i] = 1

for i in range(1, n+1):
  for j in range(1, k + 1):
    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % divi

print(dp[n][k])