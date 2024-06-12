import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.StringTokenizer;

import javax.swing.*;

public class Main {
	private final static int BIG = 5;
	private final static int SMALL = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sugar = Integer.parseInt(st.nextToken());
		int bigNum = sugar / BIG;

		if (bigNum == 0) {
			if (sugar % SMALL != 0) {
				System.out.println(-1);
			} else {
				System.out.println(sugar / SMALL);
			}
		} else {
			List<Integer> ls = new ArrayList<>();
			while (bigNum >= 0) {
				int remain = sugar - (BIG * bigNum);
				if (remain % SMALL == 0) {
					int smallNum = remain / SMALL;
					ls.add(smallNum + bigNum);
				}
				bigNum--;
			}
			if (ls.isEmpty()) {
				System.out.println(-1);
			} else {
				Collections.sort(ls);
				System.out.println(ls.get(0));
			}
		}

	}
}
