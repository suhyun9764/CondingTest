from collections import defaultdict


class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        stone_table = defaultdict(int)
        cnt = 0
        for stone in stones:
            stone_table[stone] +=1

        for jewel in jewels:
            cnt += stone_table[jewel]

        return cnt
