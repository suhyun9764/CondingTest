from collections import deque
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k ==1 :
            answer = []
            for i in range(n):
                ls = [i+1]
                answer.append(ls)
            return answer

        answer = []
        ls = []
        for i in range(n):
            ls.append(i+1)
        que = deque(ls)

        def dfs(index,path):
            if len(path) == k:
                answer.append(path.copy())
                return

            for i in range(index,len(ls)):
                current = que[i]
                path.append(current)
                dfs(i+1,path)
                path.pop()



        for i in range(len(ls)-i):
            dfs(i,[])
            que = deque(ls)


        return answer







n=4
k=3
sol = Solution()
print(sol.combine(n,k))