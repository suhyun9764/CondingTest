class Solution {
        static int count = 0;
        public int solution(int[] numbers, int target) {
            dfs(0,numbers,target,0);
            return count;
        }

        private void dfs(int current, int[] numbers, int target, int sum) {
            if(current== numbers.length){
                if(sum==target)
                    count++;

                return;
            }

            dfs(current+1,numbers,target,sum-numbers[current]);
            dfs(current+1,numbers,target,sum+numbers[current]);
        }
    }