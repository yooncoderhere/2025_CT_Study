import sys

input = sys.stdin.readline
N, K = map(int,input().split())
arr = list(int(input().split()))

count = [0]*(max(arr)+1)

left,right = 0,0
sub_arr = 0

while right<N:
    count[arr[right]] +=1
    
    while count[arr[right]] > K:
        count[arr[left]] -= 1
        left += 1
        
    sub_arr = max(sub_arr,right-left+1)
    right +=1
    
print(sub_arr)