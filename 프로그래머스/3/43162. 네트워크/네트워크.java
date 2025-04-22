class Solution {
        static boolean[] visit;
        static int answer=0;
        public int solution(int n, int[][] computers) {
            visit = new boolean[computers.length];
            for(int i=0;i<computers.length;i++){
                if(visit[i]) continue;
                dfs(i,computers);
                answer++;
            }
            return answer;
        }

        private void dfs(int i,int[][] computers) {
            visit[i] = true;
            int[] myComputers = computers[i];
            for(int c=0;c<computers.length;c++){
                if(c==i) continue;
                if(myComputers[c]==0)continue;
                if(visit[c])continue;
                dfs(c,computers);
            }
        }
    }