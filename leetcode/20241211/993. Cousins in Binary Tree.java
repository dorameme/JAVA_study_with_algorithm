/*
start: 12:15  
end: 12:45
시간복잡도: O(N) - 트리의 모든 노드를 한 번씩 방문함 (DFS 사용)  
공간복잡도: O(H) - H는 트리의 높이, 재귀 호출 스택에 의해 소비되는 메모리  
풀이: DFS를 사용하여 트리의 각 노드를 탐색하며, 노드 x와 y의 부모와 깊이를 추적.
두 노드의 깊이가 같고 부모가 다르면 사촌 노드로 간주

아직 x나 y 가 발견되기 전에는 부모가 null이니 무조건 parentX != parentY가 true가 되므로
바로뒤에 parentY != null parentX != null 조건을 추가해줘야한다는게 포인트!!
*/

class Solution {
    int depthX; // x 노드의 깊이를 저장
    int depthY; // y 노드의 깊이를 저장
    TreeNode parentY; // y 노드의 부모를 저장
    TreeNode parentX; // x 노드의 부모를 저장

    public boolean isCousins(TreeNode root, int x, int y) {
        // DFS 탐색 시작, 초기 부모는 root로 설정, 깊이는 0부터 시작
        return isCousins(root, root, x, y, 0);
    }

    public boolean isCousins(TreeNode before, TreeNode root, int x, int y, int depth) {
        if (root == null) 
            return false; // 더 이상 탐색할 노드가 없는 경우 종료

        if (root.val == x) {
            depthX = depth;
            parentX = before; 
            if (depthX == depthY && parentX != parentY && parentY != null) {
                return true;
            }
            return false; // 아직 y가 발견되지 않았거나 조건을 만족하지 못함
        }

        if (root.val == y) {
            depthY = depth; 
            parentY = before;
            if (depthX == depthY && parentX != parentY && parentX != null) {
                return true;
            }
            return false; // 아직 x가 발견되지 않았거나 조건을 만족하지 못함
        }

        // 왼쪽 자식과 오른쪽 자식을 탐색
        return isCousins(root, root.right, x, y, depth + 1) || 
               isCousins(root, root.left, x, y, depth + 1);
    }
}
