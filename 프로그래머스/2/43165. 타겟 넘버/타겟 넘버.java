class Solution {
        static int count=0;
        public int solution(int[] numbers, int target) {
            dfs(0,numbers,target,0);
            return count;
        }

        private void dfs(int i, int[] numbers, int target,int sum) {
            if(i==numbers.length){
                if(sum==target){
                    count++;
                }
                return;
            }
            int current = numbers[i];
            dfs(i+1,numbers,target,sum+current);
            dfs(i+1,numbers,target,sum-current);
        }
    }