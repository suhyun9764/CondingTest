import sys


class Solution:

    def getHouseNumber(self, houses):
        dx = [0,0,1,-1]
        dy = [1,-1,0,0]
        answer = []

        def dfs(i,j):
            if i <0 or i >=len(houses) or j <0 or j>=len(houses[0]) or houses[i][j] != 1:
                return 0

            houses[i][j] = 0
            cnt =1
            for d in range(4) :
                cnt += dfs(i+dy[d],j+dx[d])

            return cnt


        for h in range(len(houses)):
            for w in range(len(houses[0])):
                if houses[h][w] == 0:
                    continue
                answer.append(dfs(h,w))


        answer.sort()
        print(len(answer))
        for a in answer :
            print(a)




n = int(input())
houses = []
for i in range(n):
    input_string = input().strip()
    split_input = [int(char) for char in input_string]
    houses.append(split_input)

sol = Solution()
sol.getHouseNumber(houses)
