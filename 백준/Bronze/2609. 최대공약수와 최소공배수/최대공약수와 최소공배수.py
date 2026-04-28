import sys
import math

a, b = map(int, sys.stdin.readline().strip().split())

gcd_val = math.gcd(a, b)
lcm_val = math.lcm(a, b)

print(gcd_val)
print(lcm_val)
