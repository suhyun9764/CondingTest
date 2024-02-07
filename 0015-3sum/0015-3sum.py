from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # 리스트를 오름차순으로 정렬
        nums.sort()
        answer = []

        # 리스트를 순회하며 각 index와 start(초기값 = index+1), end(초기값 = len(nums)-1)를 더한 값으로 분기
        for i in range (len(nums)-2): # index+1과 len(nums)-1 이 리스트안에 있는 값이어야 되기 떄문에 -2를 해준다
            if i>0 and nums[i-1]== nums[i]:
                continue

            start = i+1
            end = len(nums)-1
            while start < end :
                sum = nums[i]+nums[start]+nums[end]
                if sum < 0 :
                    start+=1
                elif sum > 0 :
                    end -= 1
                else :
                    answer.append([nums[i], nums[start], nums[end]])


                    while start < end and nums[start] == nums[start+1]:
                        start+=1

                    while start< end and nums[end-1] == nums[end]:
                        end -= 1

                    start += 1
                    end -= 1

        return answer