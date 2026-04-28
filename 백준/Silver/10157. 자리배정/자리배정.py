c, r = map(int, input().split())
k = int(input())

seat = [[0 for _ in range(c)] for _ in range(r)]

avail = [i for i in range(1, (c*r +1))]

cnt = [0, 0, 0, 0]

check = 1
num = 1
#r은세로 c는가로
while(num != c*r+1):
  if check % 4 == 1:
    for j in range(r - cnt[1]-1, cnt[3]-1, -1):
      seat[j][cnt[0]] = num
      num +=1
    check += 1
    cnt[0] += 1

  elif check % 4 == 2:
    for j in range(cnt[0], c - cnt[2]):
      seat[cnt[1]][j] = num
      num +=1
    check += 1
    cnt[1] += 1

  elif check % 4 == 3:
    for j in range(cnt[1], r - cnt[3]):
      seat[j][c - 1 - cnt[2]] = num
      num += 1
    check += 1
    cnt[2] += 1

  elif check % 4 == 0:
    for j in range(c - 1 - cnt[2], cnt[0]-1, -1):
      seat[r - cnt[3] - 1][j] = num
      num +=1
    check += 1
    cnt[3] += 1


result = []

if k > c*r:
  print(0)
else:  
  for i in range(r):
    for j in range(c):
      if seat[i][j] == k:
        result.append(j+1)
        result.append(r - i)
        break
  print(" ".join(map(str, result)))
