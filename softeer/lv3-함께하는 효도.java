/*
start: 12:00
end: 13:38

시간복잡도: O(4^(M*T))  
- 각 이동마다 4가지 방향으로 이동할 수 있음.
- 최대 M개의 사람을 대상으로 T번(4초 동안) 이동하므로 최악의 경우 O(4^(M*T))의 시간복잡도를 가짐.

공간복잡도: O(N^2 + N^2 * T)  
- `map[N][N]` 배열이 필요하므로 O(N^2).  
- 방문 배열 `vis[N][N][T]`를 사용하여 경로를 기록하므로 O(N^2 * T).

풀이:  
1. **입력 처리**  
   - N × N 크기의 `map`을 생성하고 초기값을 저장.  
   - M명의 초기 위치 정보를 받아 `move` 리스트에 저장하고, 해당 위치의 값을 `answer`에 더한 후 `map`을 0으로 변경.  
2. **재귀적 탐색 (DFS 방식)**  
   - `money(time, idx, vis, people, total)` 함수에서 현재 `idx` 번째 사람의 이동을 결정.  
   - 4방향(상, 하, 좌, 우) 이동을 시도하며, 유효한 경로인 경우 계속 탐색.  
   - 이동한 곳의 값을 `total`에 더하면서 최댓값을 `answer`에 갱신.  
   - 탐색 종료 후, 백트래킹을 통해 상태를 원상복구.  
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int answer;  // 최대 합 저장 변수
    static int[][] map; // N x N 격자 지도
    static int N, M;    // N: 격자 크기, M: 초기 사람 수
    static int[] dx = {0, 0, -1, 1}; // x 좌표 이동 방향 (우, 좌, 상, 하)
    static int[] dy = {1, -1, 0, 0}; // y 좌표 이동 방향 (우, 좌, 상, 하)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // N: 격자 크기, M: 사람 수
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][N];

        // 격자 정보 입력
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 초기 사람 위치 저장
        ArrayList<int[]> move = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;
            move.add(new int[]{x, y});
            answer += map[x][y]; // 시작 위치의 값 추가
            map[x][y] = 0; // 방문한 위치 초기화
        }

        // DFS 탐색 시작 (시간: 4초, 방문 기록 배열, 초기 위치 리스트, 초기 총합)
        money(4, 0, new int[N][N][5], move, answer);

        // 최대값 출력
        System.out.println(answer);
    }

    /**
     * DFS 방식으로 4초 동안 모든 가능한 이동 경로 탐색
     * 
     * @param time     남은 시간 (4초에서 시작)
     * @param idx      현재 이동할 사람의 인덱스
     * @param vis      방문 여부를 기록하는 3차원 배열
     * @param people   현재까지 이동한 사람들의 위치 리스트
     * @param total    현재까지 합산된 점수 값
     */
    static public void money(int time, int idx, int[][][] vis, ArrayList<int[]> people, int total) {
        // 모든 사람의 이동이 끝난 경우
        if (idx % M == 0) {
            time--; // 초 감소
            if (time == 0) {
                answer = Math.max(total, answer); // 최댓값 갱신
                return;
            }
        }

        // 현재 이동할 사람 위치 가져오기
        int[] cur = people.get(idx);

        // 4가지 방향으로 이동 시도
        for (int i = 0; i < 4; i++) {
            int nx = cur[0] + dx[i]; // 새로운 x 좌표
            int ny = cur[1] + dy[i]; // 새로운 y 좌표

            // 격자를 벗어난 경우 무시
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            // 이미 해당 시간에 방문한 경우 무시
            if (vis[nx][ny][time] == 1) {
                continue;
            }

            // 현재 위치 방문 처리
            vis[nx][ny][time] = 1;
            int tmp = map[nx][ny]; // 현재 위치의 값 저장
            map[nx][ny] = 0; // 방문한 위치 초기화

            // 새로운 위치를 리스트에 추가
            people.add(new int[]{nx, ny});

            // 재귀 호출 (다음 사람 이동)
            money(time, idx + 1, vis, people, total + tmp);

            // 백트래킹 (원상 복구)
            people.remove(people.size() - 1);
            map[nx][ny] = tmp;
            vis[nx][ny][time] = 0;
        }
    }
}
