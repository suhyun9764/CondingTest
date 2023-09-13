import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();
        int wCnt = 0;
        int bCnt = 0;
        int max =0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            while (end<arr.length){
                if(arr[end]=='B') bCnt++; // 마주친 돌의 색이 검은색일 때
                else wCnt++;    // 마주친 돌의 색이 흰색일 때

                if(end==arr.length-1){
                    if(wCnt>=w&&bCnt<=b){
                        int currentLength = end-i+1;
                        max = Math.max(currentLength,max);
                        break;
                    }else
                        break;
                }else{
                    if(bCnt<b){ // 검은색 돌의 갯수가 아직 b보다 작을 떄
                        if(wCnt>=w){
                            int currentLength = end-i+1;
                            max = Math.max(currentLength,max);
                        }
                        end++;
                    }else if(bCnt==b){ // 검은색 돌의 갯수가 b와 같을 때
                        if(arr[end+1]=='B'){ // 다음 돌의 색깔이 검은색일 때(끝)
                            if(wCnt>=w){
                                int currentLength = end-i+1;
                                max = Math.max(currentLength,max);
                                end++;
                                break;
                            }else{
                                end++;
                                break;
                            }
                        }else{  // 다음 돌의 샊깔이 흰색일 때
                            end++;
                        }
                    }
                    else{
                        end++;
                        break;
                    }
                }

            }
            if(arr[i]=='B') bCnt--;
            else wCnt--;
        }

        System.out.println(max);

    }
}
