/*
 * start:21:16
 * end:14:48(다음날)
 * 시간복잡도:O(N^2)
 * 공간복잡도:O(N)
 * 풀이:이전에 푼 풀이는 재귀를 이용했는데 이것이 N * (N-1) * (N-2) * ... * 1 이런식으로 N!까지 갈수있는 코드였다
 그사실을 몰랐는데 생각해보니 
 public static int solve(int idx, int total, int alpa) {
        if (idx >= N - 1) {
            return total;
        }
        if (dp[idx] <= total) {
            return dp[idx];
        }
        for (int i = idx + 1; i < N; i++) {
            if (ALPABET[(alpa + 1) % 3] == str.charAt(i)) {
                dp[idx] = Math.min(dp[idx],
                    solve(i, total + (i - idx) * (i - idx), (alpa + 1) % 3));
            }
        }
        return dp[idx];
    }
이러한 함수로 처리할라했는데 어차피 결국 가까운거리로 점프하는게 더 total이 항상 적으므로 계속 재귀가 깊어질수밖에 없는 코드였다.
따라서 이를 해결하기 위해 for문을 이용한 N^2 로 수정하였다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static String str;
    static int answer;
    static int[] dp = new int[1001];
    public static final char[] ALPABET = {'B', 'O', 'J'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        for (int i = 0; i < 1001; i++) {
            dp[i] = 987654321;
        }
        int answer= 987654321;
        dp[0]=0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if (ALPABET[(str.charAt(i) + 1) % 3] == str.charAt(j)) {
                    dp[j]= Math.min(dp[j],dp[i]+ (j-i)*(j-i));
                }
            }
//            System.out.println(dp[i]);
        }
        if (dp[N-1] == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N-1]);
        }
    }

    public static int solve(int idx, int total, int alpa) {
        if (idx == N - 1) {
            return total;
        }
        int flag = 1;
        for (int i = idx + 1; i < N-1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                flag = 0;
                break;
            }
        }
        if (flag == 1 && ALPABET[(alpa + 1) % 3] == str.charAt(idx + 1)) {
            return dp[idx] = total + (N - 1 - idx) * (N - 1 - idx);
        }
        for (int i = idx + 1; i < N; i++) {
            if (ALPABET[(alpa + 1) % 3] == str.charAt(i)) {
                return dp[idx] = Math.min(dp[idx],
                    solve(i, total + (i - idx) * (i - idx), (alpa + 1) % 3));
            }
        }
        return dp[idx];
    }
}
