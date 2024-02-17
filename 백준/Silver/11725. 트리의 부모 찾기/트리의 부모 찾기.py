import sys
from collections import defaultdict, deque


class Solution:
    def get_data(self, num):
        data_dict = {}
        for _ in range(num - 1):
            a, b = map(int, input().split())
            if a not in data_dict:
                data_dict[a] = []
            if b not in data_dict:
                data_dict[b] = []
            data_dict[a].append(b)
            data_dict[b].append(a)
        return data_dict

    # def get_parent(self, data):
    #     visited = set()
    #
    #     def check_parent(parent, answer):
    #         visited.add(parent)
    #         for child in data[parent]:
    #             if child in visited:
    #                 continue
    #             answer[child] = parent
    #             check_parent(child, answer)
    #
    #         return answer
    #
    #     answer = check_parent(1, {1: 0})
    #     sorted_keys = sorted(answer.keys())
    #     sorted_answer = {key: answer[key] for key in sorted_keys}
    #     return sorted_answer

    def get_parent(self, data):
        parent = [0]*(len(data)+1)
        visited = [False]*(len(data)+1)
        queue = deque([1])
        visited[1] = True

        while queue:
            node = queue.popleft()
            for child in data[node]:
                if not visited[child]:
                    visited[child] = True
                    parent[child] = node
                    queue.append(child)

        return parent

# sys.setrecursionlimit(10 ** 9)
sol = Solution()
num = int(input())
data = sol.get_data(num)
answer = sol.get_parent(data)
# for key in answer:
#     if key == 1:
#         continue
#     print(answer[key])
for i in range(2, len(answer)):
    print(answer[i])
