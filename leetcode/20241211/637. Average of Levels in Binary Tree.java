/*
start: 12:55  
end: 13:07  
시간복잡도: O(N) - 트리의 모든 노드를 한 번씩 방문하기 때문이다.  
공간복잡도: O(W) - W는 트리의 최대 너비이며, 이는 BFS 과정에서 큐에 저장되는 최대 노드 수 때문이다.  
풀이:  
1. BFS(너비 우선 탐색)를 사용하여 각 레벨별로 노드를 탐색한다.  
2. 각 레벨의 노드 값을 모두 합산한 후, 해당 레벨의 노드 개수로 나누어 평균을 계산한다.  
3. 계산된 평균 값을 리스트에 추가하고, 모든 레벨에 대한 탐색이 완료되면 결과를 반환한다.  
*/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Double> answer= new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len= q.size();
            Double total= 0.0;
            int div= len;
            while(len-->0){
                TreeNode cur= q.poll() ;
                total += cur.val;
                if(cur.left!= null){
                    q.add(cur.left);
                }
                if(cur.right!= null){
                    q.add(cur.right);
                }
            }
            answer.add(total/div);
        }return answer;
    }
}
