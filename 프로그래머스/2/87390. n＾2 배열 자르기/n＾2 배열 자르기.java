import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {      
        int[] arr = new int[(int)(right-left+1)];
        for(long i=left;i<=right;i++){
            int y = (int)(i/n+1);
            int x = (int)(i%n+1);
            arr[(int)(i-left)] = Math.max(y,x); 
        }
        return arr;
    }
}