import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int n = stones.length;
        
        int[] copy = Arrays.copyOf(stones,n);
        Arrays.sort(copy);
        int left = 0;
        int right = copy[n-1];
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(isAvailable(stones,mid,k)){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    private boolean isAvailable(int[] stones, int mid, int k){
        int zeroCnt = 0;
        for(int stone : stones){
            if(stone-mid<0){
                zeroCnt++;
                
                if(zeroCnt>=k){
                    return false;
                }
            }else{
                zeroCnt = 0;
            }
        }
        
        return true;
    }
}