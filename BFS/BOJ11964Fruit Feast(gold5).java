/*
start: 12:00
end: 13:15
시간복잡도: O(T/A) * 4 ≈ O(T/A) (T 최대 1000, A 최소 1이므로 충분히 빠름)
공간복잡도: O(1) (추가 배열 없이 변수만 사용)
풀이: 
- 문제의 핵심은 물을 마시면 걸리는 시간이 각각 A/2, B/2 만큼 줄어든다는 점이다.
- 물은 최대 한 번씩만 마실 수 있으므로, 물을 마신 상태는 총 4가지 경우로 나눌 수 있다:
  1) 물을 마시지 않은 상태 (s0 = T)
  2) A 물만 마신 상태 (s1 = T - A/2)
  3) B 물만 마신 상태 (s2 = T - B/2)
  4) A와 B 물 모두 마신 상태 (s3 = T - (A+B)/2) -> 이부분 주의 둘이 묶어서 나눠줘야 한다!!!
- 각 상태마다 A를 몇 번 뺄 수 있을지 반복하며, 남은 시간에서 B로 나눈 나머지 중 최소값을 찾는다.
- 그 결과를 이용해 T에 최대한 가까운 시간을 계산하여 출력한다.
- 다만, s3는 A+B가 T보다 작거나 같을 때만 의미가 있으므로 조건문으로 검사한다.-> 이부분 고려하느라 엄청 틀림 ㅜㅜ

풀이는 이렇지만 이걸 BFS로도 풀수있다니 아래에 첨부하여 풀어보겠다.
*/


public class Main {

    static int T, A, B;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        T = Integer.parseInt(input[0]);
        A = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);

        int s0 = T;
        int s1 = T - A / 2;
        int s2 = T - B / 2;
        int s3 = T - (A + B) / 2;


        int ans = T;

        for (int i = 0; i <= (s0 / A); i++) {
            ans = Math.min(ans, (s0 - A * i) % B);
        }
        for (int i = 0; i <= (s1 / A); i++) {
            ans = Math.min(ans, (s1 - A * i) % B);
        }
        for (int i = 0; i <= (s2 / A); i++) {
            ans = Math.min(ans, (s2 - A * i) % B);
        }
        if(A+B<=T) {/// A+B가 애초에 T를 넘어설수 있다.
            for (int i = 0; i <= (s3 / A); i++) {
                ans = Math.min(ans, (s3 - A * i) % B);
            }
        }
        System.out.println(T - ans);
        //결국 문제의 핵심은 A,B, (A/2 ,B/2)-> (각각 한번) 를 사용해 제일 T 에 가까운 수 만들기.
    }
}

// DP+ BFS버전

public class Main {

    static boolean[][] dp;
    static int T, A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        T = Integer.parseInt(input[0]);
        A = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);
        dp = new boolean[T+1][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{A, 0});
        pq.add(new int[]{B, 0});
        int answer = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            answer = Math.max(answer, cur[0]);
            if (cur[1] == 0 && !dp[cur[0] / 2][1]) {
                dp[cur[0] / 2][1] = true;
                pq.add(new int[]{cur[0] / 2, 1});
            }
            if (cur[0] + A <= T &&!dp[cur[0] + A][cur[1]] ){
                dp[cur[0] + A][cur[1]] = true;
                pq.add(new int[]{cur[0] + A, cur[1]});
            }
            if (cur[0] + B <= T && !dp[cur[0] + B][cur[1]]) {
                dp[cur[0] + B][cur[1]] = true;
                pq.add(new int[]{cur[0] + B, cur[1]});
            }
        }
        System.out.println(answer);

    }
}
