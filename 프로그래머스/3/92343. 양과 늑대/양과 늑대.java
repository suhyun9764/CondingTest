import java.util.ArrayList;
import java.util.List;

class Solution {
        static int[] parents;
        static int max = 0;
        static int[] myInfo;
        static List<Integer>[] children;
        public int solution(int[] info, int[][] edges) {
            myInfo = info;
            parents = new int[info.length+1];
            children = new List[edges.length+1];
            for(int i=0;i<edges.length+1;i++){
                children[i] = new ArrayList<>();
            }

            for(int i=0;i<edges.length;i++){
                int[] edge = edges[i];
                int parent = edge[0];
                int child = edge[1];
                parents[child] = parent;
                children[parent].add(child);
            }


            List<Integer> nexts = new ArrayList<>();
            nexts.add(0);
            dfs(0,0,0,nexts);
            return max;

        }

        private static void dfs(int current, int sheep, int wolf, List<Integer> nexts) {
            if(myInfo[current]==0)
                sheep++;
            else
                wolf++;

            if(wolf >= sheep) return;

            max = Math.max(max, sheep);

            List<Integer> copiedNexts = new ArrayList<>(nexts); // ⭐ 상태 복사
            copiedNexts.remove(Integer.valueOf(current));
            copiedNexts.addAll(children[current]);

            for (Integer next : copiedNexts) {
                dfs(next, sheep, wolf, copiedNexts); // 🔁 복사본 넘김
            }
        }

    }