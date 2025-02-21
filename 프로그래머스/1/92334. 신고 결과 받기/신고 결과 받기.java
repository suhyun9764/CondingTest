import java.util.*;  

class Solution {
        static Map<String,Integer> ids = new HashMap<>();
        static int[] reported;
        static Set<Integer>[] reportList;
        static int[] answer;
        public int[] solution(String[] id_list, String[] report, int k) {
            // 1. 아이디들을 맵에 인덱스와 함께 저장하기
            int idx = 0;
            for (String id : id_list) {
                ids.put(id, idx++);
            }

            reported = new int[idx];
            reportList = new Set[idx];
            for(int i=0;i< reportList.length;i++){
                reportList[i] = new HashSet<>();
            }
            answer = new int[idx];
            // 2. 신고 내역 순회
            for (String eachReport : report) {
                // 신고자와 피신고자 이름 분리
                String[] names = eachReport.split(" ");
                // 신고자와 피신고자 인덱스 가져오기
                int reporterIdx = ids.get(names[0]);
                int reportedIdx = ids.get(names[1]);
                // 만약 같은 사람이 신고한 전적이 있으면 스킵
                if(reportList[reporterIdx]!=null&&reportList[reporterIdx].contains(reportedIdx))
                    continue;
                //  repotred배열에 피신고자 인덱스 자리에 +1
                reported[reportedIdx]++;
                // reportList에 신고자 인덱스 자리에 피신고자 인덱스 넣기
                reportList[reporterIdx].add(reportedIdx);
            }

            // 3. 이용정지 당하는 유저 구하기
            List<Integer> suspendUsers = new ArrayList<>();
            for (int i=0;i<reported.length;i++) {
                if(reported[i]>=k)
                    suspendUsers.add(i);
            }

            for (int i=0;i<reportList.length;i++) {
                int cnt = 0;
                for (int suspendUser : suspendUsers) {
                    if(reportList[i].contains(suspendUser))
                        cnt++;
                }
                answer[i] = cnt;
            }
            return answer;
        }
    }