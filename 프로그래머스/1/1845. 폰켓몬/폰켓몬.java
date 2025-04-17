import java.util.HashSet;
import java.util.Set;

class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int n = nums.length/2;
            if(n>=set.size())
                return set.size();

            return n;
        }
    }