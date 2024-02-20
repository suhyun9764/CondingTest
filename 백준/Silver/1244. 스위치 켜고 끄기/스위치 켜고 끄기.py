class Solution:
    def __init__(self,nums):
        self.switches = [0]*(len(nums)+1)
        for i in range(1,len(nums)+1):
            self.switches[i] = nums[i-1]



    def control_switch(self,sex, num):
        if sex == 1:
            i=1
            target = num*i
            while target < len(self.switches):
                if self.switches[target] == 1:
                    self.switches[target] = 0
                else :
                    self.switches[target] = 1

                i+=1
                target = num*i


        elif sex == 2:
            if self.switches[num] == 1:
                self.switches[num] =0
            else :
                self.switches[num]=1
            left = num-1
            right = num+1
            while left>0 and right<len(self.switches) and self.switches[left]==self.switches[right]:
                if self.switches[left] ==1 and self.switches[right]==1:
                    self.switches[left]=0
                    self.switches[right]=0
                else :
                    self.switches[left]=1
                    self.switches[right]=1
                left-=1
                right+=1

    def get_result(self):
        count = 0
        for i in range(1, len(self.switches)):
            print(self.switches[i], end=' ')
            count += 1
            if count == 20:
                print()  # 20개 출력 후 줄 바꾸기
                count = 0


n = int(input())
nums = list(map(int,input().split()))
sol = Solution(nums)
t = int(input())
for _ in range(t):
    sex, num = map(int, input().split())
    sol.control_switch(sex,num)
sol.get_result()
