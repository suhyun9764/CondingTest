import java.util.*;
class Solution {
    int solution(int[][] land) {
        // int[land.length][4] 생성
        int n = land.length;
        int[][] sumArray = new int[n][4];
        // int[0][0~3] 까지 초기화
        for(int i=0;i<4;i++){
            sumArray[0][i] = land[0][i];
        }
        // 1부터 land.length-1 까지 순회
        for(int i=1;i<n;i++){
            sumArray[i][0] = land[i][0] + Math.max(sumArray[i-1][1],Math.max(sumArray[i-1][2],sumArray[i-1][3]));
            sumArray[i][1] = land[i][1] + Math.max(sumArray[i-1][0],Math.max(sumArray[i-1][2],sumArray[i-1][3]));
            sumArray[i][2] = land[i][2] + Math.max(sumArray[i-1][1],Math.max(sumArray[i-1][0],sumArray[i-1][3]));
            sumArray[i][3] = land[i][3] + Math.max(sumArray[i-1][1],Math.max(sumArray[i-1][2],sumArray[i-1][0]));                                       
        }
        // 각자리에 들어올 수 있는 가장 큰값과 더하기
        // 마지막에 점수 최대값 구하기
        return Math.max(Math.max(sumArray[n-1][0],sumArray[n-1][1]),Math.max(sumArray[n-1][2],sumArray[n-1][3]));
    }
} 