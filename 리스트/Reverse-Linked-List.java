/**
start:12:00
end:13:00
시간복잡도:O(n)
공가복잡도:O(1)
풀이:간단히 풀수있는데 뭔가이해가 어려웠다.. 그래서 답안 참고함
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;

        while(head!=null){
            ListNode tmp = head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        } 

        return prev;
    }
}
