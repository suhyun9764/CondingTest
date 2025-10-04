import java.util.*;

class Solution {
		public int[] solution(String today, String[] terms, String[] privacies) {
			Map<String, Integer> termMap = new HashMap<>();
			// 약관 정보 저장
			saveTerms(terms, termMap);
			int todayTotalDate = toDate(today);
			// 개인정보 순회
			List<Integer> answer = new ArrayList<>();
			for(int i=0;i<privacies.length;i++){
				String curPrivacy = privacies[i];
				String termName = curPrivacy.split(" ")[1];
				String strDate = curPrivacy.split(" ")[0];
				int totalDate = toDate(strDate);
				totalDate += termMap.get(termName);

				if(totalDate<=todayTotalDate) answer.add(i+1);
			}

			int[] answerArray = new int[answer.size()];
			for(int i=0;i<answerArray.length;i++){
				answerArray[i] = answer.get(i);
			}

			return answerArray;
		}

		private int toDate(String strDate)  {
			int year = Integer.parseInt(strDate.split("\\.")[0]);
			int month = Integer.parseInt(strDate.split("\\.")[1]);
			int day = Integer.parseInt(strDate.split("\\.")[2]);

			return day+month*28+year*12*28;
		}

		private static void saveTerms(String[] terms, Map<String, Integer> termMap) {
			for(int i = 0; i< terms.length; i++){
				String[] fields = terms[i].split(" ");
				String termName = fields[0];
				int day = 28*Integer.parseInt(fields[1]);
				termMap.put(termName,day);
			}
		}
	}