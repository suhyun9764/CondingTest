import java.util.*;

class Solution{
    public int solution(String s){
        int max = 1;
        
        for(int i=1;i<s.length()-1;i++){
            int l = i-1;
            int r = i+1;
            int length = 1;
            while(l>=0&&r<=s.length()-1){
                if(s.charAt(l)!=s.charAt(r)) break;
                l--;
                r++;
                length+=2;
            }
            
            max = Math.max(max,length);
        }
        
        for(int i=1;i<s.length();i++){
            int l = i-1;
            int r = i;
            int length = 0;
            while(l>=0&&r<=s.length()-1){
                if(s.charAt(l)!=s.charAt(r)) break;
                l--;
                r++;
                length+=2;
            }
            
            max = Math.max(length,max);
        }
        
        
        return max;
    }
}