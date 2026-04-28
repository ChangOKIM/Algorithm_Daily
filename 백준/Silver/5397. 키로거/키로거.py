import sys
input = sys.stdin.readline
from collections import deque

L = int(input())

for _ in range(L):
  s = list(map(str, input().strip()))
  left = deque([])
  right = deque([])
  for i in range(len(s)):
    if s[i] == "<":
      if len(left) != 0:
        move = left.pop()
        right.appendleft(move)
    elif s[i] == ">":
      if len(right) != 0:
        move = right.popleft()
        left.append(move)
    elif s[i] == "-":
      if left:
        left.pop()
    else:
      left.append(s[i])
  print("".join(left) + "".join(right))

