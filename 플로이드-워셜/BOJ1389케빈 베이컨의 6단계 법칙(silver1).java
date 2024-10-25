/*
 * start:11:00
 * end:11:28
 * 시간복잡도:O(N^3)
 * 공간복잡도:O(N^3)
 * 풀이:

Floyd-Warshall Algorithm Order:
* Must follow k -> i -> j sequence
* k (intermediate node) should be considered first because it updates all possible paths through current intermediate vertices before moving to the next vertex, ensuring that when we calculate dist[i][j], all shorter paths through previous vertices k have already been computed.

Explanation:
```java
for (int k = 1; k <= N; k++) {     // intermediate vertex (must be first)
    for (int i = 1; i <= N; i++) {  // source vertex
        for (int j = 1; j <= N; j++) { // destination vertex
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
    }
}
```
* If we change this order, we might miss shorter paths that use vertices as intermediate nodes that haven't been considered yet.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N;
    static int M;
    static int[][] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NM[0];
        M = NM[1];
        friends = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                friends[i][j] = 987654321;
            }
        }
        for (int i = 0; i < M; i++) {
            int[] node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            friends[node[0]][node[1]] = friends[node[1]][node[0]] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    friends[k][j] = Math.min(friends[k][i] + friends[i][j], friends[k][j]);
                }
            }
        }
        int minSum=987654321;
        int answer=0;
        for(int i=1;i<=N;i++){
        int sum=0;
            for(int j=1;j<=N;j++){
                sum +=friends[i][j];
            }
            if(minSum>sum){
                minSum=sum;
                answer=i;
            }
            else if(minSum==sum){
                answer= Math.min(answer,i);
            }
        }
        System.out.println(answer);
    }
}
