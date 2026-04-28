s1 = input().strip()
s2 = input().strip()

prev = [0] * (len(s2) + 1)

for i in range(1, len(s1) + 1):
    curr = [0] * (len(s2) + 1)
    for j in range(1, len(s2) + 1):
        if s1[i - 1] == s2[j - 1]:
            curr[j] = prev[j - 1] + 1
        else:
            curr[j] = max(prev[j], curr[j - 1])
    prev = curr

print(prev[len(s2)])