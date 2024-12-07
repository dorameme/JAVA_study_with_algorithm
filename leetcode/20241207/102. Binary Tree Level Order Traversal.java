/*
start:22:35
end:22:51
시간복잡도:O(N)
공간복잡도:O(N)
풀이:이번에는 전문제와 비슷하게 BFS로 풀어보았다.
answer.add(new ArrayList<>(helper));  // helper의 복사본을 만들어 추가
helper.clear();  // 이제 clear해도 안전 -> 이부분이 이번에 깨달은건데, answer에 helper 넣어주고 클리어하면 안된다..
객체를 새로 만들어 줘야함!!
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();  
        List<List<Integer>> answer= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>(); 
      // 큐를 쓰자! 덱을 쓰는건 최소 권한의 원칙을 위반한다.
      //(인터페이스 원칙 = 필요한 것보다 더 강력한 인터페이스를 사용하지 말라)
        q.offer(root);
        while(!q.isEmpty()){
            int size= q.size();
            List<Integer> helper =new ArrayList<>();
            for(int i=0;i<size;i++){
              TreeNode current= q.poll(); 
              helper.add(current.val); 
            if(current.left !=null){
                q.offer(current.left);
            } 
            if(current.right !=null){
                q.offer(current.right);
            }
            }
            answer.add(helper);
            // helper.clear(); 이거 있으면 오답... !! 왜냐면 answer에 들어간다해도 주소가 들어가니까 ㅠㅠㅠ
        }return answer;
    }
}
