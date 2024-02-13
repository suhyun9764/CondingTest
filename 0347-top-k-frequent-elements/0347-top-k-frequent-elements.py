from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict = {}
        for num in nums:
            if num not in dict:
                dict[num] = 1
            else :
                dict[num] += 1

        values = sorted(dict.keys(), key=lambda x: dict[x], reverse=True)
        return values[:k]

sol = Solution()
nums = [1,1,1,2,2,3,3,3,3,3]
k = 2
print(sol.topKFrequent(nums,k))