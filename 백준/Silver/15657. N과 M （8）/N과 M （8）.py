N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
arr = []

def dfs(start):
    if len(arr) == M:
        print(*arr)
        return
    for i in range(start, N):
        arr.append(nums[i])
        dfs(i)
        arr.pop()

dfs(0)
