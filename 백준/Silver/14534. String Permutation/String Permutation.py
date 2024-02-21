from collections import deque

class Solution:
    def __init__(self, test_case):
        self.test_case = test_case

    def getResult(self):
        case_collection = []
        for case in self.test_case:
            case_collection.append(self.getAllCase(case))
        return case_collection

    def getAllCase(self, case):
        result = []

        def dfs(path, visited):
            if len(path) == len(case):
                result.append(''.join(path))
                return

            for i in range(len(case)):
                if not visited[i]:
                    visited[i] = True
                    path.append(case[i])
                    dfs(path, visited)
                    path.pop()
                    visited[i] = False

        visited = [False] * len(case)
        dfs([], visited)

        return result


t = int(input())
test_case = []
for _ in range(t):
    test_case.append(input().strip())

sol = Solution(test_case)
results = sol.getResult()
for i, result in enumerate(results):
    print("Case # {}: ".format(i + 1))
    for perm in result:
        print(perm)
