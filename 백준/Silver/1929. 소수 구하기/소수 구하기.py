#백준 - 1929번
# 소수 구하기

import math

m, n = map(int, input().split())

prime = [True] * (n+1)
prime[0] = False
prime[1] = False

for i in range(2, int(math.sqrt(n)+1)):
  if prime[i]:
    for j in range(i*i, n+1, i):
      prime[j] = False

for i in range(m, n+1):
  if prime[i]:
    print(i)