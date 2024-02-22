import sys


class Solution:
    def sort_age(self, ls: list[list]):
        ls.sort(key=lambda x: (int(x[0]), x[2]))
        for person in ls :
            print(*person[:2])


n = int(input())

ls = []
for i in range(n):
    split = sys.stdin.readline().strip().split(" ")
    split.append(i)
    ls.append(split)

sol = Solution()
sol.sort_age(ls)
