from collections import deque

# 상하좌우 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 뿌요 터뜨리기
def explode(puyo, visited, x, y, color):
    q = deque()
    q.append((x, y))
    explosion = set()
    explosion.add((x, y))
    cnt = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6 and not visited[nx][ny] and puyo[nx][ny] == color:
                visited[nx][ny] = True
                q.append((nx, ny))
                explosion.add((nx, ny))
                cnt += 1

    if cnt >= 4:
        for ex, ey in explosion:
            puyo[ex][ey] = '.'
        return True
    else:
        return False

# 중력 작용
def gravity(puyo):
    for j in range(6):
        empty_cells = ['.'] * 12
        idx = 11
        for i in range(11, -1, -1):
            if puyo[i][j] != '.':
                empty_cells[idx] = puyo[i][j]
                idx -= 1
        puyo_column = ''.join(empty_cells)
        for i in range(12):
            puyo[i][j] = puyo_column[i]

# 연쇄 반응 체크
def chain_reaction(puyo):
    visited = [[False] * 6 for _ in range(12)]
    chain = False
    for i in range(12):
        for j in range(6):
            if puyo[i][j] != '.' and not visited[i][j]:
                visited[i][j] = True
                if explode(puyo, visited, i, j, puyo[i][j]):
                    chain = True
    return chain

# 뿌요 상태 입력받기
puyo = [list(input().strip()) for _ in range(12)]

# 결과 초기화
result = 0

while True:
    if not chain_reaction(puyo):
        break
    gravity(puyo)
    result += 1

print(result)
