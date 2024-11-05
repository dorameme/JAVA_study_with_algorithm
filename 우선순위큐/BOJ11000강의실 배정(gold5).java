
/*
 * start:18:00
 * end:18:37
 * 시간복잡도: O(N log N)
 * 공간복잡도:O(N)
 * 풀이: 시간 초과가 떴다 이유는
 // 기존: LinkedList
static LinkedList<int[]> times;
times.get(i);  // O(n) : 매번 i번째 요소까지 순차 접근

// 개선: Array
int[][] times = new int[N][2];
times[i];      // O(1) : 인덱스로 직접 접근
보통 어레이가 더 빠르다.. 그리고 참조도 많이해야하니 array를 더 애용하자
// 기존: Stream 사용
Arrays.stream(br.readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();
// 내부적으로 여러 단계 거침:
// 1. split으로 문자열 배열 생성
// 2. 스트림 생성
// 3. mapToInt로 변환
// 4. 다시 배열로 변환

// 개선: StringTokenizer 사용
StringTokenizer st = new StringTokenizer(br.readLine());
times[i][0] = Integer.parseInt(st.nextToken());
times[i][1] = Integer.parseInt(st.nextToken());
// 1. 문자열을 직접 파싱
// 2. 바로 정수로 변환

  */ 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Main {

    static int N;
    static LinkedList<int[]> times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            times.add(time);
        }
        times.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        pq.offer(times.get(0)[1]);
        for(int i=1;i<N;i++){
            if(pq.peek()<= times.get(i)[0]){
                pq.poll();
            }
            pq.offer(times.get(i)[1]);
        }
        System.out.println(pq.size());
    }



import java.io.*;
import java.util.*;

class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];  // LinkedList 대신 배열 사용
        
        // 입력 받기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(times, (a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0][1]);
        
        for(int i = 1; i < N; i++) {
            if(pq.peek() <= times[i][0]) {
                pq.poll();
            }
            pq.offer(times[i][1]);
        }
        
        System.out.println(pq.size());
    }
}
