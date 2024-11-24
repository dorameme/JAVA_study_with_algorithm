/*
 * start:12:44
 * end:12:44
 * 시간복잡도:O(2^N)
 * 공간복잡도: O(N * MAX_SUM)
 * 풀이:단순 브루트포스 구현 문제였다.
 근데 시간복잡도가 어차피 N이 20이 최대라 쉽게 풀 수 있었다.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    //    static long[][] map = new long[1025][1025];
    static long[] dp = new long[100000*20+1];
    static int[] vis = new int[21];
    static int N;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        arr = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            arr.add(num);
        }
        subSet(0, 0);
        for (int i = 1; i <= 100000 * 20; i++) {
            if (dp[i] == 0) {
                System.out.println(i);
                return;
            }
        }
    }

    static public void subSet(int idx, int total) {
//        System.out.println(total);
        for (int i = idx; i < N; i++) {
            if (vis[i] == 0) {
                dp[arr.get(i) + total] = 1;
                vis[i] = 1;
                subSet(i, total + arr.get(i));
                vis[i] = 0;
            }
        }
    }
}
