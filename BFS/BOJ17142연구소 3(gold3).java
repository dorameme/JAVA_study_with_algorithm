///*
//* start:10:00
//* end:13:16
//* 시간복잡도:O(N^2)
//* 공긴복잡도:O(N^2)
//* 풀이:->flood fill 문제로 BFS로 풀어야함. 완탐으로 풀어야할것 같은데, M의 최대가 10이니까...조합으로 완전가능
//*Deque<int[]> helper = new ArrayDeque<>(new ArrayList<>(stk)); 이부분에서 완전애먹음.. 실수로 stk그대로 넘겼는데
어레이리스트로 한번 감싸워야한다.
*/

package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int N, M;
    static int[][] arr = new int[51][51];
    static ArrayList<int[]> virus = new ArrayList<>();
    static Deque<int[]> stk = new ArrayDeque<>();
    static int total;
    static int ans = Integer.MAX_VALUE;
    static int[][] vis = new int[51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] == 0) {
                    total++;
                }
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        if (total == 0) {
            System.out.println(0);

            return;
        }

        choice(0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans - 1);
        }
    }

    public static boolean canSolve(int zero) {
        return zero == total;
    }

    public static void choice(int idx) {
        if (stk.size() == M) {
            ans = Math.min(ans, solve());
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            stk.add(virus.get(i));
            vis[virus.get(i)[0]][virus.get(i)[1]] = -1;
            choice(i + 1);
            vis[virus.get(i)[0]][virus.get(i)[1]] = 0;
            stk.remove();
        }

    }

    public static boolean move(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        if (arr[x][y] == 1) {
            return false;
        }

        return true;
    }


    public static int solve() {
        Deque<int[]> helper = new ArrayDeque<>();//(stk);//? 이거 이상함..

        int[][] localVis = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                localVis[i][j] = vis[i][j];
                if (localVis[i][j] == -1) {
                    helper.add(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        int answer = 0;
        while (!helper.isEmpty()) {
            int[] cur = helper.remove();
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if (move(nx, ny) && localVis[nx][ny] == 0) {//이동가능
                    localVis[nx][ny] = localVis[cur[0]][cur[1]] - 1;//활성일 경우 arr<0;
                    helper.add(new int[]{nx, ny});
                    if (arr[nx][ny] == 0) {
                        answer = Math.max(answer, -localVis[nx][ny]);
                        cnt++;
                        if (cnt == total) {
                            return answer;
                        }

                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

