/*
start: 12:30  
end: 12:46  
시간복잡도: O(4^n / sqrt(n)) 
공간복잡도: O(4^n / sqrt(n)) — 생성된 모든 트리를 저장하기 위한 공간  
풀이:  
- 재귀적으로 숫자 i를 루트로 선택하고, 왼쪽/오른쪽 서브트리를 구성하는 모든 경우의 수를 계산한다.  
- `start > end`일 때는 빈 트리를 의미하므로 `null`을 반환한다.  
- 각 숫자에 대해 왼쪽/오른쪽 서브트리의 모든 조합을 만들고, 이를 새로운 트리의 루트와 연결한다.  
- 최종적으로 가능한 모든 유니크한 BST의 리스트를 반환한다.  
*/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        for(int i=0;i<n;i++){
            generateTrees(i)
        }
    }
}



import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        // Base case: Empty tree
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every number as root
        for (int i = start; i <= end; i++) {
            // Generate all possible left and right subtrees
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);

            // Combine left and right subtrees with the current root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
