import sys

input = sys.stdin.readline

n = int(input())

tree = {}

for n in range(n):
    root, left, right = input().strip().split()
    tree[root] = [left, right]

def preorder(root):
    if root != '.':
        print(root, end='')
        preorder(tree[root][0])  # left
        preorder(tree[root][1])  # right

def inorder(root):
    if root != '.':
        inorder(tree[root][0])  # left
        print(root, end='')
        inorder(tree[root][1])  # right

def postorder(root):
    if root != '.':
        postorder(tree[root][0])  # left
        postorder(tree[root][1])  # right
        print(root, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')