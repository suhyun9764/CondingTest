class Solution:
    def get_minimum_time(self, ls):
        ls.sort()
        answer = 0
        for i in range(len(ls)):
            if i>0:
                ls[i] +=ls[i-1]
                answer+=ls[i]

            else :
                answer+=ls[i]
        print(answer)


sol = Solution()
n = int(input())
ls = list(map(int, input().split()))
sol.get_minimum_time(ls)
