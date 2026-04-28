cash = int(input())

a_cash = cash
b_cash = cash

a_stock_count = 0
b_stock_count = 0

stock_price = list(map(int, input().split()))

for i in stock_price:
    if a_cash >= i:
        a_stock_count += a_cash//i
        a_cash = a_cash%i

for j in range(14):
    if j > 2:
        if stock_price[j] > stock_price[j-1] and stock_price[j-1] > stock_price[j-2] and stock_price[j-2] > stock_price[j-3]:
            if b_stock_count>0:
                b_cash = b_stock_count*stock_price[j]
                b_stock_count = 0
        elif stock_price[j] < stock_price[j-1] and stock_price[j-1] < stock_price[j-2] and stock_price[j-2] < stock_price[j-3]:   
            if b_cash >=stock_price[j]:
                b_stock_count += b_cash//stock_price[j]
                b_cash = b_cash%stock_price[j]

a_total = stock_price[-1]*a_stock_count+a_cash
b_total = stock_price[-1]*b_stock_count+b_cash

if a_total > b_total:
    print('BNP')
elif a_total == b_total:
    print('SAMESAME')
else:
    print('TIMING')