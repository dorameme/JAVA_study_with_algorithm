/*
start:19:30
end:20:27
시간복잡도:O(NMK)
공간복잡도:O(KN)
풀이:
런타임 에러 (ArrayIndexOutOfBounds)로 여러번 에러가 났는데, 중요한건  flight[i] = new ArrayList<>(); 로 만들어놓고 크기를 크게잡으면
아래에서 for문으로 순회할때 문제가 생긴다는 것이다. 필요한만큼만 할당하거나, 일반적인 for문을 쓰도록 하자.
*/
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        ArrayList<int[]>[] flight = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            flight[i] = new ArrayList<>();
        }
        int[][] dp = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < K; i++) {
            input = bf.readLine().split(" ");
            flight[Integer.parseInt(input[0])].add(
                new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }
        int ans = 0;
        dp[1][0] = 0;
        for (int k = 1; k < M; k++) {
            for (int i = 1; i <= N; i++) {
                for (int[] cur : flight[i]) {
                    if (i < cur[0] && dp[i][k - 1] != -1) {
                        dp[cur[0]][k] = Math.max(dp[cur[0]][k], dp[i][k - 1] + cur[1]);
                        if (cur[0] == N) {
                            ans = Math.max(ans, dp[cur[0]][k]);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
