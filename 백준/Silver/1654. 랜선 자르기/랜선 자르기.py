class LanCutter:
    def cutting_cable(self, cables, cutting_length):
        total = 0
        for cable in cables:
            total += cable//cutting_length

        return total

    def get_result(self, cables, target):
        end = max(cables)
        start = 1
        answer = 0
        while start <= end:
            mid = (start + end) // 2
            total = self.cutting_cable(cables, mid)
            if total >=target :
                start = mid+1
                answer = mid
            else :
                end = mid-1

        print(answer)

k, target = map(int, input().split())
cables = []
for _ in range(k):
    cables.append(int(input()))
lanCutter = LanCutter()
lanCutter.get_result(cables, target)
