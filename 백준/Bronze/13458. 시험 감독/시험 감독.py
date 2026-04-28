import sys
from math import ceil


input = sys.stdin.readline

n = int(input())

class_students = list(map(int, input().split()))

b, c = map(int, input().split())

cnt = 0

for nums in class_students:
  if nums <= b: #총감독만 필요한 경우
    cnt +=1
  else: #부감독이 필요한 경우
    cnt +=1
    subs = ceil((nums-b) / c)
    cnt += subs

print(cnt)

