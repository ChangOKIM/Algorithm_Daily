t = int(input())

sosu = [False, False] + [True] * 10000

for i in range(2, 10002):
  if sosu[i]:
    for j in range(i*i, 10002, i):
      sosu[j] = False

for _ in range(t):
  n = int(input())
  n_list = []
  for i in range((n+2) // 2):
    if sosu[i]:
      if sosu[(n-i)]:
        n_list.append([i, n-i])
  print(*n_list[-1])