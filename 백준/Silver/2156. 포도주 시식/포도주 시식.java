
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cups = new int[n];
        for(int i=0;i<n;i++){
            cups[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxDrink(cups));
    }

    private static long getMaxDrink(int[] cups) {
        int n = cups.length;
        if(n==1)
            return cups[0];

        if(n==2)
            return cups[0]+cups[1];

        int[][] maxDrink = new int[n][2];
        maxDrink[0][0] = cups[0];
        maxDrink[1][0] = cups[0]+cups[1];
        maxDrink[1][1] = cups[0];

        for(int i=2;i<n;i++){
            maxDrink[i][0] = Math.max(cups[i]+maxDrink[i-1][1],cups[i]+maxDrink[i-2][1]+cups[i-1]);
            maxDrink[i][1] = Math.max(maxDrink[i-1][1],maxDrink[i-1][0]);
        }

//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(maxDrink[i]));
//        }

        return Math.max(maxDrink[n-1][0],maxDrink[n-1][1]);
    }
}
