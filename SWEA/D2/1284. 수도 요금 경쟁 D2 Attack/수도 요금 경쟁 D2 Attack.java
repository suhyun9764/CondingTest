import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	private static int T;
	private static int aBompanyPerCoast = 0;
	private static int bCompanyDefaultCoast = 1;
	private static int bCompanyRange = 2;
	private static int bCompanyPerCoast = 3;
	private static int useAmount = 4;
	private static int[] values;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			int answer = getAnswer(br);
			System.out.print("#" + (testCase + 1 + " "));
			System.out.println(answer);
		}

	}

	private static int getAnswer(BufferedReader br) throws IOException {
		values = new int[5];
		setting(br);
		int aCoast = getAcompanyCoast();
		int bCoast = getBcompanyCoast();
		
		return Math.min(aCoast, bCoast);
	}

	private static int getAcompanyCoast() {
		return values[useAmount] * values[aBompanyPerCoast];
	}

	private static int getBcompanyCoast() {
		int useWaterAmount = values[useAmount];
		if (useWaterAmount > values[bCompanyRange]) {
			return values[bCompanyDefaultCoast] + ((useWaterAmount - values[bCompanyRange]) * values[bCompanyPerCoast]);
		}

		return values[bCompanyDefaultCoast];
	}

	private static void setting(BufferedReader br) throws IOException {
		String[] inputValues = br.readLine().split(" ");
		int count = 0;
		for (String value : inputValues) {
			values[count] = Integer.parseInt(value);
			count++;
		}
	}

}