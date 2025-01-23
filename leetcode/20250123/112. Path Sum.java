/*
start:17:35
end:17:50
시간복잡도:O(N)
공간복잡도:O(1)
풀이:리프노드여야한다는데 포인트 !!! 자식이 양쪽다 없고 현재값이 타겟값이면 true
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if (root.right == null && root.left == null && targetSum == root.val)return true;
        
        return hasPathSum(root.left, targetSum - root.val)||hasPathSum(root.right, targetSum - root.val);
    }
}
