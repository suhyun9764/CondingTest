class Solution {
    int[] nNums;
    int answer = 0;
    public int solution(int[] nums) {
        nNums = nums;
        // depth가 3이 될때까지 dfs
        dfs(0,0,0);
        // 3이면 소수인지 확인
        // 소수라면 answer++;
        return answer;
    }
    
    void dfs(int depth, int index, int sum){
        if(depth==3){
            if(isSosoo(sum))
                answer++;
            return;
        }
        
        for(int i=index;i<nNums.length;i++){
            dfs(depth+1, i+1,sum+nNums[i]);
        }
    }
    
    boolean isSosoo(int sum){
        if(sum<2)
            return false;
        
        if(sum==3)
            return true;
        
        if(sum%2==0)
            return false;
        
        for(int i=3;i<=Math.sqrt(sum);i+=2){
            if(sum%i==0)
                return false;
        }
        
        return true;
    }
}