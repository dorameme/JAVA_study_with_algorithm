/*
 * start:11:49
 * end:14:20
 * 시간복잡도:O(NM)
 * 공간복잡도:O(NM)
 * 풀이:It was a simple implementation problem and I personally found it challenging. Given N, we had a symmetrical 2N-1-sized alphabetical sequence of characters.
The problem was to substitute the alphabet from a to z based on the distance from the current coordinates to the center.  For larger distances, just print '.' 

( ps. Macs can create multicursors by double-clicking the Options button when coding)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N;
    static int R1;
    static int R2;
    static int C2;
    static int C1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr[0];
        R1 = arr[1];
        C1 = arr[2];
        R2 = arr[3];
        C2 = arr[4];
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                int num = distance(i % (2 * N - 1), j % (2 * N - 1));
                if (num > N - 1) {
                    System.out.print(".");
                } else {
                    System.out.print((char)(num%26+ 97));
                }
            }
            System.out.println();
        }
    }

    static int distance(int i, int j) {
        return (Math.abs((N - i - 1)) + Math.abs((N - j - 1)));
    }
}
