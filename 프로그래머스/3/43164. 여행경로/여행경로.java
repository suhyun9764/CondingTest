import java.util.*;

class Solution {
    String[][] tickets;
    int n;
    boolean[] visit;
    String[] answer;
    boolean find = false;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.n = tickets.length;
        this.visit = new boolean[n];
        this.answer = new String[n+1];
        answer[0] = "ICN";
        Arrays.sort(tickets,(a,b)->{
           if(a[0].equals(b[0]))
               return a[1].compareTo(b[1]);
            
            return a[0].compareTo(b[0]);
        });

        
        dfs("ICN",1);
        return answer;
    }
    
    private void dfs(String d, int depth){
        if(depth==n+1){
            find = true;
            return;
        }
        
        int start = getStart(d);
        
        int end = getEnd(d);
        // System.out.println("start : "+start+", end : "+end);
        for(int i=start;i<end;i++){
            if(visit[i]) continue;
            visit[i] = true;
            answer[depth] = tickets[i][1];
            dfs(tickets[i][1],depth+1);
            visit[i] = false;
            if(find) break;
        }
    }
    
    private int getStart(String departure){
        int l = 0;
        int r = n;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(tickets[mid][0].compareTo(departure)>=0) r = mid-1;
            else l = mid+1;
        }
        
        return l;
    }
    
    private int getEnd(String departure){
        int l = 0;
        int r = n;
        
        while(l<r){
            int mid = (l+r)/2;
            
            if(tickets[mid][0].compareTo(departure)>0) r = mid;
            else l = mid+1;
        }
        
        return l;
    }
    
}