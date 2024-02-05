from typing import List

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        sorted_list = sorted(nums)
    
        return sum(sorted_list[::2])