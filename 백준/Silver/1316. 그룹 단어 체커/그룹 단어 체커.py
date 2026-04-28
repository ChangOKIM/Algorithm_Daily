n = int(input())
answer = 0

for _ in range(n):
    word = input()
    group = True
    for i in range(len(word) - 1):
        if word[i] != word[i+1]:
            if word[i] in word[i+1:]:
                group = False
                break
    if group:
        answer += 1

print(answer)