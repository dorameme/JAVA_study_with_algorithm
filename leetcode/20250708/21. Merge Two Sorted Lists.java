/*
start: 12:30
end: 12:38
시간복잡도: O(n + m) — n은 list1의 길이, m은 list2의 길이
공간복잡도: O(n + m) — 재귀 호출 스택 사용 (첫 번째 풀이 기준)
풀이: 1번째 풀이가 재귀 방식으로 더 간결하며 가독성이 높음. 
      2번째 풀이는 반복문 기반으로 스택 오버플로우 걱정이 없고 효율적임.
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        
        if(list1.val<list2.val){
           list1.next= mergeTwoLists(list1.next, list2);
            return list1;
        }
         list2.next= mergeTwoLists(list1, list2.next);
         return list2;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node= new ListNode(); 
        ListNode head= node;
        
        while(list1!=null || list2!=null){
            if(list1==null){
                node.next= list2;
                break;
            }
            if(list2==null){
                node.next= list1;
                break;
            }
            if(list1.val< list2.val){
                node.next= list1;
                node= node.next;
                list1= list1.next;
            }else{
                node.next= list2;
                node= node.next;
                list2= list2.next;
            }
        }
        return head.next;
    }
}
