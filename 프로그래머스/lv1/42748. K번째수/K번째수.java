import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] buf =new int[3];
            for(int j=0;j<3;j++){
                buf[j] = commands[i][j];
            }
            int[] spectrumArr = new int[buf[1]-buf[0]+1];
            int num =0;
            for(int t=buf[0];t<buf[1]+1;t++){
                spectrumArr[num] = array[t-1];
                num++;
            }
            Arrays.sort(spectrumArr);
            answer[i]=spectrumArr[buf[2]-1];
        }
        return answer;
    }
}