import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 읽기
        
        for (int t = 1; t <= T; t++) {
            String input = br.readLine(); // 테스트 케이스 문자열 입력
            
            int patternLength = 0;
            // 마디 길이 후보 1부터 10까지 확인
            for (int len = 1; len <= 10; len++) {
                String pattern = input.substring(0, len); // 길이 len의 부분 문자열
                
                // 부분 문자열이 전체 문자열의 패턴이 되는지 확인
                if (input.startsWith(pattern + pattern)) {
                    patternLength = len;
                    break;
                }
            }
            
            // 결과 출력
            System.out.println("#" + t + " " + patternLength);
        }
    }
}