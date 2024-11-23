/*
 * start:16:45
 * end:17:22
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:이문제의 핵심은 .. 총 3곳을 둘러보고 최대값을 구한다는 것이다..
 처음엔 그냥 완탐으로 풀어버려서.. ㅜㅜ 시간초가남
 항상 dp를 이용하여 어떻게 풀면 제일 최적일지를 고려할줄 알아야한다.

 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static long[][] map = new long[2001][2001];
    static long[][] outDp = new long[2001][2001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = (str.charAt(j) - '0');
            }
        }
        long answer = 0;
        for (int j = 0; j < M; j++) {////순서주의
            for (int i = 0; i < N; i++) {
                if (j == 0) {
                    answer = Math.max(answer, outDp[i][j]);
                } else {
                    if (j - 1 >= 0) {
                        if (i - 1 >= 0) {
                            outDp[i][j] = Math.max(outDp[i][j - 1], Math.max(outDp[i + 1][j - 1],
                                outDp[i - 1][j - 1]));
                        } else {
                            outDp[i][j] = Math.max(outDp[i][j - 1], outDp[i + 1][j - 1]);
                        }
                    }

                }
                answer = Math.max(answer, outDp[i][j]);
                outDp[i][j] += map[i][j];
            }
        }
        System.out.println(answer);
    }
}
