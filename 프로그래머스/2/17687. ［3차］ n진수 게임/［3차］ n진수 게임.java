

class Solution {
    public String solution(int n, int t, int m, int p) {
        int[] arr = new int[(t-1)*m+p];
        
        int index = 0;
        int number = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            String binary = Integer.toString(number++,n).toUpperCase();
            char[] charArr = binary.toCharArray();
            for(int i=0;i<binary.length();i++){
                if(index%m==p-1){
                    sb.append(charArr[i]);
                    // 0 1 1 0 1 1 1 0 0
                }
                index++;
                if(index>(t-1)*m+p-1)
                    break;
            }
            if(index>(t-1)*m+p-1)
                    break;
        }
        
        return sb.toString();
    }
}