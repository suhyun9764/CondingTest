class Lumberyard:
    def get_result(self, ls, limit):
        end = max(ls)
        start = 0
        answer = 0
        while start <= end:
            mid = (start + end) // 2
            total = self.cutting_tree(mid, ls)
            if total >= limit:
                answer = mid
                start = mid+1
            else :
                end = mid-1

        print(answer)

        pass

    def cutting_tree(self, mid, ls):
        total = 0
        for tree in ls:
            remain = tree - mid
            if remain < 0:
                continue
            else:
                total += remain
        return total


n, m = map(int, input().split())
ls = list(map(int, input().split()))
lumberyard = Lumberyard()
lumberyard.get_result(ls, m)
