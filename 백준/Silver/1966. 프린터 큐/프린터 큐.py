from collections import deque


class Printer:
    def __init__(self, arr):
        self.arr = deque(arr)
    def get_order(self, idx):
        pri_arr = deque(enumerate(self.arr))
        cnt = 0
        while pri_arr:
            current_document = pri_arr.popleft()
            if any(current_document[1] < document[1] for document in pri_arr):
                pri_arr.append(current_document)
            else :
                cnt+=1
                if current_document[0]==idx:
                    return cnt


t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    printer = Printer(arr)
    print(printer.get_order(m))


