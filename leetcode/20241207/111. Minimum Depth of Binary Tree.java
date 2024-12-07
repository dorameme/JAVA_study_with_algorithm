/*
start:22:20
end:22:35
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 
몇가지 문제가 있었는데 BFS로 풀었는데 원래 트리 구조를 수정하는 것은 트리의 다른 작업에 영향을 줄 수 있으므로 일반적으로 좋은 방법이 아니다.
변수 이름 'pq'는 우선순위 큐를 의미하지만 실제로는 일반 큐로 LinkedList를 사용하고 있다.,,
따라서 수정이 필요 그리고 dfs로도 풀수는 있다. 여기선 bfs가 더 낫긴한데 첨부해두겠다.

그리고 참고로 LinkedList쓸때
용량 제한있을 때 동작
offer(): 용량이 찼을 때 false 반환
add(): 용량이 찼을 때 IllegalStateException 발생

사용 맥락
offer(): 용량 제한된 큐에 더 적합
add(): Collection 인터페이스에서 상속받은 메서드로, 일반적인 컬렉션 사용에 적합

안전성
offer(): "더 안전한" 메서드로 간주됨 (예외 발생 대신 false 반환) // -> 예외반환 x
add(): 예외를 던지므로 예외 처리가 필요할 수 있음

LinkedList나 일반적인 Queue 구현체에서는 둘 다 잘 작동(용량 제한이 없으므로)
하지만 bounded queue(용량 제한이 있는 큐)를 사용할 때는 offer()가 더 안전한 선택
Queue 인터페이스를 사용할 때는 일반적으로 offer()를 권장함!!!
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // -> 이렇게 levelSize 를 두면 val 을 바꾸지 않아도 된다.
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                // If we find a leaf node, this is the minimum depth
                if (current.left == null && current.right == null) {
                    return depth;
                }
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            depth++;
        }
        
        return depth;
    }
}

//DFS
public static int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
}
//내 코드

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode head = root;
        head.val = 1;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(head);
        int depth = 0;
        while (!pq.isEmpty()) {
            TreeNode cur = pq.poll();
            if (cur.left == null && cur.right == null) {
                depth = cur.val;
                break;
            }
            if (cur.right != null) {
                cur.right.val = cur.val + 1;

                pq.add(cur.right);
            }
            if (cur.left != null) {
                cur.left.val = cur.val + 1;
                pq.add(cur.left);
            }
        }
        return depth;
    }
}
