/*
start:17:00
end:17:58
시간복잡도:O(nm)
공간복잡되:O(nm)
풀이: 이번 문제는 어려웠다 특히 오른쪽 왼쪽 위쪽 세곳에서 dp를 고려해야해서 ,
왼쪽과 오른쪽을 따로 처리해줘야했다.
그리고 scanner를 main 전에 받으려고 해버려서 오류가 났었다.
main ->scanner 사용자입력순이어야하는데
scanner를 static으로 둬서 망햇었음
*/
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dp;
    static int[][] temp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        arr = new int[n][m];
        dp = new int[n][m];
        temp = new int[2][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        // 초기값 설정
        dp[0][0] = arr[0][0];

        // 첫 번째 행 초기화
        for (int i = 1; i < m; i++) {
            dp[0][i] = arr[0][i] + dp[0][i - 1];
        }

        // 나머지 행 계산
        for (int i = 1; i < n; i++) {
            // 각 행의 첫 번째 열부터 오른쪽으로
            temp[0][0] = arr[i][0] + dp[i - 1][0];
            for (int j = 1; j < m; j++) {
                temp[0][j] = arr[i][j] + Math.max(dp[i - 1][j], temp[0][j - 1]);
            }

            // 각 행의 마지막 열부터 왼쪽으로
            temp[1][m - 1] = arr[i][m - 1] + dp[i - 1][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                temp[1][j] = arr[i][j] + Math.max(dp[i - 1][j], temp[1][j + 1]);
            }

            // 현재 행의 dp 값을 temp 배열에서 가져와 갱신
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[n - 1][m - 1]);
        input.close();
    }
}
