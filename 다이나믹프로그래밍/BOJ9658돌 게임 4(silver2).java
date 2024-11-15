package 배열;
/*
 * start:14:17
 * end:14:39
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:둘다 dp로 풀었지만 
진짜 밑에 풀이가 훨낫다
심지어 공간복잡도도 5... ㅠㅠ 내가 많이 부족함을 느낀다 좀더 정진해야겠다.

 * */

import java.util.Scanner;

class Main {

    static int[][] dp = new int[10001][3];

    static public void solve(int idx, int turn) {
        int next = 1;
        if (turn == 1) {
            next = 2;
        }
        if (dp[idx - 1][next] == turn || dp[idx - 3][next] == turn
            || dp[idx - 4][next] == turn) {
            dp[idx][turn] = turn;
        } else {
            dp[idx][turn] = next;
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        dp[1][1] = dp[3][1] = 2;
        dp[2][1] = dp[4][1] = 1;
        dp[1][2] = dp[3][2] = 1;
        dp[2][2] = dp[4][2] = 2;
        for (int i = 5; i <= N; i++) {
            solve(i, 1);
            solve(i,2);
        }
        if (dp[N][1] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}


clean ver

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // N이 1, 3, 4로 나누어 떨어지는 경우를 활용하여 패턴 계산
        boolean[] dp = new boolean[5];
        dp[1] = dp[3] = dp[4] = true; // 1, 3, 4에서는 SK가 이김 (true: SK, false: CY)

        for (int i = 5; i <= N; i++) {
            dp[i % 5] = !(dp[(i - 1) % 5] && dp[(i - 3) % 5] && dp[(i - 4) % 5]);
        }

        // dp[N % 5]가 true이면 SK가 이기고, false이면 CY가 이김
        System.out.println(dp[N % 5] ? "SK" : "CY");
    }
}
