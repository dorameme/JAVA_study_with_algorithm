import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * start : 13:06
 * end : 14:17
 시간복잡도:O(N*N)
 공간복잡도:O(N*N)
풀이: 삼성의 구현문제이다.
어렵다기보다 어떤케이스가 있을 수 있을지 곰곰이 생각해보며 푸는것이 중요*/
public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int student;
    static int N;
    static List<Integer> order = new ArrayList<>();
    static List<List<Integer>> like = new ArrayList<>();
    static int[][] map = new int[401][401];

    public static int[] condition(int who, int n, int m) {
        int[] cnt = new int[2];
        for (int i = 0; i < 4; i++) {
            int nx = n + dx[i];
            int ny = m + dy[i];
            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                continue;
            }
            if (like.get(who).contains(map[nx][ny])) {
                cnt[0]++;
                continue;
            }
            if (map[nx][ny] == 0) {//주변에 사람이 없어!
                cnt[1]++;
            }

        }
        return cnt;
    }

    public static int score(int n, int m) {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            int nx = n + dx[i];
            int ny = m + dy[i];
            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                continue;
            }
            if (like.get(map[n][m]).contains(map[nx][ny])) {
                if (score == 0) {
                    score = 1;
                } else {
                    score = score * 10;
                }
            }

        }
        return score;
    }

    public static void makeSit(int who) {
        int[] answer = new int[2];
        int x = -1;
        int y = -1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) {
                    int[] sit = condition(who, i, j);
                    if (sit[0] > answer[0]) {
                        answer[0] = sit[0];
                        answer[1] = sit[1];
                        x = i;
                        y = j;
                    } else if (sit[0] == answer[0] && sit[1] > answer[1]) {
                        answer[1] = sit[1];
                        x = i;
                        y = j;
                    }
                    continue;
                }
            }
        }
        if (x == -1) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = who;
                        return;
                    }
                }
            }
        } else {
            map[x][y] = who;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        student = N * N;
        for (int i = 0; i <= student; i++) {
            like.add(new ArrayList<>());
        }//인덱스 -> 0~ student
        for (int i = 0; i < student; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            order.add(studentNum);
            for (int j = 0; j < 4; j++) {
                like.get(studentNum).add(Integer.parseInt(st.nextToken()));//인덱스
            }
        }
        int answer = 0;

        for (int i = 0; i < student; i++) {
            makeSit(order.get(i));
        }

        for (int j = 1; j <= student; j++) {
            for (int z = 1; z <= student; z++) {
                answer += score(j, z);
            }
        }
        System.out.println(answer);
    }

}
