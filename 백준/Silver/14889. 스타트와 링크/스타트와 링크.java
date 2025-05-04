import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] powerMap;
    static int diffMin = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        init();
        boolean[] select = new boolean[N+1];
        dfs(1,0,select);
        System.out.println(diffMin);
    }

    private static void dfs(int currentMember, int selectNum, boolean[] select) {
        if(currentMember>N){
            return;
        }

        if(selectNum==N/2){
            int diff = calculate(select);
            diffMin = Math.min(diffMin,diff);
            return;
        }

        select[currentMember] = true;
        dfs(currentMember+1,selectNum+1,select);
        select[currentMember] = false;
        dfs(currentMember+1,selectNum,select);
    }

    private static int calculate(boolean[] select) {
        int selectedTeamPower = 0;
        int unSelectedTeamPower = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(select[i]&&select[j]) {
                    selectedTeamPower += powerMap[i][j];
                }else if(!select[i]&&!select[j]){
                    unSelectedTeamPower +=powerMap[i][j];
                }
            }
        }

        return Math.abs(selectedTeamPower-unSelectedTeamPower);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        powerMap = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int power = Integer.parseInt(st.nextToken());
                powerMap[i][j] = power;
            }
        }
    }
}
