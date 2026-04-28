import sys
input = sys.stdin.readline

N, K = map(int, input().split())
belt = list(map(int, input().split()))
robot = [False] * N

step = 0

while True:
    step += 1

    belt = [belt[-1]] + belt[:-1]
    robot = [False] + robot[:-1]
    robot[-1] = False

    for i in range(N-2, -1, -1):
        if robot[i] and not robot[i+1] and belt[i+1] > 0:
            robot[i], robot[i+1] = False, True
            belt[i+1] -= 1
    robot[-1] = False

    if belt[0] > 0 and not robot[0]:
        robot[0] = True
        belt[0] -= 1

    if belt.count(0) >= K:
        print(step)
        break
