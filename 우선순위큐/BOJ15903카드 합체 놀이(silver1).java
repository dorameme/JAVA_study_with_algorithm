/*
 * start:16:33
 * end:16:47
 * 시간복잡도:O(NlgN)
 * 공간복잡도:O(N)
 * 풀이:
 Key Points:

Uses PriorityQueue to always work with smallest numbers
Each iteration combines two smallest numbers
Result is the sum after all operations
Effectively implements card combining/merging logic
Common in card game or cost optimization problems

The algorithm efficiently finds the minimum possible sum after M combining operations, using a min-heap (PriorityQueue) to always access the smallest elements.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Main {

    static int N;
    static int M;
    static List<Long> score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = s[0];
        M = s[1];
        score = Arrays.stream(br.readLine().split(" ")).map(Long::valueOf)
            .collect(Collectors.toList());
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        pQ.addAll(score);
        for (int i = 0; i < M; i++) {
            Long newNum = pQ.remove() + pQ.remove();
            pQ.add(newNum);
            pQ.add(newNum);

        }
        Long answer = 0L;
        while (!pQ.isEmpty()) {
            answer += pQ.remove();

        }
        System.out.println(answer);

    }
}
