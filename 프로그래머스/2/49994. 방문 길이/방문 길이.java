import java.util.*;

class Solution {
        static Set<String> set = new HashSet<>();
        static int X = 0;
        static int Y = 0;
        public int solution(String dirs) {
            // 1. 디렉션 나누기
            char[] charDirs = dirs.toCharArray();
            // 2. 디렉션별로 수행
            for(char direction : charDirs){
                executeDirection(direction);
            }
            int answer = set.size()/2;
            return answer;
        }

        void executeDirection(char direction){
            // 벡터값을 문자열로 저장 ex : (0,0) -> (1,0) = 0010
            switch(direction){
                case 'U':
                    if(Y+1<=5){
                        record(X,Y+1);
                        Y++;
                    }
                    break;
                case 'D':
                    if(Y-1>=-5){
                        record(X,Y-1);
                        Y--;
                    }
                    break;
                case 'R':
                    if(X+1<=5){
                        record(X+1,Y);
                        X++;
                    }
                    break;
                case 'L' :
                    if(X-1>=-5){
                        record(X-1,Y);
                        X--;
                    }
            }
        }

        private void record(int x, int y) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(X);
            sb1.append(Y);
            sb1.append(x);
            sb1.append(y);
            set.add(sb1.toString());

            StringBuilder sb2 = new StringBuilder();
            sb2.append(x);
            sb2.append(y);
            sb2.append(X);
            sb2.append(Y);
            set.add(sb2.toString());
        }
    }