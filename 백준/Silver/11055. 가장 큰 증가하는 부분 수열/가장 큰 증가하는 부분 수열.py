n = int(input())

n_list = list(map(int, input().split()))

dp = [0] * n

for i in range(n):
  dp[i] = n_list[i]
  for j in range(i):
    if n_list[j] < n_list[i]:
      dp[i] = max(dp[i], dp[j] + n_list[i])

print(max(dp))