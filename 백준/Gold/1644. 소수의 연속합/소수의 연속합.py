import sys
input = sys.stdin.readline

N = int(input())

is_prime = [True] * (N + 1)
is_prime[0:2] = [False, False]
p = 2
while p * p <= N:
    if is_prime[p]:
        for q in range(p * p, N + 1, p):
            is_prime[q] = False
    p += 1

primes = [i for i in range(2, N + 1) if is_prime[i]]

count = 0
left = 0
right = 0
current = primes[0] if primes else 0

while True:
    if current == N:
        count += 1
    if current >= N:
        current -= primes[left]
        left += 1
        if left > right and left < len(primes):
            right = left
            current = primes[left]
    else:
        right += 1
        if right >= len(primes):
            break
        current += primes[right]

print(count)