class Solution {
    static int zeroCount = 0;
    static int changeCount = 0;
    static String s;
    public int[] solution(String s) {
        this.s = s;
        while(!this.s.equals("1")){
            change();
            changeCount++;
        }
        
        return new int[]{changeCount,zeroCount};
    }
    
     void change(){
        StringBuilder sb = new StringBuilder();
        char[] charArr = this.s.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]=='0') {
                zeroCount++;
                continue;
            }
            sb.append(charArr[i]);
        }
        this.s = Integer.toBinaryString(sb.toString().length());
    }
}