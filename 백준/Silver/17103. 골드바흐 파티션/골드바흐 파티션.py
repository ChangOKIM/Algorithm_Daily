#백준 - 17103번
#골드바흐 파티션이 몇 개 가능한지

import math

MAX_N = 1000000
prime = [True] * (MAX_N+1)

prime[0] = False
prime[1] = False


for i in range(2, int(math.sqrt(MAX_N)) + 1):
  if prime[i]:  
      for j in range(i * i, MAX_N + 1, i):
          prime[j] = False

t = int(input())


for i in range(t):
  n = int(input())
  cnt = 0
  for i in range(2, n+1):
    if prime[i]:
      if prime[n-i] is True:
        cnt +=1
  if cnt %2 == 1:
    print(cnt//2 +1)
  else:
    print(cnt//2)
