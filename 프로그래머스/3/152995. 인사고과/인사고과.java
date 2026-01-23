import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // score 0 인덱스 기준으로 정렬
        // 맨앞 인덱스는 살리고 list에 총합으로 넣기
        // 정렬된 스코어에서 1인덱스 기준으로 가장 큰값보다 작으면 버리기
        int target0 = scores[0][0];
        int target1 = scores[0][1];
        Arrays.sort(scores,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            
            return b[0]-a[0];
        });
        List<Integer> order = new ArrayList<>();
        // order.add(scores[0][0]+scores[0][1]);
        int max = 0;
        
        for(int i=0;i<scores.length;i++){
            if(scores[i][1]<max){
                if(scores[i][0] == target0 && scores[i][1]==target1) return -1;
                continue;
            }
            order.add(scores[i][0]+scores[i][1]);
            max = Math.max(max,scores[i][1]);
        }
        
        Collections.sort(order,Comparator.reverseOrder());
        for(int i=0;i<order.size();i++){
            if(order.get(i)==target0+target1)
                return i+1;
        }
        
        return -1;
    }
}