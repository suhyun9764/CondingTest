import java.util.*;

class Solution {
		Map<String,String> map = new HashMap<>();
		public String solution(String m, String[] musicinfos) {
			// music순회
			// ,로 필드 나누기
			// 시간 : 로 나눠서 전체 재생 분 구하기
			// list<Strign> answer 선언
			// 만약 재생분보다 악보가 길다면 악보자르기
			// 재생분보다 악보가 짧다면 악보이어붙히기
			// 악보에 m이 contains되어있다면 answer에 삽입
			// answer정렬(제목이 긴 순서대로)
			String[] melody = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B","E#","B#"};
			for(int i=0;i<14;i++){
				map.put(melody[i], String.valueOf((char)(('A'+i))));
			}

			String listen = getMelody(m);
			List<Music> answers = new ArrayList<>();

			int order = 0;
			for(String musicInfo : musicinfos){
				String[] fields = musicInfo.split(",");
				int minute = getPlayMinutes(fields[0],fields[1]);
				String currentTitle = fields[2];
				String currentMelody = getMelody(fields[3]);

				int n = minute/currentMelody.length();
				int remain = minute%currentMelody.length();

				StringBuilder sb = new StringBuilder();
				for(int i=0;i<n;i++){
					sb.append(currentMelody);
				}

				String totalMelody = sb.append(currentMelody.substring(0,remain)).toString();
				if(totalMelody.contains(listen)){
					answers.add(new Music(currentTitle,minute,order++));
				}
				// String[]
				// 제목
				// 악보
			}
			if(answers.size()==0)
				return "(None)";
			if(answers.size()>1)
				Collections.sort(answers, new Comparator<Music>() {
					@Override
					public int compare(Music o1, Music o2) {
						if(o1.playMinute== o2.playMinute){
							return o1.order-o2.order;
						}

						return o2.playMinute-o1.playMinute;
					}
				});
			return answers.get(0).title;
		}

		private String getMelody(String m) {
			char[] arr = m.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<arr.length;){
				StringBuilder buf = new StringBuilder();
				buf.append(String.valueOf(arr[i]));
				if(i<arr.length-1&&arr[i+1]=='#'){
					buf.append(String.valueOf(arr[i+1]));
					i++;
				}
				sb.append(map.get(buf.toString()));
				i++;
			}

			return sb.toString();
		}

		private int getPlayMinutes(String start, String end) {
			String[] startTime = start.split(":");
			// 끝난시간
			String[] endTime = end.split(":");
			int startMinute = getMinute(startTime);
			int endMinute = getMinute(endTime);
			return endMinute-startMinute;

		}

		private int getMinute(String[] time) {
			return Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
		}

		private class Music {
			String title;
			int playMinute;
			int order;

			public Music(String title, int playMinute, int order){
				this.title = title;
				this.playMinute = playMinute;
				this.order = order;
			}
		}
	}