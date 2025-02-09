/*
start: 14:20
end: 14:54

시간복잡도: O(m * n)  
- 각 노드(셀)에 대해 BFS를 수행하며, 한 번 방문한 셀은 다시 방문하지 않음.  
- 전체 셀 수가 m * n일 때, BFS의 탐색 과정에서 큐에 들어가는 최대 원소 수는 m * n이므로 O(m * n)이다.

공간복잡도: O(m * n)  
- `dp` 배열: O(m * n)  
- `Queue`: 최악의 경우 모든 셀을 저장할 수 있으므로 O(m * n)  
- 총 공간복잡도는 O(m * n)

풀이:  
- BFS를 이용하여 0에서 가장 가까운 1의 거리를 계산하는 문제이다.  
1. `dp` 배열을 선언하여 모든 1을 큰 값(10001)으로 초기화한다.  
2. 0인 위치를 큐에 넣고 BFS 탐색을 수행한다.  
3. 큐에서 원소를 꺼내 상하좌우로 이동하며, 현재 거리 +1이 기존 `dp` 값보다 작다면 업데이트하고 큐에 삽입한다.  
4. 모든 탐색이 끝난 후 `dp` 배열을 반환한다.  

 -> 근데 사실 num변수는 안써도된다. 그냥 dp[x][y]+1 -> dp[nx][ny] 가 되므로..
*/
class Solution {
    static int[][] dp;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {-1,1,0,0};
    public int[][] updateMatrix(int[][] mat) {
        dp= new int[mat.length][mat[0].length];
        LinkedList<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    dp[i][j]= 10001;
                else{
                    q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur= q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                int num= cur[2];
                if(nx<0||ny<0||nx>=mat.length||ny>=mat[0].length)continue;
                if(num+1 >= dp[nx][ny])continue;
                dp[nx][ny]=num+1;
                q.add(new int[]{nx,ny,num+1});

            }
        }
        return dp;
    }      
}
