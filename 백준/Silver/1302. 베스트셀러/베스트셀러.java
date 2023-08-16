import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String bookName = br.readLine();
            if(map.get(bookName)==null){
                map.put(bookName,1);
            }else{
                int val= map.get(bookName);
                map.replace(bookName,val+1);
            }
        }
        List<String> list = new ArrayList<>();
        int max = Collections.max(map.values());
        for(String maxName : map.keySet()){
            if(map.get(maxName).equals(max))
                list.add(maxName);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.stream().findFirst().get());

    }
}
