/*
start:13:40
end:14:14
시간복잡도: O(N) - 각 노드를 최대 한 번씩만 방문하므로
공간복잡도: O(N) - dp 배열(N), vis 배열(N), 재귀 스택(최악의 경우 N) 필요
풀이: 1. 이미 순회한건 볼 필요없다. 2. 엣지가 -1이 아니여야한다. 
3. 돌다가 만난 아이가 같은 라운드에 만난거면 answer를 업데이트 해준다 
*/
class Solution {
    int[] dp;
    int answer = -1;
    int[] vis;
    public int longestCycle(int[] edges) {
        vis= new int[edges.length];
        dp = new int[edges.length];
        Arrays.fill(dp, -1); // 매번 초기화 필요..   
        for (int i = 0; i < edges.length; i++) {
            if (dp[i] == -1 && edges[i]!=-1 )
                startDFS(edges, i, 1,i+1);
        }
        return answer;

    }

    public void startDFS(int[] edges, int idx, int count,int round) {
        if (dp[idx] == -2 ){
            return;
        }
        if(edges[idx] == -1){
            dp[idx] = -2;
            return;
        }
        if (dp[idx] != -1  ) {// 사이클..
            if(vis[idx]==round) //만일 이번에 방문한 애면.. 이건 사이클이지~
            answer = Math.max(answer, count - dp[idx]);
            return;
        }
        dp[idx]=count;
        vis[idx]=round;
        if(edges[idx]!=-1){
            startDFS(edges, edges[idx], count + 1,round);
        }
        return;
    }
}
