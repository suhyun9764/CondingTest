import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 종류
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Sushi> menu  = new LinkedList<>();
        int[] sushiCheck = new int[d+1];
        for(int i=0;i<k;i++){
            Sushi sushi = new Sushi(arr[i]);
            if(sushiCheck[arr[i]]!=0)
                sushiCheck[arr[i]]++;
            else {
                sushiCheck[arr[i]]++;
                menu.add(sushi);
            }
        }

        int max = menu.size();
        if(sushiCheck[c]==0)
            max++;
        for(int i=1;i<arr.length;i++){
            int newSushi = i+k-1;
            int oldSushi = i-1;
            if(newSushi>arr.length-1){
                newSushi-=arr.length;
            }

                if(sushiCheck[arr[oldSushi]]<2) {
                    if(menu.size()>0)
                        menu.remove(0);
                }
                sushiCheck[arr[oldSushi]]--;
                Sushi sushi = new Sushi(arr[newSushi]);
                if(sushiCheck[arr[newSushi]]==0){
                    menu.add(sushi);
                }
                sushiCheck[arr[newSushi]]++;


            int buf =menu.size();
            if(sushiCheck[c]==0) {
                buf = menu.size()+1;
            }

            max = Math.max(max,buf);



        }

        System.out.println(max);

    }
    public static class Sushi{
        int sushiNum;

        public Sushi(int sushiNum) {
            this.sushiNum = sushiNum;
        }
    }

}

