import heapq


class Solution:

    def get_maximum_classNumber(self, ls):
        ls.sort()
        classes = []
        heapq.heappush(classes,ls[0][1])
        for i in range(1,len(ls)):
            start, end = ls[i]
            earliest_time = classes[0]
            if start>=earliest_time:
                heapq.heappop(classes)

            heapq.heappush(classes,end)

        print(len(classes))



n = int(input())
ls = []
max = 0
for _ in range(n):
    s,t = map(int,input().split())
    ls.append((s,t))

sol = Solution()
sol.get_maximum_classNumber(ls)

