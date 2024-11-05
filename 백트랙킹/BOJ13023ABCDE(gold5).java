/*
 * start:18:45
 * end:19:46
* 시간복잡도: O(N * M)
각 정점(N)에서 DFS를 시작
각 DFS에서 최대 깊이는 5 (상수)
각 정점에서 최대 M개의 간선을 확인
따라서, 총 시간복잡도는 O(N * M)
 * 공간복잡도:O(N)
 * 풀이: 백트랙킹문제였는데 내가 조건을 5명이 아닌 4명으로 잡아서 한참헤멨다 짜증 -_-
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int N, M, answer;
    static ArrayList<Integer>[] friends;
    static int[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }
        vis = new int[2001];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friends[f1].add(f2);
            friends[f2].add(f1);
        }

        for (int i = 0; i < N; i++) {
            vis[i] = 1;
            dfs(i, 1);
            if (answer == 1) {
                break;
            }
            vis[i] = 0;
        }
        System.out.println(answer);
    }

    public static void dfs(Integer idx, Integer len) {
        if (len >= 5 || answer == 1) {
            answer = 1;
            return;
        }
        for (int person : friends[idx]) {
            if (vis[person] == 0) {
                vis[person] = 1;
                dfs(person, len + 1);
                vis[person] = 0;
            }
        }
    }
}
