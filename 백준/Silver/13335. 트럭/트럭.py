import sys
from collections import deque
input = sys.stdin.readline

n, w, L = map(int, input().split())
truck = list(map(int, input().split()))
truck = deque(truck)

bridge = deque([0 for _ in range(w)])

times =0

while True:
    if sum(bridge) == 0 and len(truck) == 0:
        break
    elif sum(bridge) != 0 and len(truck) == 0:
        times += 1
        bridge.popleft()
        bridge.append(0)
    else:
        if L-sum(bridge) >= truck[0]:
            bridge.popleft()
            bridge.append(0)
            if L - sum(bridge) >= truck[0]:
                bridge[-1] = truck[0]
                truck.popleft()
                times +=1
            else:
                times +=1
        else:
            bridge.popleft()
            bridge.append(0)
            if L - sum(bridge) >= truck[0]:
                bridge[-1] = truck[0]
                truck.popleft()
                times += 1
            else:
                times += 1


print(times)