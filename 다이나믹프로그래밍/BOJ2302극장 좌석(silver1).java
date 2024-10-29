/*
 * start:10:17
 * end:10:33
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 optimized approach significantly reduces time complexity, making it suitable for larger inputs by avoiding exponential time complexity.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N, M, answer;
    static int[] seat = new int[41];

    public static void makeOrder(int idx) {
        if (idx == N + 1) {
            answer++;
            return;
        }
        if (seat[idx] == -1) {
            makeOrder(idx + 1);
        }
        if (seat[idx] == 0) {
            seat[idx] = idx;
            makeOrder(idx + 1);
            seat[idx] = 0;
        }
        if (seat[idx - 1] == 0 && idx != 1) {
            seat[idx - 1] = idx;
            makeOrder(idx + 1);
            seat[idx - 1] = 0;
        }
//        if (seat[idx + 1] == 0 && idx != N) {
        if (idx != N && seat[idx + 1] == 0) {
            seat[idx + 1] = idx;
            makeOrder(idx + 1);
            seat[idx + 1] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            seat[vip] = -1;
        }

        makeOrder(1);//시간초과날거같음..
        System.out.println(answer);
    }
}



// optimized approach
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N, M;
    static int[] dp = new int[41];
    static int[] seat = new int[41];
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // DP 초기값 설정
        dp[0] = 1; // 좌석 0개일 때 경우의 수는 1 (아무도 앉히지 않는 경우)
        dp[1] = 1; // 좌석 1개일 때 경우의 수는 1 (한 명만 앉힐 수 있음)
        dp[2] = 2; // 좌석 2개일 때 경우의 수는 2 (자리 변경 가능)

        // DP 테이블 채우기
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // VIP 좌석 입력받기
        int previous = 0; // 이전 VIP 좌석 위치
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - previous - 1];
            previous = vip;
        }
        
        // 마지막 구간 계산 (마지막 VIP 이후부터 끝까지)
        answer *= dp[N - previous];
        
        System.out.println(answer);
    }
}
