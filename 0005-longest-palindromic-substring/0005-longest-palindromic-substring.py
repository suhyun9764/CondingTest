class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s)==1:
            return s
        
        start = 0
        max = 1
        
        for i in range(len(s)):
            start_idx = i-1
            end_idx = i+1
            
            while start_idx>=0 and end_idx<len(s) and s[start_idx] == s[end_idx]:
                if end_idx-start_idx+1> max:
                    start = start_idx
                    max = end_idx-start_idx+1
                    
                start_idx-=1
                end_idx+=1
                
            start_idx = i
            end_idx = i+1

            while start_idx >= 0 and end_idx < len(s) and s[start_idx] == s[end_idx]:
                if end_idx-start_idx+1> max:
                    start = start_idx
                    max = end_idx-start_idx+1
                    
                start_idx -=1
                end_idx +=1
        
        return s[start:start+max]
            