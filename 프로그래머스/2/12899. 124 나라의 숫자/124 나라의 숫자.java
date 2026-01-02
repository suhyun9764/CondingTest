import java.util.*;

class Solution {
    char[] nums = {'1','2','4'};
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>3){
            int value = n/3;
            int remain = n%3;
            if(remain==0){
                sb.append('4');
                n = value-1;
                continue;
            }
            
            sb.append(nums[remain-1]);
            n = value;
        }
        
        if(n>0)
            sb.append(nums[n-1]);
        
        return sb.reverse().toString();
    }
}