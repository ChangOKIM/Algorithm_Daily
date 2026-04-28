x = int(input())

cnt = 1

while x> cnt:
    x -= cnt
    cnt +=1


if cnt % 2 == 0:
    top = 1
    bottom = cnt

    for i in range(x-1):
        top +=1
        bottom -= 1

else:
    top = cnt
    bottom = 1

    for i in range(x-1):
        top -= 1
        bottom += 1

print(f"{top}/{bottom}")

