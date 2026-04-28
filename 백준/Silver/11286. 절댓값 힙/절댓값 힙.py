#백준 - 11286번
#절댓값 힙
import heapq
import sys

n = int(sys.stdin.readline().strip())
heap_list = []

for _ in range(n):
    x = int(sys.stdin.readline().strip())
    if x == 0:
        if heap_list:
            print(heapq.heappop(heap_list)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap_list, (abs(x), x))
