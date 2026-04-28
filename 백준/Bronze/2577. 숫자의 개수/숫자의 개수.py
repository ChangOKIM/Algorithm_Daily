a = int(input())
b = int(input())
c = int(input())

total = a*b*c
total_l = list(str(total))
cnt = []

for i in range(10):
    str_i = str(i)
    sum = 0
    for j in range(len(total_l)):
        if total_l[j] == str_i:
            sum += 1
    cnt.append(sum)

for k in cnt:
    print(k)
