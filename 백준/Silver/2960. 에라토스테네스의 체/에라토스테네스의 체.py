import sys
input = sys.stdin.readline

N, K = map(int, input().split())

N_list = [i for i in range(N)]

sosu= [False for i in range(N+1)]
cnt = 0

for i in range(2, len(sosu)):
    if not sosu[i]:
        for j in range(i, len(sosu), i):
            if not sosu[j]:
                sosu[j] = True
                cnt +=1
                if cnt == K:
                    print(j)
