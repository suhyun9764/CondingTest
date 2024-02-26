import heapq

INF = int(1e9)


class Solution:
    def __init__(self, v, ls, start):
        self.ls = ls
        self.graph = [[] for _ in range(v + 1)]
        self.distance = [INF] * (v + 1)
        self.start = start
        for j in ls:
            self.graph[j[0]].append((j[1], j[2]))

    def get_answer(self):
        q = []
        self.distance[start] = 0
        heapq.heappush(q, (0, self.start))
        while q:
            dist, cur = heapq.heappop(q)
            if self.distance[cur] < dist:
                continue

            for i in self.graph[cur]:
                cost = dist + i[1]
                if self.distance[i[0]] > cost:
                    self.distance[i[0]] = cost
                    heapq.heappush(q,(cost, i[0]))

        for t in range(1, len(self.distance)):
            if self.distance[t] == INF:
                print("INF")
            else:
                print(self.distance[t])


v, e = map(int, input().split())
start = int(input())
ls = []
for i in range(e):
    ls.append(list(map(int, input().split())))

sol = Solution(v, ls, start)
sol.get_answer()
