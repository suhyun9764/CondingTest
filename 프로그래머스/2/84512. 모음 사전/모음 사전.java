class Solution {
        static char[] array = {'A','E','I','O','U'};
        static String target;
        static int answer = 0;
        StringBuilder sb = new StringBuilder();
        public int solution(String word) {
            target = word;
            dfs(0,0,sb);
            return answer;

        }

        int dfs(int depth, int currentOrder, StringBuilder sb){
            if(depth==5)
                return currentOrder;

            for(int i=0;i<array.length;i++){
                if(answer!=0)
                    return currentOrder;

                sb.append(array[i]);
                currentOrder++;
                if(sb.toString().equals(target)){
                    answer = currentOrder;
                    break;
                }
                currentOrder = dfs(depth+1,currentOrder,sb);
                sb.deleteCharAt(sb.length()-1);
            }

            return currentOrder;
        }
    }