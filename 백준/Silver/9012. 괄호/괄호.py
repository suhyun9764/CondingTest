class solution:
    def isValid(self, s: str) -> str:
        stack = []
        for char in s:
            if char == ('('):
                stack.append(char)
            elif char == (')'):
                if not stack:
                    return "NO"
                stack.pop()

        if not stack:
            return "YES"
        else :
            return "NO"


t = int(input())

for _ in range(t):
    s = input()
    sol = solution()
    print(sol.isValid(s))
