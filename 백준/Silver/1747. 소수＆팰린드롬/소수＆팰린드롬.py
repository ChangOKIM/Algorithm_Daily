import sys

MAX = 1010000
sosu = [False, False] + [True] * (MAX-1)

for i in range(2, int(MAX**0.5) + 1):
  if sosu[i]:
    for j in range(i * i, MAX + 1, i):
      sosu[j] = False

n = int(sys.stdin.readline().strip())

for i in range(n, MAX+1):
  if sosu[i]:
    is_palindrome = list(str(i))
    if is_palindrome == is_palindrome[::-1]:
      print(''.join(is_palindrome))
      break