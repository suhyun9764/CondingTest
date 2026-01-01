import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List[] nodes = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            nodes[a].add(b);
            nodes[b].add(a);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n+1];
        queue.add(new int[]{1,0});
        visit[1] = true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int max = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0];
            int coast = cur[1];
            max = Math.max(max,coast);
            
            if(!map.containsKey(coast))
                map.put(coast,new ArrayList<>());
            map.get(coast).add(node);
            
            List<Integer> myNodes = nodes[node];
            for(int myNode : myNodes){
                if(visit[myNode]) continue;
                queue.add(new int[]{myNode,coast+1});
                visit[myNode] = true;
            }
            
        }
        
        return map.get(max).size();
    }
}