import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] arr = new int[n*2];
        
        long sum1 = 0;
        for(int i=0;i<n;i++){
            sum1 += queue1[i];
            arr[i] = queue1[i];
        }
        
        long sum2 = 0;
        for(int i=0;i<n;i++){
            sum2 += queue2[i];
            arr[n+i] = queue2[i];
        }
        
        if((sum1+sum2)%2!=0) return -1;
        long target = (sum1+sum2)/2;
        
        int left = 0;
        int right = n;
    
        int cal = 0;
        
        while(left<n*2&&right<n*2){
            if(sum1==target)
                return cal;
            
            if(sum1>target){
                sum1-=arr[left++];
                cal++;
                continue;
            }
            
            sum1+=arr[right++];
            cal++;
        }
        
        return -1;
        
    }
}