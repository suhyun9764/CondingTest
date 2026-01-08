import java.util.*;

class Solution {
    int[][] data;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 데이터 정렬
        this.data = data;
        Arrays.sort(this.data,(a,b)->{
            if(a[col-1]==b[col-1])
                return b[0]-a[0];
            
            return a[col-1]-b[col-1];
        });
        
        // begin~end 까지 xor 계산
        int answer = calculateMod(row_begin-1);
        System.out.println(answer);
        for(int i=row_begin;i<row_end;i++){
            int mod = calculateMod(i);
            answer^=mod;
        }
        
        return answer;
    }
    
    private int calculateMod(int idx){
        int[] tuple = data[idx];
        int total = 0;
        
        for(int i=0;i<tuple.length;i++){
            total+=tuple[i]%(idx+1);
        }
        
        return total;
    }
}