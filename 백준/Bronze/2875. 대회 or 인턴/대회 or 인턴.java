import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int needFemaleNum = 2;
    private static int needMaleNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int onlyFemale = n / needFemaleNum;
        int onlyMale = m / needMaleNum;

        int creatableTeamNum = Math.min(onlyMale, onlyFemale);
        int remainFemale = n - (creatableTeamNum * needFemaleNum);
        int remainMale = m - (creatableTeamNum * needMaleNum);

        int totalRemain = remainFemale + remainMale;

        while (totalRemain < k && creatableTeamNum > 0) {
            creatableTeamNum -= 1;
            totalRemain += 3;
        }

        System.out.println(creatableTeamNum);


    }
}
