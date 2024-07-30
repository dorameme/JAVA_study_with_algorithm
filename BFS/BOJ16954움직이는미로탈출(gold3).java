/*
start:12:55
end:13:50
시간복잡도:O(nm)
공간복잡도:O(nm)
풀이: 
1.내가 현재있는위치 + 시간을 저장한다.
2.queue가 빌때까지 반복
  if 시간이 7초이상 지나서 벽이 다 떨어짐 (벽이 없어 다 지나갈 수 있는 상황) or 혹은 지금 현재위치가 (0,7) (목표에 도달)
  {
       System.out.println(1);
       return;
  }
3.  queue 가 비면 0 출력.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static String[] map = new String[8];
    static int dx[] = {0, 0, -1, 1, 0, 1, 1, -1, -1};
    static int dy[] = {1, -1, 0, 0, 0, -1, 1, -1, 1};
    static int[][] vis = new int[8][8];

    public static void main(String[] args) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 8; i++) {
                map[i] = bf.readLine();
            }
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(new int[]{7, 0, 0});
            vis[7][0] = 1;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if ((cur[0] == 0 && cur[1] == 7) || cur[2] >= 7) {
                    System.out.println(1);
                    return;
                }
                for (int i = 0; i < dx.length; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= 8 | ny >= 8) {
                        continue;
                    }
                    if ((nx - cur[2]>=0 &&map[nx - cur[2]].charAt(ny) == '#')
                        || ((nx - cur[2]-1>=0 && map[nx - cur[2] - 1].charAt(ny) == '#'))
                    ) {
                        continue;
                    }
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
            System.out.println(0);
        }
    }
}
