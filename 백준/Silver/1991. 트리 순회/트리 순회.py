from string import ascii_uppercase
s = list(ascii_uppercase)

n = int(input())

need_s = s[:n]

tree = dict()

for i in range(n):
  main, left, right = list(map(str, input().split()))
  tree[main] = (left, right)
  

def preorder(root):
  if root != '.':
    print(root, end='')
    preorder(tree[root][0])
    preorder(tree[root][1])

def inorder(root):
  if root != '.':
    inorder(tree[root][0])
    print(root, end= '')
    inorder(tree[root][1])

def postorder(root):
  if root != '.':
    postorder(tree[root][0])
    postorder(tree[root][1])
    print(root, end= '')

preorder('A')
print()
inorder('A')
print()
postorder('A')
    