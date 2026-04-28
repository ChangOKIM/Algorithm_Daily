import sys

input = sys.stdin.readline

H, W = map(int, input().split())

h = list(map(int, input().split()))

left_max = [0] * W

right_max = [0] * W

m = 0

for i in range(W):

    m = max(m, h[i]); left_max[i] = m

m = 0

for i in range(W - 1, -1, -1):

    m = max(m, h[i]); right_max[i] = m

ans = 0

for i in range(W):

    w = min(left_max[i], right_max[i]) - h[i]

    if w > 0: ans += w

print(ans)