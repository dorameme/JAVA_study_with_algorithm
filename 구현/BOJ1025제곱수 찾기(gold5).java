/*
 * start:19:20
 * end:19:58
 * 시간복잡도:O(nm)
 * 공간복잡도:O(nm)
 * 풀이:  구현 문제였는데 일단 입력값이 작아서 전부 브루트포스로 구현가능했다.
 한번에 풀긴했는데.. 어려웠다 ㅠㅠ 그리고 함수명을 좀더 직관적으로 만들도록 고민해야겠다. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] map = new String[10];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        int answer = -1;
        //x시작번호

        for (int curX = 0; curX < n; curX++) {
            //y시작번호
            for (int curY = 0; curY < m; curY++) {
                int start = map[curX].charAt(curY) - '0';
                if (doubled(start)) {
                    answer = Math.max(start, answer);
                }//start 는 맨처음 시작하는 애..
                for (int i = -8; i <= 8; i++) {
                    for (int j = -8; j <= 8; j++) {
                        start = map[curX].charAt(curY) - '0';
                        for (int k = 1; k <= 8; k++) {
                            int nx = curX + i * k;
                            int ny = curY + j * k;
                            if (nx == curX && ny == curY) {
                                break;
                            }
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                break;
                            } else {
                                start = start * 10 + map[nx].charAt(ny) - '0';
                            }
                            if (doubled(start)) {
                                answer = Math.max(start, answer);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static public boolean doubled(int target) {
        int num = (int) Math.sqrt(target);
        if (num * num == target) {
            return true;
        }
        return false;
    }

}

//클린ver

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행 수
        int m = Integer.parseInt(st.nextToken()); // 열 수
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }

        int answer = -1;

        // 모든 좌표에서 시작
        for (int curX = 0; curX < n; curX++) {
            for (int curY = 0; curY < m; curY++) {
                // 초기값(단일 숫자 확인)
                int start = map[curX].charAt(curY) - '0';
                if (isPerfectSquare(start)) {
                    answer = Math.max(start, answer);
                }

                // 방향 벡터 (-8 ~ 8)
                for (int dx = -8; dx <= 8; dx++) {
                    for (int dy = -8; dy <= 8; dy++) {
                        // dx와 dy가 모두 0인 경우는 무시 (정지 상태)
                        if (dx == 0 && dy == 0) continue;

                        start = map[curX].charAt(curY) - '0'; // 시작 숫자
                        for (int step = 1; step <= 8; step++) { // 최대 8칸 이동
                            int nx = curX + dx * step;
                            int ny = curY + dy * step;

                            // 범위를 벗어나면 종료
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;

                            // 다음 숫자를 추가
                            start = start * 10 + (map[nx].charAt(ny) - '0');

                            // 완전 제곱수인지 확인
                            if (isPerfectSquare(start)) {
                                answer = Math.max(start, answer);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    // 완전 제곱수인지 확인하는 함수
    static boolean isPerfectSquare(int target) {
        int root = (int) Math.sqrt(target);
        return root * root == target;
    }
}
