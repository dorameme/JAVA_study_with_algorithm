/*
start:11:45
end:12:15
시간복잡도:O(N)
공간복잡도:O(N)
풀이:나는 복잡하게 풀었는데 이거 밑의 클린코드를 참고해서 풀면 더 좋을듯 하다.
더미노드를 두는게 초기화과정을 줄여줘서 더 편하게 풀수있다는 점도 알고가자!
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = l1;
        int carry = 0;
        while (l1!= null || l2 != null ) {
            l1.val += l2.val+ carry;
            carry = l1.val/10;
            l1.val %=10;
            if(l1.next == null && l2.next== null){
                break;
            }
            else if(l1.next==null){
                l1.next =l2.next;
                break;
            }
            else if(l2.next==null){
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(carry!=0){
            if(carry!=0){
                if( l1.next==null)
                l1.next= new ListNode();
                l1= l1.next;
            }
            l1.val += carry;
            carry = l1.val/10;
            l1.val %=10;
        }
        return answer;
        }
}


//클린코드 
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(0);  // 더미 노드 생성
    ListNode current = dummyNode;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        carry = sum / 10;
        current.next = new ListNode(sum % 10);
        current = current.next;
    }

    return dummyNode.next;  // 결과 연결 리스트 반환
}
