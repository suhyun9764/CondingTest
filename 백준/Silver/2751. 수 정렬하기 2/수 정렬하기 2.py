n = int(input())
ls = []
for _ in range(n):
    ls.append(int(input().strip()))

ls.sort()
for i in range(len(ls)):
    print(ls[i])