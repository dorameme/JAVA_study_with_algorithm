/*
start:17:00
end:17:40
시간복잡도:O(N*M)
공간복잡도:O(N*M)
풀이:단순 bfs문제다 하지만 입출력에서 유의할 점이있다.
  Scanner vs BufferReader
Scanner는 다양한 기능을 담고있는 무거운 클래스라 속도가 느리다.
문자열에 특화된 BufferedReader, StringTokenizer를 사용해서 풀어야 시간초과를 안나게 풀 수 있다.
  Spilt vs StringTokenizer
문자열을 자르게 위해 split을 사용할땐, split은 정규식을 기반으로 자르는 로직으로서 내부는 복잡하다.
그에 비해 StringTokenizer의 nextToken()메소드는 단순히 공백 자리를 땡겨 채우는 것이다. 정규식 처리가 딱히 필요한게 아닌 경우 StringTokenizer가 효율적이다.
정규식이나 인덱스 접근과 같은 처리가 필요없다면 StringTokenizer를 사용하는 것이 효율적이다.

  추가 -StringTokenizer 사용법
자바에서는 String을 token단위로 끊어주는 StringTokenizer 클래스를 제공한다.
예를들어 “this is my string” 이라는 스트링을 this, is, my, string 4개의 스트링으로 끊어주는 기능을 제공한다.
그리고 공백말고도 다른 구획문자(delimiter)를 사용할수도 있다. 예를들어 this%is%my%string을 delimiter에 %를 넣어 StringTokenizer를 사용하면 마찬가지로 this, is, my, string으로 읽어준다.
thismy%string^일때 구획문자를 “$%^”라고 설정해주면 this, is, my, string 으로 끊어준다.

참고 -https://velog.io/@mooh2jj/Java-%EC%9E%85%EC%B6%9C%EB%A0%A5-BufferedReader-StringTokenizer%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0-
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int n, m, targetX, targetY;
    static int[][] arr;
    static int[][] vis;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        vis = new int[n][m];  // vis 배열 초기화

        for (int i = 0; i < n; i++) {
            StringTokenizer line= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] =Integer.parseInt(line.nextToken());
                if (arr[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }
        bfs(targetX, targetY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && arr[i][j] == 1) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        arr[x][y] = 0;
        vis[x][y] = 1;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (vis[nx][ny] == 1 || arr[nx][ny] == 0) {
                    continue;
                }
                vis[nx][ny] = 1;
                arr[nx][ny] = arr[p.getX()][p.getY()] + 1;
                queue.add(new Pair(nx, ny));  // 큐에 새 좌표 추가
            }
        }
    }

    static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
