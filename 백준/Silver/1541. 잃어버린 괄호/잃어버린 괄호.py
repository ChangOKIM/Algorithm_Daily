n_s = list(input().split('-'))

answer = 0

for i in range(len(n_s)):
  
  if i>0:
    if '+' in n_s[i]:
      detail_s = list(n_s[i].split('+'))
      total = 0
      
      for j in detail_s:
        total += int(j)
      answer -= total
      
    else:
      answer -= int(n_s[i])
      
  else:
    
    if '+' in n_s[i]:
      detail_s = list(n_s[i].split('+'))
      total = 0
      
      for j in detail_s:
        total += int(j)
      answer += total
      
    else:
      answer += int(n_s[i])

print(answer)