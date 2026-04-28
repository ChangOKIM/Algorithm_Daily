#백준 - 2824번
# 큰수 두 가지 최대공약수

import math

n = int(input())

n_list = list(map(int, input().split()))

m = int(input())

m_list = list(map(int, input().split()))

n_sum, m_sum = 1, 1

for i in n_list:
  n_sum *= i

for j in m_list:
  m_sum *= j

answer = f"{math.gcd(n_sum, m_sum)}"

if len(answer) >= 10:
  print(answer[-9::])
else:
  print(answer)