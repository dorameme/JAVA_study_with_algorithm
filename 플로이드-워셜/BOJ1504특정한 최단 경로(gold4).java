
/*
 * start:18:45
 * end:17:13
 * 시간복잡도:O(N^3)
 * 공간복잡도:O(N^2)
 * 풀이: 야.. 고려할게 너무 많았던 문제 그리고 다익스트라로 푸는게 나을지도.. 함들었따 ㅠㅠ
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        long[][] map = new long[801][801];
        ArrayList<int[]>[] linked = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i],  800001);
            linked[i] = new ArrayList<>();
            map[i][i] = 0; -----------------> 자기자신까지는 0 이라는 점 .. 그니까 이구문이 꼭필요하다!!!!
        }
        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            map[x][y] = map[y][x] = Math.min((long) map[y][x], Integer.parseInt(stk.nextToken()));
        }
        stk = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(stk.nextToken());
        int target2 = Integer.parseInt(stk.nextToken());

        ///두 정점을 지나야함.. 따라서 1-> tar1 ->tar2-> N 혹은 1-> tar2 -> tar1 -> N 둘중 하나는 만족해야함.없으면 -1
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        long helper = Math.min(Math.min(
                map[1][target1] + map[target1][target2] + map[target2][N],
                map[1][target2]+ map[target1][target2]+map[target1][N]),
            Math.min( map[1][target2] + map[target2][target1]*2+ map[target1][N],
                map[1][target1] + map[target1][target2]*2 + map[target2][N]));//왜 경우의수가 4개인가?

        long answer = helper;

        if (map[1][target1] == 800001 || map[target1][target2] == 800001 || map[target2][N] == 800001) {
            if (map[1][target1] + map[target1][target2] + map[target2][N] == helper) {
                answer = -1;
            }
        }
        if (map[1][target2] == 800001 || map[target2][target1] == 800001 || map[target1][N] == 800001) {
            if (map[1][target2] + map[target2][target1] + map[target1][N] == answer) {
                answer = -1;
            }
        
        }

        System.out.println(answer);
    }

}
