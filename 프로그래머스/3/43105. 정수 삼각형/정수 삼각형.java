class Solution {
    public int solution(int[][] triangle) {
        // 2번쨰부터 끝까지 순회
        for(int i=1;i<triangle.length;i++){
            int[] currentFloor = triangle[i];
            for(int j=0;j<currentFloor.length;j++){
                if(j==0){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][0];
                }else if(j==currentFloor.length-1){
                    triangle[i][j] = triangle[i][j]+triangle[i-1][currentFloor.length-2];
                }else{
                    triangle[i][j] = triangle[i][j]+Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            if(triangle[triangle.length-1][i]>max)
                max = triangle[triangle.length-1][i];
        }
        
        return max;
        // 각 층의 원소별로 전단계의 왼오 중 더 많은거 저장
        // 마지막에 가장 큰값 리턴
    }
}