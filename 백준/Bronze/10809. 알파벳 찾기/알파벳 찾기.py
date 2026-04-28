import sys

s = sys.stdin.readline().strip()
alphabet_index = [-1] * 26

for i in range(len(s)):
    idx = ord(s[i]) - ord('a')
    if alphabet_index[idx] == -1:
        alphabet_index[idx] = i

print(' '.join(map(str, alphabet_index)))
