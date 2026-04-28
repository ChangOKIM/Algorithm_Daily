import sys
input = sys.stdin.readline

for i in range(3):
    fr = list(map(int, input().split()))
    dud = 0
    dlf = 0

    for j in fr:
        if j == 0:
            dud +=1
        else:
            dlf +=1
    if dlf == 3 and dud == 1:
        print("A")
    elif dud == 2 and dlf == 2:
        print("B")
    elif dlf == 1 and dud == 3:
        print("C")
    elif dud == 4:
        print("D")
    else:
        print("E")