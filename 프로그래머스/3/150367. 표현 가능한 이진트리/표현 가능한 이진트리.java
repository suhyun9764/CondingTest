import java.util.*;
class Solution {
		public int[] solution(long[] numbers) {
			int[] answer = new int[numbers.length];
			for(int i=0;i<numbers.length;i++){
				if(canBinaryTree(numbers[i])){
					answer[i] = 1;
				}
			}

			return answer;
		}

		private boolean canBinaryTree(long number) {
			String format = Long.toBinaryString(number);
			int length = 1;
			int i =1;
			while (length<format.length()){
				length += Math.pow(2,i++);
			}

			format = "0".repeat(length-format.length())+format;
			// if(!isAvailableLength(format)) return false;
			Queue<String> queue = new ArrayDeque<>();
			queue.add(format);
			while (!queue.isEmpty()){
				String curFormat = queue.poll();
				int mid = curFormat.length() / 2;
				String left = curFormat.substring(0, mid);
				String right = curFormat.substring(mid + 1);
				if(curFormat.charAt(mid)=='0') {
					if(left.charAt(left.length()/2)=='1'||right.charAt(right.length()/2)=='1') return false;
				}

				if(left.length()>1)
					queue.add(left);

				if(right.length()>1)
					queue.add(right);
			}

			return true;

		}

		private boolean isAvailableLength(String format) {
			int length = format.length();
			int i = 0;
			while (length>=1){
				length -= Math.pow(2,i++);
			}

			if(length==0) return true;
			return false;
		}
	}