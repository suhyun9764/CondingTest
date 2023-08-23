
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로길이
        int m = Integer.parseInt(st.nextToken()); // 가로길이
        int t = Integer.parseInt(st.nextToken()); // 시간

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 주위의 기준
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr = new int[n+2*k][m+2*k];
        for(int i=k;i<n+k;i++){
            st = new StringTokenizer(br.readLine());
            char[] buf = st.nextToken().toCharArray();
            for(int j=k;j<m+k;j++){
                if(buf[j-k]=='*')
                    arr[i][j] = 1;
                else
                    arr[i][j] = 0;
            }
        }


        int[][] sumArr = new int[n+2*k][m+2*k];
        for(int i=0;i<t;i++){
            sumArr = getSumArr(n,m,k);
            ArrayList<NextArr> nextArrs = new ArrayList<>();
            getResult(n,m,k, sumArr,a,b,nextArrs);
            for(int j=0;j<nextArrs.size();j++){
                int nextI = nextArrs.get(j).getI();
                int nextJ = nextArrs.get(j).getJ();
                int val = nextArrs.get(j).getVal();
                arr[nextI][nextJ] = val;
            }
        }
        for(int i = k; i< n + k; i++){
            for(int j = k; j< m + k; j++){
                if(arr[i][j]==1)
                    bw.write("*");
                else
                    bw.write(".");
            }
            bw.write("\n");
        }

        bw.flush();

    }

    private static int[][] getSumArr(int n, int m, int k) {
        int[][] sumArr = new int[n+2*k][m+2*k];
        for(int i = k; i< n + 2*k; i++){
            for(int j = k; j< m + 2*k; j++){
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1]+arr[i][j]- sumArr[i-1][j-1];
            }
        }

        return sumArr;
    }

    static void getResult(int n, int m, int k, int[][] sumArr,int a, int b, ArrayList<NextArr> nextArrs){

        for(int i = k; i< n + k; i++){
            for(int j = k; j< m + k; j++){
                int arround =0;
                if(i-k-1>=0&&j-k-1>=0) {
                    arround = sumArr[i + k][j + k] - sumArr[i + k][j - k - 1] - sumArr[i - k - 1][j + k] + sumArr[i - k - 1][j - k - 1] - arr[i][j];
                }else if(i-k-1>=0&&j-k-1<0){
                    arround = sumArr[i + k][j + k] - sumArr[i - k - 1][j + k]  - arr[i][j];
                }else if(i-k-1<0&&j-k-1>=0){
                    arround = sumArr[i + k][j + k] - sumArr[i + k][j - k - 1]  - arr[i][j];
                }else{
                    arround = sumArr[i + k][j + k] - arr[i][j];
                }

                if(arr[i][j]==1){
                    if(arround>=a&&arround<=b)
                        ;
                    else if(arround<a)
                        nextArrs.add(new NextArr(i,j,0));
                    else if(arround>b)
                        nextArrs.add(new NextArr(i,j,0));
                }else{
                    if(arround>a&&arround<=b)
                        nextArrs.add(new NextArr(i,j,1));
                }
            }
        }
    }

    static class NextArr{
        int i;
        int j;

        int val;

        public NextArr(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getVal() {
            return val;
        }
    }

}
