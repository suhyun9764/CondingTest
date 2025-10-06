import java.util.*;

class Solution {
        Map<Integer, List<Integer>> childMap = new HashMap<>();
        Map<Integer, List<Integer>> parentMap = new HashMap<>();

        int[] answer = new int[4];

        public int[] solution(int[][] edges) {
            for(int[] edge : edges){
                int parent = edge[0];
                int child = edge[1];

                childMap.putIfAbsent(parent,new ArrayList<>());
                childMap.get(parent).add(child);

                parentMap.putIfAbsent(child,new ArrayList<>());
                parentMap.get(child).add(parent);
            }

            int root = findRoot();
            answer[0] = root;
            List<Integer> children = childMap.get(root);
            Set<Integer> visited = new HashSet<>();
            visited.add(root);
            for(int child : children){
                if(visited.contains(child))continue;
                visited.add(child);
                int[] result = dfs(child,visited,new int[]{0,0});
                processResult(result);
            }
            return answer;
        }

        private void processResult(int[] result) {
            int edgeCnt = result[0];
            int lineCnt = result[1];
            if(edgeCnt==lineCnt){
                answer[1]++;
                return;
            }

            if(edgeCnt-1==lineCnt){
                answer[2]++;
                return;
            }

            answer[3]++;
        }

        private int[] dfs(int curNode, Set<Integer> visited, int[] result) {
           result[0]++;
            List<Integer> children = null;
            if(childMap.containsKey(curNode)){
                result[1]+=childMap.get(curNode).size();
                children = childMap.get(curNode);
            }


            boolean canMove = false;
            if(children!=null){
                for(int i=0;i<children.size();i++){
                    int curChild = children.get(i);
                    if(visited.contains(curChild)) continue;
                    visited.add(curChild);
                    canMove = true;
                    dfs(curChild,visited,result);
                }
            }
            

            return result;
        }

        private int findRoot() {
            int maxOut = 0;
            int result = 0;
            for (Integer parent : childMap.keySet()) {
                if(!parentMap.containsKey(parent)){
                    if(childMap.get(parent).size()>=2&&!parentMap.containsKey(parent))
                        result = parent;
                }
            }
            return result;
        }

    }