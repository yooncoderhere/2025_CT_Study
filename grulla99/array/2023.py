import sys, math

def is_prime(num):
    if num <= 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def generate_weird_primes(current, digits): # 현재숫자, 현재자리수
    if digits == n:
        result.append(current)
        return

    for i in range(1, 10):  # 다음 자리 숫자는 1부터 9까지 가능
        new_num = current * 10 + i
        if is_prime(new_num):
            generate_weird_primes(new_num, digits + 1)

n = int(input().strip())
result = []

# 한 자리 숫자인 소수 2, 3, 5, 7부터 시작
for num in [2, 3, 5, 7]:
    generate_weird_primes(num, 1)

for i in range(len(result)):
    print(result[i])