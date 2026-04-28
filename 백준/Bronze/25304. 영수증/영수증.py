x = int(input())
n = int(input())
n_list = []

for _ in range(n):
    price, cnt = map(int, input().split())
    n_list.append(price * cnt)
    
if sum(n_list) == x:
    print("Yes")
else:
    print("No")