import sys

class Solution:
    def getHasMatch(self, ls):
        ls.sort()
        for i in range(len(ls) - 1):
            if ls[i] == ls[i+1][:len(ls[i])]:
                print("NO")
                return
        print("YES")

t = int(input())
sol = Solution()
for _ in range(t):
    ls = []
    n = int(input())
    for _ in range(n):
        ls.append(sys.stdin.readline().strip())

    sol.getHasMatch(ls)
