import heapq                                                                                         
from typing import List                                                                              
                                                                                                     
                                                                                                     
class Solution:                                                                                      
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:                               
                                                                                                     
        soldiers_num_table = []                                                                      
        for idx, row in enumerate(mat):                                                              
            soldiers_num = sum(row)                                                                  
            heapq.heappush(soldiers_num_table, (soldiers_num, idx))                                  
                                                                                                     
        answer = []                                                                                  
        for _ in range(k):                                                                           
            soldiers, idx =heapq.heappop(soldiers_num_table)                                         
            answer.append(idx)                                                                       
                                                                                                     
                                                                                                     
                                                                                                     
                                                                                                     
                                                                                                     
        return answer                                                                                