class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewels_dict = {}
        for char in jewels:
            jewels_dict[char] = 0
            
        cnt = 0
        for stone in stones :
            if stone in jewels_dict:
                cnt += 1
                
        return cnt