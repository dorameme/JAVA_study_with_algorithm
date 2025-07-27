/*
start:14:40
end:15:18
시간복잡도:O(N)
공간복잡도:O(N)
풀이:  
- T일 동안 상담을 할 수 있는 스케줄이 주어진다.  
- 각 날짜에 대해 상담을 할지 말지를 선택해야 하며, 상담을 하게 되면 해당 기간만큼 쉬어야 한다.  
- i일부터 상담을 시작했을 때 최대 수익을 dp[i]에 저장한다.  
- i일에서부터 뒤로 탐색하면서 dp를 갱신하고, 현재 시점까지의 최대 수익 max를 유지한다.  
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        int[][] arr = new int[T + 2][2];
        long[] dp = new long[T + 2];
        for (int i = 1; i <= T; i++) {
            String[] input = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        long max = 0;
        for (int i = T; i >= 1; i--) {
            dp[i]=max;
            if (arr[i][0] + i - 1 <= T) {
                dp[i] = Math.max(dp[i], dp[arr[i][0] + i] + arr[i][1]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
