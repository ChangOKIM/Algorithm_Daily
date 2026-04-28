n = int(input())
    
score = list(map(int, input().split()))
    
combo = 0
sum = 0
for i in range(len(score)):
    if score[i] == 1:
        sum += (score[i] + combo)
        combo +=1
    elif score[i] == 0:
        combo = 0
        
print(sum)
        