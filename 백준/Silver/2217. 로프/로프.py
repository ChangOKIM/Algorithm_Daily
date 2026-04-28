#로프
#중복되면 아예 고려를 안해버리는게 맞나..?

n = int(input())
k = []
for _ in range(n):
    k.append(int(input()))
k.sort()

answers = []
for x in k:
    answers.append(x*n)
    n -= 1
print(max(answers))