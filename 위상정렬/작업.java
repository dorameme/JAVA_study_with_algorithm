/*
start: 12:00
end:다음날 17:05
시간복잡도:O(N)
공간복잡도:O(N*N)
풀이: 아직자바를 푸는데 익숙하지 않고 오랜만에 위상정렬문제를 푸니 너무 헷갈렸다. ->그래서 다른사람들 답안을 참고했다
관련문제들을 더 많이 풀어보는 것도 좋을 듯 하다.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//9:09
class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //작업수
        int N = input.nextInt();
        //걸리는시간
        int[] inDegree = new int[N + 1];
        int[] timeCost = new int[N + 1];
        int[] finishTime = new int[N + 1];
        //각 작업마다 필요한 일들...
        ArrayList<Integer>[] work = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            work[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            timeCost[i] = input.nextInt();
            int need = input.nextInt();
            for (int j = 0; j < need; j++) {
                work[input.nextInt()].add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                finishTime[i] = timeCost[i];
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : work[cur]) {
                if (finishTime[next] < finishTime[cur] + timeCost[next]) {
                    finishTime[next] = finishTime[cur] + timeCost[next];
                }
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(Arrays.stream(finishTime).max().getAsInt());
    }
}
