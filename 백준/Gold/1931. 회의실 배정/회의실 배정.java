import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. N과 각각의 회의실 정보 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetings[i][0] = startTime;
            meetings[i][1] = endTime;
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });
        int availableStartTime = 0;
        int num = 0;
        for (int i = 0; i < N; i++) {
            int[] currentMeeting = meetings[i];
            int startTime = currentMeeting[0];
            int endTime = currentMeeting[1];

            if(availableStartTime<=startTime){
                num++;
                availableStartTime=endTime;
            }
        }

        System.out.println(num);
    }
}
