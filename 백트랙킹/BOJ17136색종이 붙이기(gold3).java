/*
 *
 * start: 15:12
 * end: 16:10
 * 시간복잡도:	이론적으로 O(5^25), 하지만 실제는 강력한 가지치기로 제한됨
 * 공간복잡도:O(1)
 * 풀이:5종류의 색종이가 각각 5개씩있는데.,,이걸 10*10 판에 올려야한다.
 * 근데 1이있는곳에만 있어야하며 0인데는 올리면 안된다.
 * 그리고 최소개수를 써야하니... 큰것부터 소진하자! 백트래킹 문제인듯
 * 또 하나더, 나는 for (int i = x; i < 10; i++, y = 0) { <- 1번 반복후 y는 0으로 시작 이렇게 코딩하는법 처음봤다 배워간다....
 */
//개선된 코드 아래는 내코드
package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[][] board = new int[10][10];
    static int[] papers = {5, 5, 5, 5, 5}; // 각 색종이의 개수 (1x1 ~ 5x5)
    static int totalOne = 0;              // 덮어야 할 총 1의 개수
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 1) totalOne++;
            }
        }

        backtrack(0, 0, 0);
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    static void backtrack(int x, int y, int usedCount) {
        if (usedCount >= minCount) return;

        // 다음 위치로 이동
        for (int i = x; i < 10; i++, y = 0) { ----> 이렇게 쓰면 DP필요없다!!!!!으아아ㅏㅏㅏㅏㅏ 난 몰랐다! 이런방식이있는줄!
            for (int j = y; j < 10; j++) {
                if (board[i][j] == 1) {
                    // 큰 색종이부터 덮기 시도
                    for (int size = 5; size >= 1; size--) {
                        if (canAttach(i, j, size) && papers[size - 1] > 0) {
                            attach(i, j, size, 0);  // 덮기
                            papers[size - 1]--;
                            backtrack(i, j, usedCount + 1);
                            papers[size - 1]++;
                            attach(i, j, size, 1);  // 원복
                        }
                    }
                    return; // 해당 위치에 색종이 하나도 못 붙이면 중단
                }
            }
        }

        // 모든 1을 덮은 경우
        minCount = Math.min(minCount, usedCount);
    }

    static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = val;
            }
        }
    }
}



package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static boolean[][][][][][][][] dp = new boolean[6][10][10][6][6][6][6][6];
    static int[][] arr = new int[100][100];
    static int total;
    static int answer = Integer.MAX_VALUE;
    static int[] paper = {5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] == 1) {
                    total++;
                }
            }
        }
        solve(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void put(int num, int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] == num) {// 1 이 들어오면 -1로 바꾸고 -1이 들어오면 1로 바꿈.(원복)
                    arr[i][j] = -num;
                }
            }
        }
    }

    public static boolean canPut(int x, int y, int num) {
        if (paper[num - 1] > 0 && x + num <= 10 && y + num <= 10) {
            for (int i = x; i < x + num; i++) {
                for (int j = y; j < y + num; j++) {
                    if (arr[i][j] != 1) { //하나라도 1인게 아니면 안돼!
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void solve(int done, int paperCnt) {
        if (done == total || answer < paperCnt) {
            answer = Math.min(answer, paperCnt);
            return;
        }
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1) {
                    for (int z = 5; z >= 1; z--) {
                        if (canPut(i, j, z)
                            && !dp[z][i][j][paper[0]][paper[1]][paper[2]][paper[3]][paper[4]]) {
                            dp[z][i][j][paper[0]][paper[1]][paper[2]][paper[3]][paper[4]] = true;
                            flag = false;
                            paper[z - 1]--;
                            put(1, z, i, j);
                            solve(done + z * z, paperCnt + 1);
                            put(-1, z, i, j);
                            paper[z - 1]++;
                        }
                    }
                    if (flag) {
                        return;
                    }
                }
            }

        }

    }
}
