#N(동생 수), S(현재위치)
import math
from functools import reduce

n, s = map(int, input().split())

sister_loc = list(map(int, input().split()))

dif_loc = [abs(i - s) for i in sister_loc]

result = reduce(math.gcd, dif_loc)

print(result)
