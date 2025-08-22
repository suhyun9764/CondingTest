import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        // 탈출 기준으로 정렬
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        // 처음꺼 꺼내놓기
        int cam = routes[0][1];
        // 두번째부터 순회
        for(int i=1;i<routes.length;i++){
            if(cam<routes[i][0]){
                answer++;
                cam = routes[i][1];
            }
        }
        
        return answer;
        // 첫번째 탈출지점에 cctv부착
        // 현재 차량이 그 cctv를 통과하면 continue
        // 통과하지않는다면 탈출지점에 cctv부착
        
    }
}