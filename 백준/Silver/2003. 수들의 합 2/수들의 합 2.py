N, M = map(int, input().split())
arr = list(map(int, input().split()))

count = 0
left, right = 0, 0
current_sum = arr[0]

while True:
    if current_sum == M:
        count += 1
    if current_sum >= M:
        current_sum -= arr[left]
        left += 1
    else:
        right += 1
        if right == N:
            break
        current_sum += arr[right]

print(count)