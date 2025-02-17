import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 스도쿠 보드 입력
        for (int i = 0; i < 9; i++) {
            String line = sc.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0'; // 문자 → 숫자 변환
            }
        }
        
        sc.close();
        solve(0, 0); // (0,0)부터 시작
    }

    static void solve(int row, int col) {
        // 다음 행으로 이동
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }
        // 모든 행을 탐색하면 출력 후 종료
        if (row == 9) {
            printBoard();
            System.exit(0);
        }

        // 빈 칸(0)이면 숫자 채우기 시도
        if (board[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    board[row][col] = num;
                    solve(row, col + 1);
                    board[row][col] = 0; // 백트래킹 (원상 복구)
                }
            }
        } else {
            solve(row, col + 1); // 숫자가 이미 있으면 다음 칸 탐색
        }
    }

    // 유효성 검사 (행, 열, 3x3 박스 체크)
    static boolean isValid(int row, int col, int num) {
        // 같은 행, 같은 열에 숫자가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // 3x3 박스 내 숫자 확인
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }

    // 스도쿠 출력
    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
