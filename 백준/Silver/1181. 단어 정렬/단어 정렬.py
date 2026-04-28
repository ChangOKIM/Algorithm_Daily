import sys

n = int(sys.stdin.readline())
words = set()

for _ in range(n):
    words.add(sys.stdin.readline().strip())

sorted_words = sorted(words, key=lambda x: (len(x), x))

for word in sorted_words:
    print(word)
