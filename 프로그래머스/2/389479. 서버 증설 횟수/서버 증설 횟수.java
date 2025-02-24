class Solution {
        public int solution(int[] players, int m, int k) {
            // 1. availablePlayerNumber[] 생성
            int[] currentServer = new int[24];
            // 2. players[] 순회
            int answer = 0;
            for (int t=0;t<24;t++){
                int currentPlayerNumber = players[t];
                if(currentPlayerNumber<(currentServer[t]+1)*m) continue;
                // 3. 만약 현재 시간의 수용가능한 인원보다 많다면 서버증설 후 카운트++


                // 4. 증설하고 현재포함 현재+K-1칸 만큼 수용가능한인원 업데이트
                int needServer = currentPlayerNumber/m-currentServer[t];


                for(int i=t;i<t+k;i++){
                    if(i>23)
                        break;
                    currentServer[i] += needServer;
                }

                answer += needServer;
            }

            return answer;
        }
    }