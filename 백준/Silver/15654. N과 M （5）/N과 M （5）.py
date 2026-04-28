N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
arr = []
used = [False] * N

def dfs():
    if len(arr) == M:
        print(*arr)
        return
    for i in range(N):
        if not used[i]:
            used[i] = True
            arr.append(nums[i])
            dfs()
            arr.pop()
            used[i] = False

dfs()
