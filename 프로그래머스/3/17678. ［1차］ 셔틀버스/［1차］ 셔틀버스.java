import java.util.*;

class Solution {
		Map<Integer, List<Integer>> map;
		int[] times;
		public String solution(int n, int t, int m, String[] timetable) {
			// 분단위로 저장
			// 전체 출발 시간 저장, int[]에 저장, map으로 명단관리
			// timetable순회하며 해당 시간대에 좌석이 있는지 확인
			// 해당 시간대에 좌석이 없으면 다음 시간대로 이동
			// 가장 마지막 시간대에 좌석이 남아있다면 출발시간으로
			// 좌석이 없다면 마지막사람-1
			times = new int[n];
			times[0] = 9*60;
			for(int i=1;i<n;i++){
				times[i] = times[i-1]+t;
			}

			map = new HashMap<>();
			for(int i=0;i<n;i++){
				map.put(times[i],new ArrayList<>());
			}
			Arrays.sort(timetable);
			// System.out.println(Arrays.toString(timetable));
			for(String time : timetable){
				int minute = getMinute(time);
				int order = getCanRide(minute);
				if(order==-1)
					break;
				if(map.get(times[order]).size()<m){
					map.get(times[order]).add(minute);
				}else{
					while (order<n-1&&map.get(times[order]).size()==m){
						order++;
					}
					if(map.get(times[order]).size()<m)
						map.get(times[order]).add(minute);
				}
			}

			int last = times[times.length - 1];
			List<Integer> rider = map.get(last);


			if(rider.size()<m){
				return parseToStringTime(last);
			}

			int time = rider.get(rider.size() - 1) - 1;

			return parseToStringTime(time);
		}

		private String parseToStringTime(int time) {
			int hour =  time/60;
			int minute = time%60;

			StringBuilder sb = new StringBuilder();
			if(hour<10){
				sb.append(0);
			}
			sb.append(hour);
			sb.append(":");
			if(minute<10){
				sb.append(0);
			}
			sb.append(minute);
			return sb.toString();
		}

		private int getCanRide(int minute) {
			int left = 0;
			int right = times.length-1;

			if(minute>times[times.length-1])
				return -1;

			while(left<right){
				int mid = (left+right)/2;
				if(times[mid]<minute){
					left = mid+1;
				}else{
					right = mid;
				}
			}

			return left;
		}

		private int getMinute(String time) {
			String[] field = time.split(":");
			int hour = Integer.parseInt(field[0]);
			int minute = Integer.parseInt(field[1]);

			return hour*60+minute;
		}
	}