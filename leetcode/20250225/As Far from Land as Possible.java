/*
start:16:14
end:17:14
시간복잡도:O(N*M)
공간복잡도:O(N*M)
풀이: 나는 땅에서부터 점점 거리를 퍼저나가게 + 나보다 더 거리가 큰 값을 가진곳이 있으면 작은값으로 덮어쓰게 해서 풀었다.
하지만 이 풀이는 조금 중복이 발생할 수 있다.
첫 번째 코드가 두 번째 코드보다 빠른 이유는 주요 로직에서 큐에 대한 처리가 효율적으로 이루어지기 때문이다.
두번째 코드처럼 일단 시작부분을 전부찾고 그 이후에 하나씩 퍼져나가게 풀자!! 
이 방식은 각 where문을 Queue사이즈만큼씩만 돌리며풀어주면 된다.
*/
class Solution {

    int[][] dp = new int[101][101];
    int x = 0;
    int y = 0;
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { 1, -1, 0, 0 };
    int answer = 0;
    int maxi = Integer.MAX_VALUE;
    boolean[][] vis = new boolean[101][101];

    public int maxDistance(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        LinkedList<int[]> q = new LinkedList<>();
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {// 물//결국 제일가까운 땅 찾는게임임..
                    dp[i][j]=1;
                    q.add(new int[] { i, j });// 땅으로부터 거리
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int z = 0; z < 4; z++) {
                int nx = cur[0] + dx[z];
                int ny = cur[1] + dy[z];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                    continue;// 범위
                }
                if (dp[nx][ny] <= dp[cur[0]][cur[1]] + 1) {
                    continue;
                }
                dp[nx][ny] = dp[cur[0]][cur[1]] + 1;
                q.add(new int[] { nx, ny });
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                answer = Math.max(answer,dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        if(answer== 1 || answer == Integer.MAX_VALUE ) return -1;
        return answer-1;
    }
}


///개선된 2번째 풀이

class Solution {

    int[][] dp = new int[101][101];
    int x = 0;
    int y = 0;
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { 1, -1, 0, 0 };
    int answer = -1;
    int maxi = Integer.MAX_VALUE;
    boolean[][] vis = new boolean[101][101];

    public int maxDistance(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        LinkedList<int[]> q = new LinkedList<>();
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {// 물//결국 제일가까운 땅 찾는게임임..
                    dp[i][j] = 1;
                    q.add(new int[] { i, j });// 땅으로부터 거리
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            while (size-- > 0) {
                int[] cur = q.poll();
                
                for (int z = 0; z < 4; z++) {
                    int nx = cur[0] + dx[z];
                    int ny = cur[1] + dy[z];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                        continue;// 범위
                    }
                    if (dp[nx][ny] <= dp[cur[0]][cur[1]] + 1) {
                        continue;
                    }
                    dp[nx][ny] = dp[cur[0]][cur[1]] + 1;
                    q.add(new int[] { nx, ny });
                }
            }
        }
        if(answer ==0)return -1;
        return answer;
    }
}
