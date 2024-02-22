from collections import defaultdict

class Solution:
    def __init__(self, ls: list):
        self.ls = sorted(ls)

    def print_avg(self):
        sum_num = sum(self.ls)
        result = int(round(sum_num / len(self.ls), 0))
        print(result)

    def print_mid(self):
        mid_idx = len(self.ls) // 2
        print(self.ls[mid_idx])

    def print_often(self):
        dic = defaultdict(int)
        for num in self.ls:
            dic[num] += 1

        oftens = []
        max_count = max(dic.values())  # 가장 많이 등장한 횟수
        for key, value in dic.items():
            if value == max_count:
                oftens.append(key)

        oftens.sort()  # 최빈값들을 정렬
        print(oftens[0] if len(oftens) == 1 else oftens[1])  # 하나면 첫 번째 값, 여러 개면 두 번째 값 출력

    def print_range(self):
        print(self.ls[-1] - self.ls[0])

    def print_all(self):
        self.print_avg()
        self.print_mid()
        self.print_often()
        self.print_range()

n = int(input())
ls = []
for _ in range(n):
    ls.append(int(input()))

sol = Solution(ls)
sol.print_all()
