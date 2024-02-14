from collections import deque


class Solution:
    def calcCalling(self, n, m, k):
        que1 = deque()
        que2 = deque()

        for i in range(n):
            que1.append(i+1)

        target = 0
        answer = 0
        cnt = 0
        while target < k:
            cnt +=1
            if cnt == m:
                answer = que1.popleft()
                target +=1
                cnt = 0

            else:
                que2.append(que1.popleft())

            if not que1:
                que1, que2 = que2, que1

        print(answer)


sol = Solution()
while 1:
    input_Nums = input()
    n, m, k = map(int, input_Nums.split())
    if n == 0 and m == 0 and k == 0:
        break
    sol.calcCalling(n, m, k)
