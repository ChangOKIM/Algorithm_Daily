from collections import deque

n = int(input())

num = deque(enumerate(map(int, input().split())))
result = []

while num:
  idx, paper = num.popleft()
  result.append(idx + 1)

  if paper > 0:
    num.rotate(-(paper - 1))
  elif paper < 0:
    num.rotate(-paper)
    
print(" ".join(map(str, result)))