/*
 * start:13:30
 * end:14:00
 * 시간복잡도:O(NlgN)
 * 공간복잡도:O(N)
 * 풀이: 우선순위 큐를 이용해 풀었다 주의할 점은 맨마지막에 성공하는경우도 고려해야한다는거..


 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int H = Integer.parseInt(stk.nextToken());
        int limit = Integer.parseInt(stk.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < limit; i++) {
            if (pq.peek() < H) {
                System.out.println("YES");
                System.out.println(i);
                return;
            }
            if (pq.peek() == 1 && H == 1) {
                break;
            } else {
                pq.add(pq.poll() / 2);
            }
        }
        if (pq.peek() < H) {
            System.out.println("YES");
            System.out.println(limit);
            return;
        }
        System.out.println("NO");
        System.out.println(pq.peek());
    }
}
