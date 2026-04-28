people, party = map(int, input().split())

true_check = list(map(int, input().split()))

true_num = true_check[0]
true_people = true_check[1:]

party_total = []

for _ in range(party):
  come_check = list(map(int, input().split()))

  come_num = come_check[0]
  come_people = come_check[1:]

  party_total.append(come_people)


for i in true_people:
  for j in party_total:
    if i in j:
      for k in j:
        if k not in true_people:
          true_people.append(k)


for i in party_total:
  check = len(i)
  cnt = 0
  for j in i:
    if j in true_people:
      cnt +=1
  if cnt == check:
    party -=1

print(party)