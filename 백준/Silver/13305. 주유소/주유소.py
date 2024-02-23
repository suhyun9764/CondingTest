from collections import deque


class Solution:
    def __init__(self, load_lengths, oil_prices):
        self.load_lengths = load_lengths
        self.oil_prices = oil_prices
        self.each_city_length = [0] * len(oil_prices)
        for i in range(1, len(oil_prices)):
            self.each_city_length[i] += self.each_city_length[i - 1] + load_lengths[i - 1]

    def get_near_cheap_gas_station(self):
        stack = []
        navigation = [0] * (len(self.oil_prices) - 2)
        for i in range(len(self.oil_prices)):
            if stack:
                while stack and self.oil_prices[i] < self.oil_prices[stack[-1]]:
                    current_gas_station = stack.pop()
                    if current_gas_station < len(self.oil_prices) - 2:
                        navigation[current_gas_station] = i - current_gas_station

            stack.append(i)

        return navigation

    def get_minimum_price(self):
        navigation = self.get_near_cheap_gas_station()
        remain_distance = sum(self.load_lengths)
        total_price = 0
        current_gas_station = 0
        while 1:
            if current_gas_station >= len(navigation) or navigation[current_gas_station] == 0 :
                total_price += remain_distance * self.oil_prices[current_gas_station]
                remain_distance = 0
                break

            near_distance = self.each_city_length[current_gas_station + navigation[current_gas_station]] - \
                            self.each_city_length[current_gas_station]
            total_price += near_distance * self.oil_prices[current_gas_station]
            remain_distance -= near_distance
            current_gas_station = current_gas_station + navigation[current_gas_station]
            if remain_distance == 0:
                break

        total_price += self.oil_prices[-2] * remain_distance

        print(total_price)

        return


n = int(input())
load_lengths = list(map(int, input().split()))
oil_prices = list(map(int, input().split()))
sol = Solution(load_lengths, oil_prices)
sol.get_minimum_price()
