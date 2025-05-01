class Solution {
        static char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        static int answer;
        static String[] data;
        static boolean[] visit = new boolean[8];
        public int solution(int n, String[] data) {
            answer = 0;
            Solution.data = data;
            dfs("",0);
            return answer;
        }

        private void dfs(String line, int depth) {
            if(depth==8){
                if(isValid(line))
                    answer++;

                return;
            }


            for(int i=0;i<8;i++){
                if(visit[i]) continue;
                visit[i] = true;
                dfs(line+members[i],depth+1);
                visit[i] = false;
            }
        }

        private boolean isValid(String line) {
            boolean result = true;
            for (String eachData : data) {
                char a = eachData.charAt(0);
                char b = eachData.charAt(2);
                char compare = eachData.charAt(3);
                int num = Integer.parseInt(String.valueOf(eachData.charAt(4)));

                int aIndex = line.indexOf(a);
                int bIndex = line.indexOf(b);
                int gap = Math.abs(aIndex-bIndex)-1;

                switch (compare){
                    case '=' :
                        if(gap!=num)
                            result = false;
                        break;
                    case '>' :
                        if(gap<=num)
                            result = false;
                        break;
                    case '<' :
                        if(gap>=num)
                            result = false;
                        break;
                }

                if(!result)
                    break;
            }

            return result;

        }
    }