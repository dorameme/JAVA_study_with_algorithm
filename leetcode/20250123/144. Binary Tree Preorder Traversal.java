/*
start:17:53
end:17:58
시간복잡도:O(N)
공간복잡도:O(N)
풀이:preorder 즉 부모 -> 왼 -> 오 순으로 리스트를 만들어 반환한다.
주의할 점은 null인지 항상 체크해 주는것!
*/
class Solution {
    List<Integer> answer = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            answer.add(root.val);
            if (root.left != null)
                preorderTraversal(root.left);
            if (root.right != null)
                preorderTraversal(root.right);
        }
        return answer;
    }
}
