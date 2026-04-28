import sys
input = sys.stdin.readline

cycle = 0

while True:
    L, P, V = map(int, input().split())
    if L == 0 and P == 0 and V == 0:
        break
    else:
        cycle += 1
        times  = 0
        
        while V > P:
            times += 1
            V -= P
        
        if V <= L:
            answer = times*L + V
            print(f"Case {cycle}: {answer}")
        else:
            answer = times*L + L
            print(f"Case {cycle}: {answer}")
        
