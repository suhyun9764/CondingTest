// import java.util.*;

// class Solution {
//     public long solution(int n, int[] works) {
//         // 우선순위큐(reverseOrder)에 작업저장
//         Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
//         for(int work : works){
//             queue.add(work);
//         }
//         // n번만큼 순회
//         while(n>0){
//             int currentWork = queue.poll();
//             if(currentWork==0) break;
//             int nextWork = queue.peek();
//             int diff = 0;
//             if(currentWork==nextWork){
//                 diff =Math.min(n,1);
//             }else{
//                 diff = Math.min(n,currentWork-nextWork);
//             }
//             queue.add(currentWork-diff);
//             n-=diff;
//         }
//         // for(int i=0;i<n;){
//         //     int currentWork = queue.poll();
//         //     // 큐에서 poll후 해당값 -1(0인 경우는 무시)
//         //     if(currentWork==0) break;
//         //     int nextWork = queue.peek();
//         //     int diff = 0;
//         //     if(currentWork==nextWork){
//         //         diff =Math.min(n-i,1);
//         //     }else{
//         //         diff = Math.min(n-i,currentWork-nextWork);
//         //     }
//         //     // 다시 큐에 넣기
//         //     queue.add(currentWork-diff);
//         //     i+=diff;
//         // }
//         int answer = 0;
//         // 순회 종료 후 큐에남은것이 없을 떄까지 poll후 해당값 제곱하여 answer에 더하기
//         while(!queue.isEmpty()){
//             int currentWork = queue.poll();
//             answer += currentWork*currentWork;
//         }
//         return answer;
     
//     }
// }

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.add(work);
        }

        while (n > 0 && !queue.isEmpty()) {
            int work = queue.poll();
            if (work == 0) break;

            queue.add(work - 1);
            n--;
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            int work = queue.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
