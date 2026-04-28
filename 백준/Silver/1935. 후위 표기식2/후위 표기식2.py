import sys

def input():

    return sys.stdin.readline().rstrip()

def postfix_evaluation(expression, values):

    operators = {

        '+': lambda b, a: a + b,

        '-': lambda b, a: a - b,

        '*': lambda b, a: a * b,

        '/': lambda b, a: a / b

    }

    

    stack = []

    value_mapping = {}

    

    # 문자와 값을 매핑

    value_iter = iter(values)

    for char in expression:

        if char.isalpha() and char not in value_mapping:

            value_mapping[char] = next(value_iter)

    

    # 후위 표기법 수식 계산

    for char in expression:

        if char in operators:  # 연산자일 경우

            b = stack.pop()

            a = stack.pop()

            stack.append(operators[char](b, a))

        else:  # 피연산자일 경우

            stack.append(value_mapping[char])

    

    # 결과 출력

    return stack[0]

# 입력 처리

N = int(input())

expression = input()

values = [int(input()) for _ in range(N)]

# 결과 계산 및 출력

result = postfix_evaluation(expression, values)

print(f"{result:.2f}")