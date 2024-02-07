class Solution:
    def longestPalindrome(self, s: str) -> str:
        s_length = len(s)
        max_length = 1
        start = 0
        if s_length == 1:
            return s

        for i in range(s_length):
            left = i - 1
            right = i + 1
            while (left >= 0 and right < s_length and s[left] == s[right]):
                if max_length < right - left + 1:
                    max_length = right - left + 1
                    start = left
                left -= 1
                right += 1

            left = i
            right = i + 1
            while (left >= 0 and right < s_length and s[left] == s[right]):
                if max_length < right - left + 1:
                    max_length = right - left + 1
                    start = left

                left -= 1
                right += 1

        return s[start:start + max_length]