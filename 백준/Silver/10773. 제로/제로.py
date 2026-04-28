#백준 - 10773번
#보장한다는게 remove가 아니고 pop을 쓰라는 의미인 듯 하나 별로인 문제같음

k = int(input())

money_list = []

sum = 0

for i in range(k):
  a = int(input())
  if a != 0:
    money_list.append(a)
  elif a == 0 and len(money_list)>0:
    money_list.pop()

for j in money_list:
  sum += j

print(sum)