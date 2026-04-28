x, y, w, s = map(int, input().split())

start_x = 0
start_y = 0

if s > w*2:
  print((x+y)*w)

elif s > w:
  min_p = min(x, y)
  max_p = max(x, y)
  print(min_p * s + (max_p - min_p) * w)

else:
  if (x+y) % 2 == 0:
    print(max(x, y) * s)
  else:
    print((max(x, y) -1) * s + w)