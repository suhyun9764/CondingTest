import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b],cost);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j],dist[i][j]);
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j]==Integer.MAX_VALUE)
                    System.out.print(0);
                else
                    System.out.print(dist[i][j]);

                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
