w, h = map(int, input().split())
n = int(input())

def convert(d, l):
    pos = [l, 2*w + h - l, 2*(w + h) - l, w + l]
    return pos[d-1]

stores = [tuple(map(int, input().split())) for _ in range(n)]
gx, gy = map(int, input().split())
guard = convert(gx, gy)
circumference = 2 * (w + h)

result = 0
for d, l in stores:
    store = convert(d, l)
    direct = abs(store - guard)
    result += min(direct, circumference - direct)

print(result)