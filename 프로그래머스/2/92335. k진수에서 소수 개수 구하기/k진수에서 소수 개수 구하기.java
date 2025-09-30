import java.util.*;

class Solution {
        public int solution(int n, int k) {
            char[] charArray = Integer.toString(n, k).toCharArray();
            List<String> formations = getFormations(charArray);

            int answer = 0;
            for(String formation : formations){
                if(isPrime(Long.parseLong(formation)))
                    answer++;
            }

            return answer;
        }

        private static List<String> getFormations(char[] charArray) {
            List<String> formations = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< charArray.length; i++){
                if(charArray[i]=='0'){
                    if(sb.length()>0){
                        formations.add(sb.toString());
                        sb.setLength(0);
                    }

                    continue;
                }

                sb.append(charArray[i]);
                if(i== charArray.length-1){
                    formations.add(sb.toString());
                }
            }
            return formations;
        }

        private boolean isPrime(long n) {
            if(n==1) return false;
            if(n==2) return true;
            if(n==3) return true;

            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0) return false;
            }

            return true;
        }
    }