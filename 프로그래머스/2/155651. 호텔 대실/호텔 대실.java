import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time,(a,b)->{
            if(a[0]==b[0])
                return a[1].compareTo(b[1]);
            
            return a[0].compareTo(b[0]);
        });
        
        int result = 1;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for(String[] books : book_time){
            String endTime = books[1];
            int hour = Integer.parseInt(endTime.split(":")[0]);
            int minute = Integer.parseInt(endTime.split(":")[1]);
            int endMinute = 60*hour+minute;
            
            String startTime = books[0];
            int sHour = Integer.parseInt(startTime.split(":")[0]);
            int sMinute = Integer.parseInt(startTime.split(":")[1]);
            int startMinute = 60*sHour+sMinute;
            
            if(!pq.isEmpty()){
                int before = pq.peek();
                System.out.println(before);
                if(before+10>startMinute){
                    result++;
                }
                else{
                    pq.poll();
                }
            }
            
            pq.add(endMinute);
         
        }
        
        
        return result;
    }
}