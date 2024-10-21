/*
start:13:00
end:13:45
시간복잡도:O(N*M)
공간복잡도:O(N*M)
풀이:누적합을 구하는 문제였는데 그림으로 설명하는게 빠르고 편하니 img에 누적합 을 참고하자!
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        int R = Integer.parseInt(str.nextToken());
        int C = Integer.parseInt(str.nextToken());
        int Q = Integer.parseInt(str.nextToken());

        int[][] arr = new int[R + 1][C + 1];
        int[][] dp = new int[R + 1][C + 1];

        for (int i = 0; i < R; i++) {
            arr[i] = Arrays.stream(bfr.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 1; i <= R; i++) {
            dp[i][1] = dp[i - 1][1] + arr[i - 1][0];
        }
        for (int i = 1; i <= C; i++) {
            dp[1][i] = dp[1][i - 1] + arr[0][i - 1];
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + arr[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
        for (int i = 0; i < Q; i++) {
            int[] box = Arrays.stream(bfr.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            int count = (box[3] - box[1] + 1) * (box[2] - box[0] + 1);
            bfw.write((dp[box[2]][box[3]] -
                dp[box[2]][box[1] - 1] - dp[box[0] - 1][box[3]] + dp[box[0] - 1][box[1] - 1])
                / count + "\n");
        }
        bfw.flush();
        bfw.close();
        bfr.close();
    }
}
