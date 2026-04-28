#백준 - 1927번
#최소 힙
import heapq
import sys

n = int(sys.stdin.readline().strip())
heap_list = []
for i in range(n):
  x = int(sys.stdin.readline().strip())
  if x == 0:
    if len(heap_list) == 0:
      print(0)
    else:
      print(heapq.heappop(heap_list))
  else:
    heapq.heappush(heap_list, x)
      