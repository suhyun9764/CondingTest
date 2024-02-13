class Solution:
    def longestPalindrome(self, s: str) -> str:
        max = 1
        start = 0
        if len(s) <= 1:
            return s
        for i in range(len(s)):
            # 짝수일 때
            left = i
            right = i + 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > max:
                    max = right - left + 1
                    start = left
                left -=1
                right +=1


            # 홀수일 때
            left = i-1
            right = i+1
            while left >= 0 and right < len(s) and s[left]==s[right]:
                if right - left + 1 > max:
                    max = right - left + 1
                    start = left
                left -=1
                right +=1

        return s[start:start+max]


sol = Solution()
s = " "
print(sol.longestPalindrome(s))