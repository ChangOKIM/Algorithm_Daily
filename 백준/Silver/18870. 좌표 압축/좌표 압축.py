n = int(input())
nums = list(map(int, input().split()))
unique = sorted(set(nums))
rank = {num: i for i, num in enumerate(unique)}
print(' '.join(map(str, [rank[x] for x in nums])))