from typing import List


class Solution:

    def get_answer(self, ls: List):
        select = [[0] * 3 for _ in range(len(ls))]
        select[0] = ls[0]
        for i in range(1, len(ls)):
            select[i][0] = ls[i][0] + min(select[i - 1][1], select[i - 1][2])
            select[i][1] = ls[i][1] + min(select[i - 1][0], select[i - 1][2])
            select[i][2] = ls[i][2] + min(select[i - 1][0], select[i - 1][1])

        answer = min(select[-1])
        return answer

sol = Solution()
n = int(input())
ls = []
for _ in range(n):
    ls.append(list(map(int, input().split())))

print(sol.get_answer(ls))
