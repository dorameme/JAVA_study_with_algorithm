
/*
start:19:59
end:20:43
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 위는 틀린풀이 아래는 맞는 풀이다.
내가 틀린이유는 정확히 같은 깊이의 노드끼리 덮어씌워져서 였다 ㅠㅠ 
깊이를 기준으로하는것이아닌 노드를 기준으로 풀어줘야한다는 것이 포인트!!!!!!!
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] dp =new int[1000];
    public int rob(TreeNode root){
        Arrays.fill(dp,-1);
        return rob(root,0);
    }
    public int rob(TreeNode root,int dep) {
        if(root==null) return 0;
        if(dp[dep]!=-1)return dp[dep];
        dp[dep]=root.val;
        if(root.left!=null){
           dp[dep] += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
          dp[dep] += rob(root.right.left)+rob(root.right.right);
        }
        return dp[dep] = Math.max(dp[dep], rob(root.left) + rob(root.right));
    }
}
class Solution {
    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int val = root.val;

        // 손자 노드들의 값을 더함
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        // 자식 노드들을 선택하는 경우와 비교
        int result = Math.max(val, rob(root.left) + rob(root.right));
        memo.put(root, result);

        return result;
    }
}
