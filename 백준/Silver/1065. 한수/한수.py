#백준 - 1065번

n = str(input())
list_n = list(n)
int_n = int(n)


step = 0
answer = 0

if int_n <100:
  step = int_n
else:
  step = 99
  for i in range(100, int(n)+1):
    cnt = 0
    str_i = str(i)
    list_i = list(str_i)
    point = abs(int(list_i[0])-int(list_i[1]))
    for j in range(len(list_i)-2):
      
      if (abs(int(list_i[j+1]) - int(list_i[j+2])) ==point and (int(list_i[j])<=int(list_i[j+1])<=int(list_i[j+2]))) or (abs(int(list_i[j+1]) - int(list_i[j+2])) ==point and (int(list_i[j])>=int(list_i[j+1])>=int(list_i[j+2]))):
        cnt +=1
    if cnt == (len(list_i)-2):
      step +=1
      
print(step)

        
      

