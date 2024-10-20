/*
start:21:58
end:22:18
시간복잡도:O(N)
공간복잡도:O(N)
풀이:  그래프의 연결성을 확인하는 프로그램
 N*N 인접 행렬에서 직/간접적으로 연결된 모든 경로를 찾아 표시
가벼운 문제였고 좀더 클린한 코드는 밑에 첨부 함수를 나눠둔건데 크게 차이나진않음
bfs로 풀었는데 플로이드-워셜문제임ㅋㅋ 그리고 그게 더 풀이가 간단함!
사실 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int[] vis= new int[N];
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    vis[j]=1;
                    q.add(j);

                }
            }
            while(!q.isEmpty()){
                int route = q.poll();
                for(int j=0;j<N;j++){
                    if(arr[route][j]==1 && vis[j]!=1){
                        vis[j]=1;
                        arr[i][j]=1;
                        q.add(j);
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N ;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}



import java.io.*;

/**
 * 플로이드 워셜 알고리즘을 사용한 그래프 연결성 확인 프로그램
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        
        // 그래프 입력
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 플로이드 워셜 알고리즘 수행
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
