#백준 - 9012번

t = int(input())




for i in range(t):
  question = str(input())
  error_cnt = 0
  is_vps = []
  for j in range(len(question)):
    if question[j] == '(':
      is_vps.append(1)

    elif question[j] == ')':
      if len(is_vps) >0:
        is_vps.pop()
      else:
        error_cnt +=1
        break
  if len(is_vps) == 0 and error_cnt ==0:
    print('YES')
  else:
    print('NO')