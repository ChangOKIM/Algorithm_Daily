#소 1 2 3 4 5 6 7 8 9 10
#왼쪽: 0 오른쪽: 1

cow = [[] for _ in range(11)]
cow_cnt = [0 for _ in range(11)]

record = int(input())

for _ in range(record):
  cow_num, move = map(int, input().split())
  if cow[cow_num]:
    if move == 1 and cow[cow_num][-1] == 0 or move == 0 and cow[cow_num][-1] == 1:
      cow_cnt[cow_num] +=1
      cow[cow_num].append(move)
    else:
      cow[cow_num].append(move)
  else:
    cow[cow_num].append(move)

print(sum(cow_cnt))
      
  