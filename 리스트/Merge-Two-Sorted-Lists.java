/**
start:10:30
end:11:03
시간복잡도: O(n)
공간복잡도: O(n)
풀이: 노드를 연결하는게 헷갈려서 어려웠다.. ㅠㅠ 재귀구조로도 해결할수 있다는 점 유의!
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {         
        ListNode answer = new ListNode();
        ListNode helper= answer;

        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                helper.next=list2;
                list2=list2.next;
            }
            else{
                helper.next=list1;
                list1=list1.next;
            }
            helper=helper.next;
        }
        if(list1 != null){
            helper.next = list1;
        }
        else{
            helper.next = list2;
        }
        return answer.next;
    }
}
