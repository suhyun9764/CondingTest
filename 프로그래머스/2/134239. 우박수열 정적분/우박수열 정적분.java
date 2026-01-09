import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> list = new ArrayList<>();
        list.add((double)k);
        int t = ranges.length;
        
        List<Double> sum = new ArrayList<>();
        sum.add(0.0);
        int n = 1;
        while(k!=1){
            if(k%2==0){
                k/=2;
            }else{
                k=k*3+1;
            }
            list.add((double)k);
            double beforeLength = list.get(n-1);
            double beforeSum = sum.get(n-1);
            sum.add((beforeLength+k)/2+beforeSum);
            n++;
        }
        // System.out.println(list.toString());
        // System.out.println(sum.toString());
        double[] answer = new double[t];
        
        for(int i=0;i<t;i++){
            int[] cur = ranges[i];
            int start = cur[0];
            int end = n-1+cur[1];
            
            if(end<start){
                answer[i] = -1;
                continue;
            }
            
            answer[i] = sum.get(end)-sum.get(start);
        }
        
        
        return answer;
    }
}