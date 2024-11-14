import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	private static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int answer = getAnswer(br);
			System.out.print("#" + (testCase + 1 + " "));
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws IOException {
		Map<Integer,Integer> map = new HashMap<>();
		String[] inputValues = br.readLine().split(" ");
		for(String inputValue : inputValues) {
			int value = Integer.parseInt(inputValue);
			if(map.containsKey(value))
				map.put(value,map.get(value)+1);
			
			else {
				map.put(value, 1);
			}
		}
		int max = 0;
		int answer = 0;
		for(Entry entry : map.entrySet()) {
			if(max<=(int)entry.getValue()) {
				max = (int)entry.getValue();
				answer = Math.max(answer, (int)entry.getKey());
			}
		}
		return answer;
	}

}