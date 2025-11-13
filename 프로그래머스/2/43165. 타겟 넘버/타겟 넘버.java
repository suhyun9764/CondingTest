class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0);
        return answer;
    }
    
    private void dfs(int i, int result){
        if(i==numbers.length){
            if(result==target) answer++;
            return;
        }
        
        dfs(i+1,result+numbers[i]);
        dfs(i+1,result-numbers[i]);
    }
}