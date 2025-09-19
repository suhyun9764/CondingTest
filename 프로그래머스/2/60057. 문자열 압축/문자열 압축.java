class Solution {
        public int solution(String s) {
            int min = s.length();
            for(int n=1;n<=s.length()/2;n++){
                // n자리수 만큼 끊어서 연속되는게 있다면 압축하여 만들기
                min = Math.min(min,strZip(s,n));
            }

            return min;
        }

        private int strZip(String s, int n) {
            char[] charArray = s.toCharArray();


            String before = s.substring(0,n);
            StringBuilder sb = new StringBuilder();
            int cont = 1;
            int nextI = 1;
            for(int i=n;i+n-1<charArray.length;i+=n){
                nextI = i+n;
                String cur = s.substring(i,i+n);
                if(before.equals(cur)){
                    cont++;
                    continue;
                }

                if(cont==1)
                    sb.append(before);
                else{
                    sb.append(cont).append(before);
                }

                cont = 1;
                before = cur;
            }

            if(cont==1)
                sb.append(before);
            else{
                sb.append(cont).append(before);
            }

            if(nextI<s.length())
                sb.append(s.substring(nextI));



            return sb.length();
        }
    }