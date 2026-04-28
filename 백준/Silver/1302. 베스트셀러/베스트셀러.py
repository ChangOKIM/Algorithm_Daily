import sys
input = sys.stdin.readline


dict1 = dict()
N = int(input())
for _ in range(N):
    s = input().strip()
    if s not in dict1:
        dict1[s] = 1
    else:
        dict1[s] += 1

dict_k = list(dict1.keys())
dict_val = list(dict1.values())

max_val = max(dict_val)
check = []
result = []
for i in range(len(dict_k)):
    if dict_val[i] == max_val:
        check.append(i)

for i in check:
    result.append(dict_k[i])

result.sort()

print(result[0])