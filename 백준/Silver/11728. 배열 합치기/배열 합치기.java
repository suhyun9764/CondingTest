import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int pointA = 0;
        int pointB = 0;

        while (pointA<n&&pointB<m){
            if(arrA[pointA]<arrB[pointB]){
                bw.write(arrA[pointA++]+" ");
            }else{
                bw.write(arrB[pointB++]+" ");
            }
        }

        if(pointA<n){
            for(int i=pointA;i<n;i++){
                bw.write(arrA[pointA++]+" ");
            }
        }else if(pointB<m){
            for(int i=pointB;i<m;i++){
                bw.write(arrB[pointB++]+" ");
            }
        }
        bw.flush();
    }
}
