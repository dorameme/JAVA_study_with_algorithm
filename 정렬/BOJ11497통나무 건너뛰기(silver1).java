/*
 * start:15:54
 * end:16:11
 * 시간복잡도:O(T*NlgN)
 * 공간복잡도:O(N)
 * 풀이: 양옆에 나무를 하나씩 심는 형식으로 풀었다!!
 근데 num 따로 안두어도 풀수있을듯 ㅋㅋ
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    //    static long[][] map = new long[1025][1025];
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < T; i++) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            arr = new int[100001];

            int []trees= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(trees);
            int num = trees[0];
            int next = trees[1];
            int next2 =trees[2];
            int max = Math.max(Math.abs(num - next), Math.abs(num - next2));
            for (int j = 3; j < N; j++) {
                num = trees[j];
                if (j % 2 == 1) {
                    max = Math.max(max, Math.abs(num - next));
                    next = num;
                } else {
                    max = Math.max(max, Math.abs(num - next2));
                    next2 = num;
                }
            }
            max = Math.max(max, Math.abs(next2 - next));
            System.out.println(max);
        }
    }
}
