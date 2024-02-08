import heapq
import sys


class Solution:
    def get_result(self, n: int):
        list = []
        for _ in range(n):
            input_value = int(sys.stdin.readline().rstrip())
            if input_value == 0:
                if not list :
                    print(0)
                else :
                    print(heapq.heappop(list))

            else :
                heapq.heappush(list, input_value)

n = int(input())
sol = Solution()
sol.get_result(n)
