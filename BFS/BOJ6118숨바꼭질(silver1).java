/*
start:14:00
end:14:38
시간복잡도:O(N*N*M)
공간복잡도:O(N*N*M)
풀이:
1. 단순 bfs문제다 주의할 점은 메모리크기다!
256MB 까지 사용가능 할때 int 는 4Byte 이므로 
int형은 4바이트
1KB는 1024바이트
1MB는 1024KB 이므로
256MB = 256 * 1024KB = 256 * 1024 * 1024 => int형은 256 * 1024 * 1024 / 4개 = 67108864 정도 선언가능
대략 int 형 6억개 정도 가능!
근데 문제에서 최대 노드가 2만개이고 최대 연결 노드가 5천개라서 이걸 최대값으로 두면 오류가 날 수 있다...
필요한 만큼만 할당해서 쓰자!
(사실 1024로 계산하기가 까다로워서, 대충 1000이라고 놓고 계산하면 얼추 맞다.)

2. IntStream 으로 반복문 없이 나타내 풀 수 있었다.
IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int[] vis;
    static int minNum = Integer.MAX_VALUE;
    static int distence = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringTokenizer token = new StringTokenizer(s);
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        vis = new int[n + 1];

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        IntStream.range(1, list.length).forEach(i -> list[i] = new ArrayList<>());

        for (int i = 0; i < m; i++) {
            s = reader.readLine();
            token = new StringTokenizer(s);
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            list[A].add(B);
            list[B].add(A);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = 1;  // 시작점을 1로 표시하여 방문 처리

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (vis[next] == 0) {
                    vis[next] = vis[now] + 1;
                    q.add(next);
                    distence = Math.max(distence, vis[next]);
                }
            }
        }

        distence--;  // 최종 거리 값에서 1을 빼줌

        for (int i = n; i >= 1; i--) {
            if (vis[i] == distence+1) {
                minNum = i;
                answer++;
            }
        }

        System.out.println(minNum + " " + distence + " " + answer);
    }
}
