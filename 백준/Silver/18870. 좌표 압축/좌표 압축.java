import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] orderNum = new int[n];


        Set<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){ // 시간복잡도 : O(NlogN)
            int val = Integer.parseInt(st.nextToken());
            orderNum[i] = val;
            set.add(val); //시간복잡도 : O(logN)
        }

        Map<Integer,Integer> map = new HashMap<>();
        int v = 0;
        for(int x : set){ //시간복잡도 : O(N)
            map.put(x,v++);
        }

        for(int i=0;i<n;i++){ 
            bw.write(map.get(orderNum[i])+" ");
        }

        bw.flush(); // 총 시간복잡도 : O(NlogN)

        /* 시간초과 
        Map<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){ //시간복잡도 : O(nlogn)
            int num = Integer.parseInt(st.nextToken());
            set.add(num); O(log n)
            map.put(i,num);O(1)
        }
        Integer[] compareArr = set.toArray(new Integer[set.size()]);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){ // 시간복잡도 : O(n^2)
            int key=entry.getKey();
            for(int i=0;i< compareArr.length;i++){
                if(entry.getValue().equals(compareArr[i]))
                    map.put(key,i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            bw.write(map.get(i)+" ");
        }

        bw.flush(); // 총 시간복잡도 : O(n^2)

 */

    }

}
