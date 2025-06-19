/*
start:14:00
end:15:00
시간복잡도: O(N * M * log(W)), W = 전체 벽 개수
공간복잡도: O(N * M)
풀이:
이분 탐색 + 다익스트라 방식의 BFS
 - 0,0에서 N-1,M-1까지 이동하는데 벽을 뚫어야 하는 경우가 있음
 - 벽을 뚫는 최대 횟수를 최소화하고 싶음 → "최솟값을 이분 탐색"하는 문제
 - 벽을 최대 mid개까지 뚫을 수 있다고 할 때 도착 가능한지를 BFS(PQ)로 판별
 - 가능한 mid 중 최솟값을 이분 탐색으로 찾음
*/

public class Main {

    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static int[] dy = {-1, 1, 0, 0};
    static int N, M, wall;
    static int[][] arr; // 미로 정보 저장 (0: 빈칸, 1: 벽)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken()); // 열
        N = Integer.parseInt(stk.nextToken()); // 행
        arr = new int[N][M];

        // 입력 받기 + 전체 벽 개수 세기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
                if (arr[i][j] == 1) {
                    wall++; // 전체 벽 수
                }
            }
        }

        int l = 0;
        int r = wall; // 최대로 부술 수 있는 벽 개수는 전체 벽 수
        int ans = Integer.MAX_VALUE;

        // 이분 탐색: mid개 이하의 벽을 부숴서 목적지에 도달 가능한지 판단
        while (l <= r) {
            int mid = (l + r + 1) / 2; // 오른쪽 치우침: 무한루프 방지
            if (solve(mid)) { // mid개 이하로 도달 가능하면 더 적은 벽도 가능할지 확인
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else { // mid개로도 도달 불가 → 더 많은 벽이 필요
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }

    // 벽을 mid개 이하로 부수면서 도착 가능 여부 확인 (다익스트라 형태)
    private static boolean solve(int mid) {
        int[][] vis = new int[N][M]; // (x, y)까지 부순 최소 벽 수 저장
        for (int i = 0; i < N; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        vis[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])); // 부순 벽 수 기준 정렬

        if (N == 1 && M == 1) return true; // 시작과 끝이 같으면 바로 true

        pq.add(new int[]{0, 0, 0}); // {x, y, 벽 부순 횟수}
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int wall = cur[2] + (arr[nx][ny] == 1 ? 1 : 0);
                if (vis[nx][ny] > wall && wall <= mid) {
                    if (nx == N - 1 && ny == M - 1) return true; // 도착 가능
                    vis[nx][ny] = wall;
                    pq.add(new int[]{nx, ny, wall});
                }
            }
        }

        return false; // 도달 불가
    }
}
