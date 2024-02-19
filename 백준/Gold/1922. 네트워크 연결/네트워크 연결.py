def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])

    return x


def union_parent(parent, a, b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
m = int(input())
edges = []
for _ in range(m):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

parent = [0] * (n + 1)
for i in range(n):
    parent[i] = i

answer = 0

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        answer += cost

print(answer)
