/*
 * start:13:12
 * end:13:26
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이:BFS로 풀수 있다. 다만 나는 방문 체크를 큐에 넣을때가아닌  ,  꺼낼때해서 중복으로 값이들어가 처음코드는 메모리초과가 발생했다.

 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        int[][] map = new int[65][65];
        int[][] vis = new int[65][65];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==N-1 && cur[1]== N-1){
                System.out.println("HaruHaru");
                return;
            }
            vis[cur[0]][cur[1]] = 1;
            int jump = map[cur[0]][cur[1]];
            if (cur[0] + jump < N && vis[cur[0] + jump][cur[1]] == 0) {
                vis[cur[0]+jump][cur[1]]=1;
                q.add(new int[]{cur[0] + jump, cur[1]});
            }
            if (cur[1] + jump < N && vis[cur[0]][jump + cur[1]] == 0) {
                vis[cur[0]][jump + cur[1]]=1;
                q.add(new int[]{cur[0], jump + cur[1]});
            }
        }
        System.out.println("Hing");
    }
}

//클린코드 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];  // 65->N으로 변경
        boolean[][] vis = new boolean[N][N];  // int->boolean으로 변경
        
        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;  // 시작점 방문 체크 추가

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int jump = map[x][y];
            
            if(jump == 0) continue;  // 제자리 점프면 넘어감
            
            if(x == N-1 && y == N-1) {
                System.out.println("HaruHaru");
                return;
            }
            
            // 아래로 점프
            if (x + jump < N && !vis[x + jump][y]) {
                vis[x + jump][y] = true;
                q.add(new int[]{x + jump, y});
            }
            // 오른쪽으로 점프
            if (y + jump < N && !vis[x][y + jump]) {
                vis[x][y + jump] = true;
                q.add(new int[]{x, y + jump});
            }
        }
        System.out.println("Hing");
    }
}
