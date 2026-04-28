t = int(input())
    
for i in range(t):
    score = list(input())

    sum = 0
    combo = 0
        
    for i in range(len(score)):
        if score[i] == 'O':
            sum +=(1 + combo)
            combo += 1
        else:
            combo = 0
    print(sum)