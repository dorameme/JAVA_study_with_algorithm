/*
start:15:40
end:16:00
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 달팽이문제와 비슷 중요한건 맨첫자리를 앉고 시작해야한다는점 .. nx,ny에서부터 계산하면 0,0자리를 안채우고 시작한다.
*/
import java.util.Arrays;

class Solution {

    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        int N = c;
        int M = r;
        int x = 0;
        int y = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1,0};
        int sit = 0;
        int dir = 0;
        int[][] map = new int[N][M];

        if(k>N*M)return new int[]{0,0};
        map[0][0]=1;
        sit=1;
        while (sit <k) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1) {
                dir = (dir + 1) % 4;
                continue;
            }
            map[nx][ny] = 1;
            x = nx;
            y = ny;
            sit++;
        }
        return new int[]{x+1, y+1};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
