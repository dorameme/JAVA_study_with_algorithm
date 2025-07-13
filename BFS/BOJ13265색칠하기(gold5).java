/*
start:19:45
end:20:00
시간복잡도: O(N + M) - 정점 수 N, 간선 수 M 만큼 탐색
공간복잡도: O(N + M) - 인접 리스트 저장용 공간과 색 배열

풀이:
(중요!!!!)항상 고려해야 하는 것은 그래프가 끊겨 있을 수 있다는 것이다.
즉, 연결 요소가 여러 개인 경우도 처리해야 하므로, 모든 노드에 대해 BFS를 시도한다.
BFS를 통해 정점마다 번갈아 색을 칠하며, 인접한 정점과 같은 색이면 이분 그래프가 아님.
그리고 다음부턴 메서드좀 나누자.. 코드보기어렵다
*/
//개선된코드
public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        while (T-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]); // 정점 수
            int m = Integer.parseInt(nm[1]); // 간선 수

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            color = new int[n + 1]; // 0: 방문 안함, 1 또는 2: 색

            boolean isBipartite = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "possible" : "impossible");
        }
    }

    // BFS로 이분 그래프 가능한지 체크
    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    color[next] = 3 - color[cur];  // 1 → 2, 2 → 1
                    queue.add(next);
                } else if (color[next] == color[cur]) {
                    return false;  // 인접한 두 노드가 같은 색일 경우 실패
                }
            }
        }

        return true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            String[] str = bf.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            ArrayList<Integer>[] arr = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                str = bf.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                arr[a].add(b);
                arr[b].add(a);
            }
            Queue<int[]> q = new ArrayDeque<>();
            int[] red = new int[n + 1];
            boolean answer = true;
            for (int z = 1; z <= n; z++) {
                if (red[z] == 0) {
                    q.add(new int[]{z, 1});
                    red[z] = 1;//red blue==-1
                    while (!q.isEmpty() && answer) {
                        int[] cur = q.poll();
                        for (int i = 0; i < arr[cur[0]].size(); i++) {
                            int next = arr[cur[0]].get(i);
                            if (red[next] == cur[1]) {
                                answer = false;
                                break;
                            } else if (red[next] == 0) {
                                red[next] = -cur[1];
                                q.add(new int[]{next, -cur[1]});
                            }
                        }
                        if (!answer) {
                            break;
                        }
                    }
                }
                if (answer == false) {
                    System.out.println("impossible");
                    break;
                }
            }
            if(answer)
            System.out.println("possible");
        }
    }
}
