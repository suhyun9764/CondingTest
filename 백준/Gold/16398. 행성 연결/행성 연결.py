def make_edges(mat):
    edges = []
    for i in range(len(mat)):
        for j in range(i + 1, len(mat)):
            if i != j:  # 대각선 요소 제외
                edges.append((mat[i][j], i, j))
    return edges



def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])

    return parent[x]


def union_parent(parent, rank, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b
        if rank[a] == rank[b]:
            rank[a] += 1


def get_minimum_price(parent, rank, edges):
    result = 0
    for edge in edges:
        price, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, rank, a, b)
            result += price

    return result


n = int(input())

mat = []
for _ in range(n):
    ls = list(map(int, input().split()))
    mat.append(ls)
edges = sorted(make_edges(mat))
parent = [0] * n
for i in range(0, n ):
    parent[i] = i

rank = [0] * n

print(get_minimum_price(parent, rank, edges))
