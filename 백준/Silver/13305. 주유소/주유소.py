n = int(input())
load = list(map(int, input().split()))
price = list(map(int, input().split()))

checkpoint = 0
total = 0

while checkpoint < n - 1:
    start = checkpoint
    oil_price = price[start]

    while checkpoint < n - 1 and price[checkpoint + 1] >= oil_price:
        checkpoint += 1

    distance = sum(load[start:checkpoint + 1])
    total += distance * oil_price

    checkpoint += 1

print(total)
