import java.util.*;

class Solution {
        public String[] solution(String[] files) {
            Queue<File> pq = new PriorityQueue<>();
            for(int i=0;i<files.length;i++){
                pq.add(new File(files[i],i));
            }
            String[] answer = new String[files.length];
            for(int i=0;i<answer.length;i++){
                File file = pq.poll();
                answer[i] = file.fullName;
            }

            return answer;

        }
    }

    class File implements Comparable<File>{
        String fullName;
        String head;
        int number;
        int order;

        public File(String fullName, int order){
            this.fullName = fullName;
            this.order = order;
            // head, number, tail 나누기
            parsingFromFullName(fullName);
        }

        public void parsingFromFullName(String fullName){

            StringBuilder sb = new StringBuilder();
            char[] arr = fullName.toCharArray();

            // head
            int i=0;
            while(i<fullName.length()&&!Character.isDigit(arr[i])){
                sb.append(arr[i++]);
            }
            this.head = sb.toString().toLowerCase();
            sb.setLength(0);
            // number
            int numLength = 0;
            while(i<fullName.length()&&Character.isDigit(arr[i])&&numLength<5){
                sb.append(arr[i++]);
                numLength++;
            }
            this.number = Integer.parseInt(sb.toString());

        }

        public int compareTo(File o){
            if(this.head.equals(o.head)){
                if(this.number==o.number){
                    return this.order-o.order;
                }
                return this.number-o.number;
            }

            return this.head.compareTo(o.head);
        }
    }