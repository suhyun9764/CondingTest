from collections import deque                                 
                                                              
                                                              
class Solution:                                               
    def get_docNum(self, targetNum: int, docs: list):         
        prior_table = sorted(docs)                            
        queue = deque(enumerate(docs))                        
        cnt = 0                                               
        while queue:                                          
            current_target_prior = prior_table[-1]            
            if queue[0][1] == current_target_prior :          
                cnt+=1                                        
                if(queue[0][0] == targetNum):                 
                    break                                     
                queue.popleft()                               
                prior_table.pop()                             
                                                              
            else :                                            
                queue.append(queue.popleft())                 
                                                              
        return cnt                                            
                                                              
t = int(input())                                              
sol = Solution()                                              
for _ in range(t):                                            
    n,m = map(int,input().split(" "))                         
    print(sol.get_docNum(m,list(input().split(" "))))         
                                                              