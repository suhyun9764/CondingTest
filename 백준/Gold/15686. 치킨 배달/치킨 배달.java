import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static final int HOUSE = 1;
    static final int CHICKEN = 2;
    static int N,M;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int cur = Integer.parseInt(st.nextToken());
                int[] curLocation = {i, j};
                if(cur==HOUSE) house.add(curLocation);
                if(cur==CHICKEN) chicken.add(curLocation);
            }
        }

        int[] selected = new int[M];
        Arrays.fill(selected,-1);
        dfs(0,0, selected);

        System.out.println(answer);
    }

    private static void dfs(int chickenIndex, int depth, int[] selected) {
        if(depth==M){
            getCityChikenLength(selected);
            return;
        }

        if(chickenIndex==chicken.size())
            return;

        selected[depth] = chickenIndex;
        dfs(chickenIndex+1,depth+1,selected);
        selected[depth] = -1;
        dfs(chickenIndex+1,depth,selected);
    }

    private static void getCityChikenLength(int[] selected) {
        int total = 0;
        for(int[] curHouse : house){
            int min = Integer.MAX_VALUE;
            for(int i=0;i<selected.length;i++){
                int[] curChicken = chicken.get(selected[i]);
                int length = Math.abs(curChicken[0]-curHouse[0])+Math.abs(curChicken[1]-curHouse[1]);
                min = Math.min(min,length);
            }

            total+=min;
        }

        answer=Math.min(total,answer);
    }
}
