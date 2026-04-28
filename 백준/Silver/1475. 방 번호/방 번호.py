n = input()
num_list = [0] * 10

for digit in n:
    num_list[int(digit)] += 1

six_nine_total = num_list[6] + num_list[9]
num_list[6] = num_list[9] = (six_nine_total + 1) // 2

print(max(num_list))
