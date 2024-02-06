from collections import deque


def test_problem_queue(num):
    deq = deque([i for i in range(1,num+1)])
    while len(deq)>1 :
        deq.popleft()
        deq.append(deq.popleft())

    return deq.pop()

n = int(input())

result = test_problem_queue(n)
print(result)