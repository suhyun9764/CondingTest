class Solution:
    def get_answer(self,n):
        first = 1
        second = 1

        if n <=1 :
            print(1)
            return

        current = 0
        for i in range(2,n+1) :
            current = first + second
            first = second
            second = current


        print(current)


sol = Solution()
while 1:
    n = int(input())
    if n == 0:
        break

    sol.get_answer(n)