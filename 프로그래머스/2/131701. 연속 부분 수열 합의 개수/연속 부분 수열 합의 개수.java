import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // set에 저장하여 중복판단
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        // 1부터 elements.size만큼 순회 (모든 길이의 경우의수)
        for(int i=1;i<elements.length+1;i++){
      
            for(int c=0;c<elements.length;c++){
                int sum = 0;
                for(int j=0;j<i;j++){
                    sum += elements[(c+j)%elements.length];
                }
                            set.add(sum);
            }
      

        }
        
        return set.size();
    }
}