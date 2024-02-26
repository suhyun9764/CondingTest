from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum_max = nums[0]
        current = nums[0]
        
        for num in nums[1:]:
            current = max(num, current+num)
            sum_max = max(current,sum_max)
            
        return sum_max

nums = [5,4,-1,7,8]
sol = Solution()
print(sol.maxSubArray(nums))



