/*
start:14:00
end:14:28
시간복잡도:O(NM)
공간복잡도:O(NM)
풀이:사다리 위부터 차례대로 내려가며 풀면되는 쉬운문제였다.
*/
import java.util.Arrays;

class Solution {

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 1; i <= n; i++) {
            int now = i;
            for (int j = 0; j < ladder.length; j++) {
                for (int z = 0; z < ladder[j].length; z++) {
                    if (ladder[j][z] == now) {
                        now++;
                        break;
                    } else if (ladder[j][z] + 1 == now) {
                        now--;
                        break;
                    }
                }
            }
            answer[now - 1] = (char) ('A' + i - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(
            Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(
            Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12,
            new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10},
                {3, 6, 8, 11}})));
    }
}
