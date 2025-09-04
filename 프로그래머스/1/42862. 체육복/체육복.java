import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        
        for(int i=0;i<lost.length;i++){
            int current = lost[i];
            arr[current] -=1;
        }
        
        for(int i=0;i<reserve.length;i++){
            int current = reserve[i];
            arr[current] +=1;
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(arr[i]>0) continue;
            boolean canRent = false;
            if(i>1){
                if(arr[i-1]==2){
                    arr[i] = 1;
                    arr[i-1]-=1;
                    canRent = true;
                }
            }
            
            if(canRent) continue;
            
            if(i<n){
                if(arr[i+1]==2){
                    arr[i] = 1;
                    arr[i+1]-=1;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            if(arr[i]>=1) answer++;
        }
        return answer;
    }
}