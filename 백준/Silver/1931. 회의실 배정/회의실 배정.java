import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];


        for(int i=0;i<n;i++){ //시간복잡도 : O(N)
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings, new Comparator<Meeting>() { // 시간복잡도 : O(NlogN)
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end==o2.end)
                    return o1.start-o2.start;

                return o1.end-o2.end;
            }
        });

        Integer[] meetingCount = new Integer[n];

            int count =1;
            int initTime = meetings[0].end;
            for(int j=1;j<n;j++){
                if(meetings[j].start>=initTime){
                    count++;
                    initTime = meetings[j].end;
                }
            }


        System.out.println(count);
    }
}

class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
