/*
start: 15:30
end: 16:02
시간복잡도: O(N * M * L * 4K)  
  - N*M: 모든 시작 위치에서 탐색
  - L: target 문자열 길이 (최대 80)
  - 4K: 한 위치에서 최대 4방향 * K칸 이동

공간복잡도: O(N * M * L)
  - dp[x][y][idx]: (x, y)에서 target의 idx번째부터 끝까지 만들 수 있는 경우의 수 저장

풀이:
1. 입력된 2차원 격자에서 target 문자열을 만들 수 있는 경로의 수를 구하는 문제이다.
2. 각 위치에서 시작하여 상하좌우 방향으로 최대 K칸까지 이동하며 target 문자열의 다음 문자를 찾는다.
3. 메모이제이션(dp[x][y][idx])을 통해 동일 상태에 대한 중복 계산을 피한다.  ->>>> 중요
4. 초기화 시 모든 dp 값을 -1로 설정하여 아직 계산되지 않았음을 표시한다. ->>>>>중요
5. arr[i][j]가 target의 첫 글자와 같다면 solve(i, j, 1)을 호출해 재귀적으로 경로를 찾는다.
6. solve 함수는 target 문자열을 완성하면 1을 리턴하며, 다음 문자를 찾는 모든 경로를 누적합으로 더해 리턴한다. --->>> 난 처음에 방문여부만 판단했음 세야하니 dp를 int 배열로두고 센다!
7. 최종적으로 가능한 모든 시작점에서의 경로 수를 더한 값을 출력한다.
*/

class Main {

    static int[][][] dp = new int[101][101][81];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static String target;
    static char[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for(int j=0;j<M;j++)
            Arrays.fill(dp[i][j], -1);

        }
        int total=0;
        target = br.readLine();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] - 'A' == target.charAt(0) - 'A') {
                   total += solve(i, j, 1);
                }
            }
        }
        System.out.println(total);
    }

    static boolean canGo(int nx, int ny, int x, int y) {
        if (x == nx && y == ny) {
            return false;
        }
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return false;
        }
        if ((x == nx && Math.abs(y - ny) <= K) || (y == ny && Math.abs(x - nx) <= K)) {
            return true;
        }
        return false;
    }

    static int solve(int x, int y, int idx) {

        if (idx == target.length()) {
            return 1;
        }
        if(dp[x][y][idx]!=-1){
            return dp[x][y][idx];
        }
        int cur = target.charAt(idx) - 'A';
        int res = 0;
        for (int dir = 0; dir < 4; dir++) {
            for (int step = 1; step <= K; step++) {
                int nx = x + dx[dir] * step;
                int ny = y + dy[dir] * step;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (arr[nx][ny] == target.charAt(idx)) {
                    res += solve(nx, ny, idx + 1);
                }
            }
        }

        return dp[x][y][idx]= res;
    }
}
