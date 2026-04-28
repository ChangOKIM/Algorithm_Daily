n = int(input())
cnt = n//4
s = []
for _ in range(cnt):
    s.append("long")

s.append("int")

print(*s)