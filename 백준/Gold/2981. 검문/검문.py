import math
from itertools import combinations


#백준 2981번
#주어진 수들의 공통 나머지를 갖게하는 분모 M을 찾아라

n = int(input())
number_list = []
final_list = []

for i in range(n):
  number_list.append(int(input()))

number_list_sorted = sorted(number_list)

yejin_list = list(combinations(number_list_sorted, 2))

for i in range(len(yejin_list)):
  qukka = yejin_list[i][1] - yejin_list[i][0]
  final_list.append(qukka)

sol_gcd = final_list[0]

for i in range(len(final_list)):
    sol_gcd = math.gcd(sol_gcd, final_list[i])

answer_list = []

for i in range(int(sol_gcd)-1):
  if sol_gcd%(i+2) == 0:
    answer_list.append(i+2)

for j in range(len(answer_list)):
  print(answer_list[j], end=" ")