from math import gcd

n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    result = gcd(a, b)
    print(result * (a // result) * (b // result))
