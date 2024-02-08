class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        dict = {}
        start = 0
        max_length = 0

        for i,char in enumerate(s) :
            if char in dict and dict[char] >= start :
                start = dict[char]+1

            dict[char] = i
            max_length = max(max_length, i - start + 1)

        return max_length