import java.util.*;

class Solution {
    int k;
    public int solution(int[] stones, int k) {
        this.k = k;
        int left = 0;
        int right = 200000000;
        for(int i=0;i<stones.length;i++){
            right = Math.max(stones[i],right);
        }
        while(left<right){
            int mid = (left+right)/2;
            if(isAvailable(mid,stones)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        return left-1;
    }
    
    private boolean isAvailable(int mid,int[] stones){
        int cnt = 0;
        for(int i=0;i<stones.length;i++){
            int stone = stones[i];
            if(stone-mid+1<=0){
                cnt++;
                if(cnt>=k)
                    return false;
            }
 
            if(stone-mid+1>0) cnt=0;
        }
        
        if(cnt>=k) return false;
        
        return true;
    }
}