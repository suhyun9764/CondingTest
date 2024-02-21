class Solution:
    def __init__(self, time_list):
        self.time_list = time_list

    def get_result(self):
        sorted_convert_dict = sorted(self.convert_time().items(),key=lambda item:item[1])
        for time in sorted_convert_dict :
            print(*self.time_list[time[0]])




        return

    def convert_time(self):
        convert_dict = {}
        for i in range(len(self.time_list)):
            convert_hour = 3600 * self.time_list[i][0]
            convert_minute = 60 * self.time_list[i][1]
            second = self.time_list[i][2]
            convert_dict[i] = convert_hour + convert_minute + second

        return convert_dict


n = int(input())
time_list = []
for _ in range(n):
    time_list.append(list(map(int, input().split())))

sol = Solution(time_list)
sol.get_result()