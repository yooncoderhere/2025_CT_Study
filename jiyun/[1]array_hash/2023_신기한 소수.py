def is_prime(n):
    
    #2보다 작은 수는 소수가 아님
    if n<2:
        return False
    
    # 2 ~ 5
    for i in range(2,int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def find_special_prime(number,length,N):
    if length == N:
        print(number)
        return
    
    for digit in [1,3,7,9]: # 홀수만 가능 (짝수는 홀수가 될 수 없음)
        new_number = number * 10 +digit
        if is_prime(new_number): # 소수면 다음 자리 추가
            find_special_prime(new_number,length +1,N)

def special_prime(N):
    for first_digit in [2,3,5,7]: # 첫번째 자리는 소수여야 함
        find_special_prime(first_digit,1,N)

N = int(input())
special_prime(N)
        
        