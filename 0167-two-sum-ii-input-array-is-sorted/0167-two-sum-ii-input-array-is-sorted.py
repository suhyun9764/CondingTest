from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # 정렬 순회
        for i in range(len(numbers)):
            start = i + 1
            end = len(numbers) - 1
            t = target - numbers[i]
            while start <= end:
                mid = (start + end) // 2
                if numbers[mid] == t:
                    answer = [i+1,mid+1]
                    return answer
                elif numbers[mid] > t:
                    end = mid-1
                else :
                    start = mid+1

sol = Solution()
input = [2,7,11,15]
target = 9
print(sol.twoSum(input,target))
