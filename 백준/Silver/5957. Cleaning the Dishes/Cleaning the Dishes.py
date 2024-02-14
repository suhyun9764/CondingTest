class Solution:
    def wash_dish(self, disheNum:int):
        wash_stack = []
        dry_stack = []
        complete_stack = []
        for i in range(disheNum,0,-1):
            wash_stack.append(i)

        while wash_stack:
            input_nums = input()
            c, d = map(int, input_nums.split())

            if c == 1:
                for _ in range(d):
                    dry_stack.append(wash_stack.pop())

            if c == 2:
                for _ in range(d):
                    complete_stack.append(dry_stack.pop())

        while dry_stack:
            complete_stack.append(dry_stack.pop())


        while complete_stack:
            print(complete_stack.pop())


n = int(input())
sol = Solution()
sol.wash_dish(n)

