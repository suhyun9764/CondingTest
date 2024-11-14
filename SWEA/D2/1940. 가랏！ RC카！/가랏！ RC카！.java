import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



class Solution {

	private static int T;
	private static int N;
	private static List<int[]> commands;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int answer = getAnswer(br);
			System.out.print("#" + (testCase + 1 +" "));
			System.out.println(answer);
		}
	}

	private static int getAnswer(BufferedReader br) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		getCommands(br);
		int answer = 0;
		int beforeV = 0;
		for(int[] command : commands) {
			int currentCommand = command[0];
			int currentV = command[1];
			if(currentCommand==1) {
				beforeV +=currentV;
				answer += beforeV;
				
			}
			
			if(currentCommand==2) {
				beforeV-=currentV;
				if(beforeV<0)
					beforeV=0;
				
				answer += beforeV;
			}
			
			if(currentCommand==0) {
				answer += beforeV;
			}
		}
		return answer;
	}

	private static void getCommands(BufferedReader br) throws IOException {
		commands = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String[] commandAndV = br.readLine().split(" ");
			if(commandAndV.length>1) {
				int command = Integer.parseInt(commandAndV[0]);
				int V = Integer.parseInt(commandAndV[1]);
	
				commands.add(new int[] {command,V});
			}
			else {
				commands.add(new int[] {0,0});
			}
		}
	}
}
