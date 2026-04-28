#백준 - 2747번
# 피보나치 구하기

n = int(input())

fibonacci = [0, 1]

for i in range(n-1):
  fibonacci.append(0)


for i in range(n-1):
  fibonacci[i+2] = fibonacci[i+1] + fibonacci[i]
  

print(fibonacci[n])