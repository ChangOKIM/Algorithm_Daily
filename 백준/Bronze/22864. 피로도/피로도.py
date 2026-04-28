# 백준 - 22864번

a, b, c, m = map(int, input().split())

one_day = 24
boring = 0
score = 0

while (one_day>0):
  if (a>m):
    break
  else:
    if(m-boring)>=a:
      boring += a
      score += b
      one_day -=1
    else:
      if c<=boring:
        boring -= c
        one_day -=1
      else:
        boring = 0
        one_day -=1

print(score)
      