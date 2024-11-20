/*
 * start:20:39
 * end:21:06
 * 시간복잡도:O()
 * 공간복잡도:O()
 * 풀이:항상 문제에서 양끝값을 넣어보는 과정이 중요하다.
 난 1 넣는거 따로 처리안해서 틀렸었음..
 그리고 초기화하는거 귀찮아도 따로 해주는게 좋음.. 귀찮다고 입력부분에 낑겨서 dp초기화하다가 함 틀렸다 ㅜㅠ
 그리고 큐로풀때.. LinkedList보단 ArrayDeque쓰자! 
 -> 이부분은 좀더 깊게 파보고싶다... 
실제 선택 가이드라인:

ArrayList 선택할 때:
대부분의 기본적인 리스트 용도
데이터를 자주 검색하는 경우
데이터가 주로 마지막에 추가/삭제되는 경우


ArrayDeque 선택할 때: >얘는 앞뒤에 포인터가 있음 ㅋㅋ
스택이나 큐 구현이 필요할 때
데이터를 양쪽 끝에서 처리해야 할 때
LinkedList보다 성능이 중요할 때


LinkedList 선택할 때:
데이터의 중간에 빈번한 삽입/삭제가 있을 때
리스트를 순회하면서 요소를 제거할 때
양방향 탐색이 필요할 때
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[21][2];
        int[][] dp = new int[21][2];
        StringTokenizer stk;
        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(stk.nextToken());
            map[i][1] = Integer.parseInt(stk.nextToken());
            dp[i][0] = dp[i][1] = 5000 * 22;
        }
        dp[N][0] = dp[N][1] = 5000 * 22;
        int K = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        LinkedList<int[]> q = new LinkedList<>();
        q.push(new int[]{1, 0, 0});//위치 , cost, K 사용여부

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            if (cur[0] + 1 <= N && dp[cur[0] + 1][cur[2]] > cur[1] + map[cur[0]][0]) {
                dp[cur[0] + 1][cur[2]] = cur[1] + map[cur[0]][0];
                q.add(new int[]{cur[0] + 1, cur[1] + map[cur[0]][0], cur[2]});
            }
            if (cur[0] + 2 <= N && dp[cur[0] + 2][cur[2]] >cur[1]+ map[cur[0]][1]) {
                dp[cur[0] + 2][cur[2]] = cur[1] + map[cur[0]][1];
                q.add(new int[]{cur[0] + 2, cur[1] + map[cur[0]][1], cur[2]});
            }
            if (cur[0] + 3 <= N && cur[2] == 0) {
                if (dp[cur[0] + 3][1] > cur[1] + K) {
                    dp[cur[0] + 3][1] = cur[1] + K;
                    q.add(new int[]{cur[0] + 3, cur[1] + K, 1});
                }
            }
        }
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}



//클린코드 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static class State {
        int position, cost, usedK;
        
        State(int position, int cost, int usedK) {
            this.position = position;
            this.cost = cost;
            this.usedK = usedK;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // N이 1인 경우 즉시 처리
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        // 입력 처리
        int[][] jumps = new int[N][2];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jumps[i][0] = Integer.parseInt(st.nextToken()); // 1칸 점프 비용
            jumps[i][1] = Integer.parseInt(st.nextToken()); // 2칸 점프 비용
        }
        int K = Integer.parseInt(br.readLine());
        
        // DP 배열 초기화
        int[][] dp = new int[N + 1][2];
        final int INF = 5000 * 22;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i][1] = INF;
        }
        
        // BFS 수행
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.offer(new State(1, 0, 0));
        
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int pos = cur.position;
            int cost = cur.cost;
            int used = cur.usedK;
            
            // 1칸 점프
            if (pos + 1 <= N && dp[pos + 1][used] > cost + jumps[pos][0]) {
                dp[pos + 1][used] = cost + jumps[pos][0];
                queue.offer(new State(pos + 1, cost + jumps[pos][0], used));
            }
            
            // 2칸 점프
            if (pos + 2 <= N && dp[pos + 2][used] > cost + jumps[pos][1]) {
                dp[pos + 2][used] = cost + jumps[pos][1];
                queue.offer(new State(pos + 2, cost + jumps[pos][1], used));
            }
            
            // K 사용 (3칸 점프)
            if (pos + 3 <= N && used == 0 && dp[pos + 3][1] > cost + K) {
                dp[pos + 3][1] = cost + K;
                queue.offer(new State(pos + 3, cost + K, 1));
            }
        }
        
        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
