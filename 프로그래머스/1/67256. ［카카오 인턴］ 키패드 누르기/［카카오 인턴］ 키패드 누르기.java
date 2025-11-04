import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer,int[]> map = new HashMap<>();
        int number = 1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map.put(number++,new int[]{i,j});
            }
        }
        
        map.put(0,new int[]{3,1});
        StringBuilder sb = new StringBuilder();
        
        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        
        for(int curNumber : numbers){
            if(curNumber==1||curNumber==4||curNumber ==7){
                sb.append("L");
                leftPos = map.get(curNumber);
                continue;
            }
            
            if(curNumber==3||curNumber==6||curNumber==9){
                sb.append("R");
                rightPos = map.get(curNumber);
                continue;
            }
            
            int[] curNumberPos = map.get(curNumber);
            int leftLength = Math.abs(curNumberPos[0]-leftPos[0])+Math.abs(curNumberPos[1]-leftPos[1]);
            int rightLength = Math.abs(curNumberPos[0]-rightPos[0])+Math.abs(curNumberPos[1]-rightPos[1]);
            
            if(leftLength<rightLength){
                sb.append("L");
                leftPos = curNumberPos;
                continue;
            }
            
            if(leftLength>rightLength){
                sb.append("R");
                rightPos = curNumberPos;
                continue;
            }
            
            if(hand.equals("left")){
                sb.append("L");
                leftPos = curNumberPos;
                continue;
            }
            
             sb.append("R");
             rightPos = curNumberPos;
        }
        
        return sb.toString();
    }
}