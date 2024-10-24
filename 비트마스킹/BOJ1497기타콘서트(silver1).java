
/*
 * start:14:40
 * end:15:11
 * 시간복잡도:O(2^N)
  Actual runtime: Much faster due to pruning in backtracking
 * 공간복잡도:O(N)
 * 풀이:Solution Key Points:
1.Bitwise Operations with Large Numbers:
Must always use long type when handling large numbers in bit operations
Must use 1L in shift operations instead of 1
Example:
javaCopyint result1 = 1 << 35;    // Overflow occurs
long result2 = 1L << 35;  // Correct result

2.Critical Operator Precedence:
Wrong: 1 << M - 1
Correct: (1 << M) - 1
The parentheses are crucial because:

Without parentheses: First subtracts 1 from M, then shifts
With parentheses: First shifts, then subtracts 1
This difference is essential for creating the correct bit mask

 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int answer = Integer.MAX_VALUE;
    static int[] availableSongs;
    static int N;
    static int M;
    static long [] guitar;
    static long allSongs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr[0];
        M = arr[1];
        guitar = new long[N];
        availableSongs = new int[M];
        for (int i = 0; i < N; i++) {
            long mask = 0;
            String str = br.readLine().split(" ")[1];
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'Y') {
                    availableSongs[j] = 1;
                    mask |= (1L << j);
                }
            }
            guitar[i] = mask;
        }
        allSongs = (1L << M) - 1;
        for (int i = 0; i < M; i++) {
            if (availableSongs[i] == 0) {

                allSongs -= (1L << i);
            }
        }
        if (allSongs == 0) {
            answer =  -1;
        }
        backtrack(0, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void backtrack(int idx, long songs, int cnt) {
        if (cnt >= answer) {
            return;
        }
        // 모든 곡을 커버했으면 최솟값 갱신`
        if (songs == allSongs) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (idx == N) {
            return;
        }

        backtrack(idx + 1, songs | guitar[idx], cnt + 1);
        backtrack(idx + 1, songs, cnt);
    }
}
