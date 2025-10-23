import java.util.*;

class Solution {
    char[] charNumbers;
    int n;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        charNumbers = numbers.toCharArray();
        n = numbers.length();
        // 1. 수 조합
        dfs(0,new StringBuilder(),new boolean[n]);
        // 2. 수 조합이 소수인지 판별
        // 3. 소수라면 Set에 저장
        // 4. Set 사이즈 출력
        return set.size();
    }
    
    private void dfs(int index, StringBuilder sb, boolean[] visited){
        if(index==n){
            String stringNumber = sb.toString();
            if(stringNumber.equals("")) return;
            int cur = Integer.parseInt(stringNumber);
            if(isPrime(cur)){
                set.add(cur);
            }
            return;
        }
            
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(charNumbers[i]);
            dfs(index+1,sb,visited);
            visited[i] = false;
            sb.setLength(sb.length()-1);
            dfs(index+1,sb,visited);
        }
    }
    
    private boolean isPrime(int number){
        if(number==0) return false;
        if(number==1) return false;
        if(number==2) return true;
        if(number==3) return true;
        
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0) return false;
        }
        
        return true;
    }
}