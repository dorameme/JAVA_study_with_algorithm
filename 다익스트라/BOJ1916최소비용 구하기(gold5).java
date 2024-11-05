/*
 * start:14:30
 * end:15:21
 * 시간복잡도:
 각 정점은 한 번씩 큐에서 꺼내짐: O(VlogV)
각 간선은 한 번씩 확인됨: O(ElogV)
총 시간복잡도: O((V+E)logV)
// V: 정점 수(N), E: 간선 수(M)
while(!pq.isEmpty()) {           // 최대 V번 반복
    int[] current = pq.poll();   // O(logV)
    
    for(int[] next : graph[node]) {  // 총 E번의 간선 확인
        // PQ 삽입 연산: O(logV)
        pq.offer(new int[]{nextNode, nextDist});
    }
}
 * 공간복잡도:O(V+E)
 * 풀이:
이문제의 포인트:
1. 일단 플로이드워셜로 풀면 안됨.. 플로이드 워셜은 모든 노드에 대해 최소경로를 모두~다 확인하니 O(N^3)이라는 시간복잡도를 가짐
따라서 이걸 다익스트라로 풀어야함.. 

2. 추가로 아래 둘의 차이를 알아보자.
-static ArrayList[] graph;
// 장점:
- 단순한 구문

// 단점:
- 타입 안정성 없음
- 런타임에 ClassCastException 발생 가능

-static ArrayList<int[]> graph;
// 장점:
- 타입 안정성 있음
- 그래프 표현에 적합
- IDE 자동완성 지원
- 컴파일 시점 타입 체크

// 단점:
- 구문이 다소 복잡
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {

    static int N, M;
    static int[] nodes;
    static int[] distance;
//    static ArrayList[] graph;//도착점, 비용
static ArrayList<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        distance =new int[N+1];
        for(int i = 1; i <= N; i++)
        {
            distance[i]=987654321;
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int[] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[edges[0]].add(new int[]{edges[1],edges[2]});
        }
        int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{route[0], 0});
        distance[route[0]] = 0;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];
            if(distance[node] < dist) continue;

            // 인접 노드 탐색
            for(int[] next : graph[node]) {
                int nextNode = next[0];
                int nextDist = dist + next[1];

                // 더 짧은 경로를 찾은 경우 갱신
                if(nextDist < distance[nextNode]) {
                    distance[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }
        System.out.println(distance[route[1]]);
    }

}
