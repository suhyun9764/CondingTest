import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        char[][] charArr1 = new char[n][n];
        char[][] charArr2 = new char[n][n];
        
        for(int i=0;i<n;i++){
            charArr1[i] = toBinaryArray(arr1[i],n);
            System.out.println("charArr1 : "+Arrays.toString(charArr1[i]));
            charArr2[i] = toBinaryArray(arr2[i],n);
            System.out.println("charArr2 : "+Arrays.toString(charArr2[i]));
        }
        
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(charArr1[i][j]=='1'||charArr2[i][j]=='1'){
                    sb.append("#");
                }else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        
        return answer;
    }
    
    public char[] toBinaryArray(int num,int n){
        String binary = Integer.toString(num,2);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-binary.length();i++){
            sb.append("0");
        }
        sb.append(binary);
            
        return sb.toString().toCharArray();
    }
}