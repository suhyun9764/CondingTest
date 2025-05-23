class Solution {
        public String solution(String s) {
            char[] charArr = s.toCharArray();
            char before = ' ';
            for(int i=0;i<charArr.length;i++){
                // 앞이 숫자이거나 빈칸인 경우
                if(before==' '){
                    // 현재가 숫자인 경우
                    before = charArr[i];
                    if(charArr[i]>'z'||charArr[i]<'A'||charArr[i]==' '){
                        continue;
                    }

                    // 현재가 소문자인 경우
                    if('a'<=charArr[i]&& charArr[i]<='z'){
                        charArr[i] = (char)(charArr[i] + ('A'-'a'));
                    }
                    before = charArr[i];
                }
                // 아닌 경우
                else{
                    // 현재가 숫자나 빈칸인 경우
                    if(charArr[i]>'z'||charArr[i]<'A'||charArr[i]==' '){
                        before = ' ';
                        continue;
                    }
                    // 현재가 대문자인 경우
                    if('A'<=charArr[i]&& charArr[i]<='Z'){
                        charArr[i] = (char)(charArr[i] - ('A'-'a'));
                    }
                    before = charArr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<charArr.length;i++){
                sb.append(charArr[i]);
            }
            return sb.toString();
        }
    }