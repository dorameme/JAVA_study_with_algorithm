/*
start:17:35
end:18:13
시간복잡도:O(NM)
공간복잡도:O(NM)
풀이:복잡하게 푼감이 없잖아있지만.. 애초에 조건도 많고 복잡한 문제였다.
같은 거리에 있는애들끼리 조건걸어서 정렬해서 풀어준다.
*/
class Solution {
    boolean[][] vis;

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        // 거리, 가격-범위, 행넘버, 열넘버
        vis = new boolean[grid.length][grid[0].length];
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        LinkedList<int[]> q = new LinkedList<>();
        q.add(start);
        vis[start[0]][start[1]] = true;
     
        
        List<List<Integer>> answer = new ArrayList<>();
        if (grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1]){
         LinkedList<Integer> helper = new LinkedList<>();
            helper.add(start[0]);
            helper.add(start[1]);
            answer.add(helper);
            k--;
        }
        while (!q.isEmpty()) {
        LinkedList<int[]> helper = new LinkedList<>();
            int size = q.size();
     
            while (size-- > 0) {
                int[] cur = q.poll();

                System.out.println(cur[0]+" "+cur[1]);
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + cur[0];
                    int ny = dy[i] + cur[1];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                        continue;
                    if (grid[nx][ny] == 0 || vis[nx][ny])
                        continue;
                    vis[nx][ny] = true;
                    if (pricing[0] <= grid[nx][ny] && grid[nx][ny] <= pricing[1])
                        helper.add(new int[] { nx, ny });

                    q.add(new int[] { nx, ny });
                }
            }
            Collections.sort(helper, (o1, o2) -> {
                if (grid[o1[0]][o1[1]] != grid[o2[0]][o2[1]]) {
                    return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
                } else if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
              if (k == 0)
                        return answer;
            if (helper.size() > 0)
                System.out.println(helper.get(0)[0]+" "+helper.get(0)[1]);
                for (int[] cur : helper) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(cur[0]);
                    tmp.add(cur[1]);
                    answer.add(tmp);
                    k--;
                    if (k == 0)
                        return answer;
                }
        }
        return answer;
    }

}
