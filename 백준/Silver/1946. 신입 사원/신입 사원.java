import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			selectApplicants();
		}
	}

	private static void selectApplicants() throws IOException {
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Queue<Applicant> orderByDocs = new PriorityQueue<>((a,b)->{
			return a.documentRank-b.documentRank;
		});

		Queue<Applicant> orderByInterview = new PriorityQueue<>((a,b)->{
			return a.interviewRank-b.interviewRank;
		});
		saveApplicantInfo(n, orderByDocs);

		selectByInterviewRank(orderByDocs, orderByInterview);

		int answer = getAnswer(orderByInterview);

		System.out.println(answer);

	}

	private static int getAnswer(Queue<Applicant> orderByInterview) {
		int answer = 0;
		Applicant interviewFirstApplicant = orderByInterview.poll();
		int stdDocsRank = interviewFirstApplicant.documentRank;
		answer++;
		while (!orderByInterview.isEmpty()){
			Applicant currentApplicant = orderByInterview.poll();
			if(stdDocsRank > currentApplicant.documentRank){
				answer++;
				stdDocsRank = currentApplicant.documentRank;
			}
		}
		return answer;
	}

	private static void selectByInterviewRank(Queue<Applicant> orderByDocs, Queue<Applicant> orderByInterview) {
		Applicant docsFirstApplicant = orderByDocs.poll();
		orderByInterview.add(docsFirstApplicant);

		int stdInterviewRank = docsFirstApplicant.interviewRank;
		while (!orderByDocs.isEmpty()){
			Applicant currentApplicant = orderByDocs.poll();
			if(stdInterviewRank > currentApplicant.interviewRank){
				orderByInterview.add(currentApplicant);
				stdInterviewRank = currentApplicant.interviewRank;
			}
		}
	}

	private static void saveApplicantInfo(int n, Queue<Applicant> orderByDocs) throws IOException {
		StringTokenizer st;
		for(int i = 0; i< n; i++){
			st = new StringTokenizer(br.readLine());
			int documentRank = Integer.parseInt(st.nextToken());
			int interviewRank = Integer.parseInt(st.nextToken());
			orderByDocs.add(new Applicant(documentRank,interviewRank));
		}
	}

	private static class Applicant{
		int documentRank;
		int interviewRank;

		public Applicant(int documentRank, int interviewRank) {
			this.documentRank = documentRank;
			this.interviewRank = interviewRank;
		}
	}
}
