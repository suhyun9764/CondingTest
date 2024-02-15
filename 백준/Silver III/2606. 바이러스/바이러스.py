from collections import defaultdict


class Solution:
    def getVirusedComputerNumber(self,num,pairList):
        dict = defaultdict(list)
        for pair in pairList:
            dict[pair[0]].append(pair[1])
            dict[pair[1]].append(pair[0])


        def dfs(node,path):
            current_node = node
            if current_node not in path :
                path.append(current_node)
                for pair in dict[current_node]:
                    dfs(pair,path)

            return len(path)-1



        return dfs(1,[])











num = int(input())
pairNum = int(input())
pairList = []
for _ in range(pairNum):
    pairList.append(list(map(int,input().split())))
sol = Solution()
print(sol.getVirusedComputerNumber(num,pairList))