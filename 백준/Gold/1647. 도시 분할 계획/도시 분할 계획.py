class UnionFind:
    def __init__(self, n):
        self.parent = [0]*(n+1)
        for i in range(1,n+1):
            self.parent[i] = i
        self.rank = [0] * (n + 1)

    def find_parent(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find_parent(self.parent[x])

        return self.parent[x]

    def union_parent(self, a, b):
        a = self.find_parent(a)
        b = self.find_parent(b)

        if a != b:
            if self.rank[a] < self.rank[b]:
                self.parent[a] = b
            else:
                self.parent[b] = a
                if self.rank[a] == self.rank[b]:
                    self.rank[a] += 1


def get_minimum_price(edges, n):
    uf = UnionFind(n)
    total = []
    for edge in edges:
        cost, a, b = edge
        if uf.find_parent(a) != uf.find_parent(b):
            uf.union_parent(a,b)
            total.append(cost)

    total.pop()

    return sum(total)


n, m = map(int, input().split())
edges = []
for _ in range(m):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()
print(get_minimum_price(edges, n))
