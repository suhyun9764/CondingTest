import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<Integer,Integer> howMap = new HashMap<>();
        Map<Integer,Integer> checkMap = new HashMap<>();
        Integer[] sortedArr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        int order =0;

        for(int i=0;i<n;i++){ // 시간복잡도 : O(n)
            int val = Integer.parseInt(st.nextToken());
            if(!checkMap.containsKey(val)) {
                checkMap.put(val,++order);
            }
            sortedArr[i] = val;
            howMap.put(val,howMap.getOrDefault(val,0)+1);
        }

        Arrays.sort(sortedArr, new Comparator<Integer>() { // 시간복잡도 : O(NlogN)
            @Override
            public int compare(Integer o1, Integer o2) {
                if(howMap.get(o1)==howMap.get(o2)){
                    return checkMap.get(o1)-checkMap.get(o2);
                }else
                    return howMap.get(o2)-howMap.get(o1);
            }
        });


        for(int i=0;i<n;i++){
            bw.write(sortedArr[i]+" ");
        }

        bw.flush(); // 전체 시간복잡도 : O(NlogN)
    }
}
