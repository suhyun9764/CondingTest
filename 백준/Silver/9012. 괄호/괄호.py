import sys


class Solution:
    def getValid(self, s: str):
        open_stack = []
        for char in s:
            if char == '(':
                open_stack.append(char)
            else :
                if open_stack:
                    open_stack.pop()
                else:
                    return False

        if open_stack:
            return False
        else:
            return True


sol = Solution()
n = int(input())
for _ in range(n):
    s = sys.stdin.readline().strip()
    is_valid = sol.getValid(s)
    if (is_valid):
        print("YES")
    else:
        print("NO")
