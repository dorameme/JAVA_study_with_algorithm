/* 
start: 22:55 
end: 23:03 
시간복잡도: O(N) - N은 트리의 총 노드 수. 각 노드를 한 번씩 방문하고, 짝수 레벨에서 reverse() 연산을 수행
공간복잡도: O(N) - 큐에 최대 N/2개 노드(마지막 레벨), answer 리스트에 모든 노드 저장
풀이: BFS로 레벨순회하면서 짝수 레벨일때만 reverse()해서 지그재그 순서 만듦
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            level++;
            List<Integer> currentLevel = new ArrayList<>();
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            
            if (level % 2 == 0) Collections.reverse(currentLevel);
            answer.add(currentLevel);
        }
        return answer;
    }
}
