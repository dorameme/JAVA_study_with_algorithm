/*
start: 19:32
end: 19:59
시간복잡도: O(N)  
공간복잡도: O(N)  
풀이: 
1. 주어진 연결 리스트의 깊은 복사본을 만드는 문제이다. 
2. 재귀적으로 각 노드를 방문하며, 원본 노드를 키로 하고 복사된 노드를 값으로 하는 해시맵을 사용하여 중복 복사를 방지한다.
3. 현재 노드가 이미 복사된 경우, 해시맵에서 해당 노드를 반환한다.
4. 현재 노드가 복사되지 않은 경우, 새로운 노드를 생성하고 해시맵에 저장한 후, next와 random 포인터를 재귀적으로 복사한다.
5. 이 방법을 통해 모든 노드를 한 번씩만 방문하므로 시간복잡도는 O(N)이다. 해시맵을 사용하여 공간복잡도도 O(N)이다.
*/
class Solution {
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        if(map.containsKey(head))return map.get(head);
        Node node= new Node(head.val);
        map.put(head,node);
        node.next= copyRandomList(head.next);
        node.random= copyRandomList(head.random);
        return node;
    }
}
