class Solution:
    def climbStairs(self, n: int) -> int:
        cnt = 0
        for i in range(n // 2 + 1):
            b = i
            a = n - (2 * b)

            if a == 0 or b == 0:
                cnt += 1

            else:
                left = a + b
                right = min(a, b)
                child = left
                for i in range(right - 1):
                    left -= 1
                    child *= left

                parent = right
                for j in range(right - 1):
                    right -= 1
                    parent *= right

                cnt += child//parent
        return cnt


sol = Solution()
input = 6
print(sol.climbStairs(input))