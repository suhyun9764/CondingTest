import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        
        long[] fact = new long[n];
        fact[0] = 1;
        for(int i=1;i<n;i++){
            fact[i] = fact[i-1]*i;
        }
        
        int[] answer = new int[n];
        
        k--;
        int index = 0;
        for(int i=n-1;i>=0;i--){
            int cur = (int)(k/fact[i]);
            // System.out.println(cur);
            answer[index++] = numbers.get(cur);
            // System.out.println(index);
            numbers.remove(cur);
            k%=fact[i];
        }
        
        return answer;
    }
}