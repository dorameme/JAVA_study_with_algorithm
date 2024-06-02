/*
start:14:20
end:다음날 12:05
시간복잡도:O(3^(N^2))
공간복잡도:O(N^2)
풀이: 다른것 보다 문제를 이해하는데 오랜시간이 걸렸다. 문제를 꼼꼼히 읽어주자!
*/
import java.util.Scanner;

public class Main {

    static int answer = 0;
    static int[][] map = new int[20][20];
    static int[][] dp = new int[20][20];
    static int n;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        n = input.nextInt() - 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = input.nextInt();
            }
        }
        if(map[n][n]!=1)
            move(2, 0, 1);

        System.out.println(answer);
    }


    public static void move(int dir, int x, int y) {
        if (x > n || y > n || map[x][y] == 1) {
            return;
        }
        dp[x][y]++;
        if (dir == 0) {
            if ((x == n - 1 && y == n) || (map[x + 1][y] != 1 && map[x][y + 1] != 1 && x == n - 1
                && y == n - 1)) {
                answer += 1;
                return;
            }
        }
        if (dir == 1) {
            if ((map[x + 1][y] != 1 && map[x][y + 1] != 1 &&x == n - 1 && y == n - 1) || (x == n - 1 && y == n) || (x == n && y == n - 1)) {
                answer += 1;
                return;
            }
        }
        if (dir == 2) {
            if ((x == n && y == n - 1) || (map[x + 1][y] != 1 && map[x][y + 1] != 1 && x == n - 1
                && y == n - 1)) {
                answer += 1;
                return;
            }
        }

        if (dir == 0) {
            if (map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                move(1, x + 1, y + 1);
            }

            move(0, x + 1, y);

        } else if (dir == 1) {

            move(2, x, y + 1);
            move(0, x + 1, y);

            if (map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                move(1, x + 1, y + 1);
            }

        } else if (dir == 2) {
            move(2, x, y + 1);
            if (map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                move(1, x + 1, y + 1);
            }
        }
    }
}
