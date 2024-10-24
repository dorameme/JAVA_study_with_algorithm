/*
 * start:13:01
 * end:13:28
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 Key Learning
javaCopy// Sorting 2D array by first column
Arrays.sort(score, (a, b) -> a[0] - b[0]);

Problem Solving Strategy
The algorithm for screening candidates based on two test scores:

Initial Sort
Sort candidates by first test score in ascending order
Begin evaluation from the highest scorer (rank 1)


Tracking Process
Keep track of minimum rank (best performance) seen so far in second test
As we move down the ranks of test 1, update this minimum rank


Elimination Rule
For each candidate after first place:
If their second test rank is worse than the current minimum rank
They are eliminated from consideration
 * */


import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for (int i = 0; i < N; i++) {
                score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
            Arrays.sort(score, (a, b) -> a[0] - b[0]);
            int answer = N;
            int min = score[0][1];
            for (int i = 1; i < N; i++) {
                min = Math.min(min, score[i][1]);
                if (score[i][1] > min) {
                    answer--;
                }
            }
            System.out.println(answer);
        }
    }
}
