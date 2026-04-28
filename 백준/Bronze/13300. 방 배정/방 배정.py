import sys
input = sys.stdin.readline

n, k = map(int, input().split())
group = {}

for _ in range(n):
    s, y = map(int, input().split())
    key = (s, y)
    group[key] = group.get(key, 0) + 1

room_count = 0
for cnt in group.values():
    room_count += (cnt + k - 1) // k

print(room_count)
