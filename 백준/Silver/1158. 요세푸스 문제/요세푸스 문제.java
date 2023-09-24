import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for(int i=1;i<n+1;i++){
            list.add(i);
        }
      

        int preIdx = 0;
        bw.write("<");
        for(int i=0;i<n;i++){
            int currentIdx = preIdx+k-1;
            if(currentIdx>=list.size()) {
                while (currentIdx>=list.size()){
                    currentIdx-=list.size();
                }
            }
            preIdx = currentIdx;
            bw.write(list.remove(currentIdx)+"");
            if(i<n-1) bw.write(", ");
        }
        bw.write(">");
        bw.flush();
    }
}
