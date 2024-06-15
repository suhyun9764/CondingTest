
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Jewel[] jewels = new Jewel[n];
		// List<Jewel> jewels = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			Jewel jewel = new Jewel(weight,price);
			jewels[i] = jewel;
		}

		Arrays.sort(jewels,(a,b)->{
			return a.weight - b.weight;
		});

		int[] pockets = new int[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			pockets[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pockets);
		long answer = 0;
		Queue<Integer> priceOfJewel = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		for(int i=0, j=0; i<pockets.length;i++){
			int currentPocket = pockets[i];
		 	while(j<n&&jewels[j].weight<=currentPocket){
				Jewel currentJewel = jewels[j++];
				if(currentPocket>=currentJewel.weight){
					priceOfJewel.add(currentJewel.price);
				}
			}

			if(!priceOfJewel.isEmpty()){
				answer+=priceOfJewel.poll();
			}
		}

		System.out.println(answer);
	}

	public static class Jewel{
		int weight;
		int price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
}
