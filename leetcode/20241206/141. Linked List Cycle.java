/*
start: 16:46
end: 17:03
시간복잡도: O(n) - 리스트의 노드 수만큼 순회
공간복잡도: O(1) - 추가 공간 상수만 사용
풀이: 방문한 노드를 특수값(-999999)로 표시하여 사이클 탐지
   재귀적으로 연결 리스트를 순회하면서:
  - null이면 사이클 없음
  - 이미 -999999값을 가진 노드를 만나면 사이클 있음
  - 현재 노드값을 -999999로 변경하고 다음 노드로 재귀 호출
근데 플로이드의 토끼와 거북이 (Floyd tortoise and hare)로 푸는게 정석이라고 한다.
원래 노드를 수정하지 않는 방식! 구현법은 아래 첨부

<플로이드 토끼와 거북이 알고리즘 해법>
Cycle 이 존재하는 Linked List 에 토끼와 거북이가 있을 때,

1. 토끼는 한번에 2칸씩, 거북이는 한번에 1칸씩 이동하면 언젠가 둘이 만난다

2. 둘이 만났을 때, 거북이를 시작점으로 옮긴 뒤, 둘다 1칸씩 이동하다 보면 사이클의 시작점에서 다시 만난다.

[출처] 플로이드의 토끼와 거북이 (Floyd tortoise and hare)|작성자 occidere


*/
public class Solution {
   private static final int VISITED_MARK = -999999;
   
   public boolean hasCycle(ListNode head) {
       // 빈 리스트나 마지막 노드인 경우
       if(head == null) return false;
       
       // 이미 방문한 노드를 만난 경우
       if(head.val == VISITED_MARK) return true;
       
       // 현재 노드를 방문 표시하고 다음 노드 확인
       head.val = VISITED_MARK;
       return hasCycle(head.next);
   }
}
//개선된 버전 -> 플로이드 알고리즘
public boolean hasCycle(ListNode head) {
    if(head == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast) return true;
    }
    
    return false;
}
