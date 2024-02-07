class Solution :
    def is_Contain_target(self, nums, target) :
        dict = {}
        for num in nums :
            dict[num] = True

        for num in target :
            if num in dict :
                print(1)
            else :
                print(0)





n = int(input())
arr_A = list(map(int, input().split(" "))) # 비교 대상인 A
m = int(input())
target = list(map(int, input().split(" ")))
Solution().is_Contain_target(arr_A,target)