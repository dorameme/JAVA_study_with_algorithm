/*
 * start:14:10
 * end:15:20
 * 시간복잡도:O(N*N)
 * 공간복잡도:O(N*N)
 * 풀이:Trim from 1 to the length you can cut
Note that if there is no remainder when you cut, you must add one to the 
number of cuts = number of sticks cut - 1 plus -1 once.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N, C, W;
    static Integer[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] s = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
            .toArray(Integer[]::new);
        N = s[0];
        C = s[1];
        W = s[2];
        trees = new Integer[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(trees, (a, b) -> b - a);
        //자르지않는경우
        //자르는 경우
        long answer = 0;
        for (int i = 1; i <= trees[0]; i++) {
            long total = 0;
            for (int j = 0; j < N; j++) {
                long money = cutAndSale(j, i);
                if (money > 0) {
                    total += money;
                }
            }
            if (total > answer) {
                answer = Math.max(answer, total);
            }
        }
        System.out.println(answer);
    }

    public static int cutAndSale(int idx, int height) {
        if (trees[idx] % height == 0) {
            return ((trees[idx] / height) * height) * W - C * (trees[idx] / height - 1);
        }
        return (trees[idx] / height * height) * W - C * (trees[idx] / height);

    }
}
