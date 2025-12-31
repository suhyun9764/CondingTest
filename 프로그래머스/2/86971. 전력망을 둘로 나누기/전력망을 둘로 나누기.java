import java.util.*;

class Solution {
      Map<Integer,List<Integer>> nodes = new HashMap<>();
    public int solution(int n, int[][] wires) {
     
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            if(!nodes.containsKey(a)){
                nodes.put(a,new ArrayList<>());
            }
            
            if(!nodes.containsKey(b)){
                nodes.put(b,new ArrayList<>());
            }
            
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        
        for(int i=0;i<wires.length;i++){
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            visited[cutA] = true;
            int aNodes = dfs(cutA,visited,cutB);
            visited[cutB] = true;
            int bNodes = dfs(cutB,visited,cutA);
            
            answer= Math.min(answer,Math.abs(aNodes-bNodes));
            
        }
        
        return answer;
    }
    
    public int dfs(int target, boolean[] visited,int com){
        List<Integer> children = nodes.get(target);
        int total = 1;
        for(int child : children){
            if(child==com) continue;
            if(visited[child]) continue;
            visited[child] = true;
            total+=dfs(child,visited,com);
        }
        
        return total;
    }
}