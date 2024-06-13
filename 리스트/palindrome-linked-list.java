/*
공부한 날짜: 2024-06-13
시간복잡도:O(n)
공간복잡도:O(n)
풀이: 나는 그냥 List로 반 나누고 reverse 시켜서 풀었는데
러너를 쓰면(1배로 움직이기,2배로 움직이기) 어떠한 콜렉션을 쓸 필요 없어서 더 성능을 월등하게 만들 수 있다.
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(true){
            if(head==null){break;}
            list.add(head.val);
            head=head.next;
        }

        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        if(list.size()%2==0){
            list1 = list.subList(0, list.size() / 2);
            list2 = list.subList(list.size() / 2, list.size());
        }else{
            list1 = list.subList(0, list.size() / 2);
            list2 = list.subList(list.size() / 2+1, list.size());
        }
        return list1.equals(list2.reversed());
    }
}
