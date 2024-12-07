/* 
start: 23:08
end: 23:12
시간복잡도: O(N) - N은 트리의 노드 수. 모든 노드를 한번씩 방문 + 마지막에 리스트 한번 뒤집기
공간복잡도: O(N) - 큐에는 최대 N/2개(마지막 레벨), 결과 리스트에 모든 노드 값 저장
풀이: BFS로 레벨순회하고 마지막에 Collections.reverse()로 뒤집어서 bottom-up으로 만듦
*/
class Solution {
   public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> answer = new ArrayList<>();
       if (root == null) return answer;

       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);

       while (!q.isEmpty()) {
           List<Integer> helper = new ArrayList<>();
           int len = q.size();

           while (len-- > 0) {
               TreeNode current = q.poll();
               helper.add(current.val);
               
               if (current.left != null) {
                   q.offer(current.left);
               }
               if (current.right != null) {
                   q.offer(current.right);
               }
           }
           answer.add(helper);
       }
       Collections.reverse(answer);  // void 함수라서 뒤집고 반환
       return answer;
   }
}
