from collections import deque

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

    def get_parent(self, data):
        parent = [0] * (len(data) + 1)  # 각 노드의 부모를 저장할 배열 초기화
        visited = [False] * (len(data) + 1)  # 방문한 노드를 체크할 배열 초기화
        queue = deque([1])  # 루트 노드부터 시작하여 BFS 탐색을 위한 큐 초기화
        visited[1] = True

        while queue:
            node = queue.popleft()
            for child in data.get(node, []):
                if not visited[child]:
                    visited[child] = True
                    parent[child] = node  # 노드의 부모를 저장
                    queue.append(child)

        return parent

sol = Solution()
num = int(input())
data = sol.get_data(num)
parent = sol.get_parent(data)
for i in range(2, num + 1):
    print(parent[i])
