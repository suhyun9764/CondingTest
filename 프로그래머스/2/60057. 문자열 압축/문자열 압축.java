class Solution {

        int answer = Integer.MAX_VALUE;
        public int solution(String s) {
            // 배열로 만들기
            // 2개단위~s의길이/2만큼 순회하며 가장 짧은 문자열 구하기
            if(s.length()==1)
                return 1;
            for(int i=1;i<=s.length()/2;i++){
                String compressResult = compress(s, i);
                answer = Math.min(answer,compressResult.length());
            }
            return answer;
        }

        private String compress(String s, int size) {
            int left = size;
            int right = left+size;

            String before = s.substring(0,size);
            StringBuilder sb = new StringBuilder();
            int repeatCnt = 1;
            while (right<=s.length()){
                String cur = s.substring(left,right);
                left += size;
                right+=size;
                if(before.equals(cur)){
                    repeatCnt++;
                    continue;
                }
                if(repeatCnt!=1)
                    sb.append(repeatCnt);
                sb.append(before);
                before = cur;
                repeatCnt=1;
            }

            if(left>=s.length()){
                if(repeatCnt!=1)
                    sb.append(repeatCnt);
                sb.append(before);
                return sb.toString();
            }

            if(repeatCnt!=1)
                sb.append(repeatCnt);
            sb.append(before);
            sb.append(s.substring(left));
            return sb.toString();
        }
    }