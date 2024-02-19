class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        u_root = self.find(u)
        v_root = self.find(v)

        if u_root == v_root:
            return False

        if self.rank[u_root] > self.rank[v_root]:
            self.parent[v_root] = u_root
        elif self.rank[u_root] < self.rank[v_root]:
            self.parent[u_root] = v_root
        else:
            self.parent[v_root] = u_root
            self.rank[u_root] += 1

        return True

def kruskal(graph, n, start, end):
    graph.sort(key=lambda x: x[2], reverse=True)
    disjoint_set = DisjointSet(n)
    for u, v, weight in graph:
        if disjoint_set.union(u, v):
            if disjoint_set.find(start) == disjoint_set.find(end):
                return weight
    return 0

try:
    n, m = map(int, input().split())
    start, end = map(int, input().split())
    graph = []

    for _ in range(m):
        u, v, w = map(int, input().split())
        graph.append((u - 1, v - 1, w))

    print(kruskal(graph, n, start - 1, end - 1))
except Exception as e:
    print("Error:", e)
