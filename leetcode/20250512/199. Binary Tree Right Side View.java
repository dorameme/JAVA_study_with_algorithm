/*
start:17:45
end:17:55
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 따로 vis배열을 쓰지않고 푸는법이 있어서 기록한다.
바로 깊이가 ans.size랑 같으면 답을 갱신하는 것이다.
깊이를 0 으로 두고 만일 깊이랑 ans 크기가 같으면 답으로 넣으면 된다!! 
*/
//개선된풀이 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) return;

        // 처음 방문한 깊이라면 추가
        if (depth == ans.size()) {
            ans.add(node.val);
        }

        // 오른쪽 먼저 방문 -> 오른쪽 뷰 우선
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }
}


class Solution {
    List<Integer> ans=new ArrayList<>();
    boolean[] depth = new boolean[101];
    public List<Integer> rightSideView(TreeNode root) {
        solve(root, 0);
        return ans;
    }
    void solve(TreeNode root,int deep){
        if(root == null)return;
        
        if(!depth[deep]){
        ans.add(root.val);
        }
        depth[deep]=true;
        solve(root.right,deep+1);
        solve(root.left, deep+1);
    }
}
