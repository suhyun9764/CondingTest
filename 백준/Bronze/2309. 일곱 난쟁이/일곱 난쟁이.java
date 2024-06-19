import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lengths = new int[9];

		int lengthSum = 0;
		for(int i=0;i<9;i++){
			lengths[i] = Integer.parseInt(br.readLine());
			lengthSum += lengths[i];
		}

		Arrays.sort(lengths);

		int notFamilySum = lengthSum - 100;
		boolean isMatch = false;
		for(int i = 0;i<9;i++){
			for(int j= i+1;j<9;j++){
				if(lengths[i]+lengths[j]==notFamilySum){
					lengths[i] = 0;
					lengths[j] = 0;
					isMatch = true;
					break;
				}
			}
			if(isMatch){
				break;
			}
		}

		for(int i=0;i<9;i++){
			if(lengths[i]!=0)
				System.out.println(lengths[i]);
		}

	}
}
