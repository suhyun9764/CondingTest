class Solution:
    def get_max_budget(self, ls, maginot):
        start = 0
        end = max(ls)
        answer = 0
        while start <= end:
            mid = (start + end) // 2
            total = self.getApplyBudgetResult(ls, mid)
            if total <= maginot:
                answer = mid
                start = mid+1
            else :
                end = mid-1

        print(answer)

    def getApplyBudgetResult(self, ls, mid):
        total = 0
        for budget in ls:
            total += min(mid, budget)
        return total

n = int(input())
ls = list(map(int, input().split()))
maginot = int(input())
sol = Solution()
sol.get_max_budget(ls, maginot)
