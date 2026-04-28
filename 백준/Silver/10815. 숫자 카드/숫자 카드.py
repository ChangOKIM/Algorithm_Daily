n = int(input())

n_list = set(map(int, input().split()))
m = int(input())

m_list = list(map(int, input().split()))
result = []

for i in m_list:
    if i in n_list:
        result.append(1)
    else:
        result.append(0)

print(*result)
