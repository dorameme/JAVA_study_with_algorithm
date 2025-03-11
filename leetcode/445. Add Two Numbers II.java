/*
start:15:30
end:16:35
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 연결리스트를 맨끝부터 참조하면서 앞으로 다가가야하는데 이럴때 필요한게 stack이라는걸 빠르게눈치채면
더 쉽게풀었을것같다. 밑은 stack을 이용한 풀이다.
*/
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        // 값만 스택에 넣기
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        // 스택에서 값 빼면서 덧셈 수행
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            
            // 새 노드 앞에 삽입
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;

            carry = sum / 10;
        }

        return head;
    }
}
