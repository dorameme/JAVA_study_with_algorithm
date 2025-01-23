/*
start:17:30
end:17:35
시간복잡도:O(N)
공간복잡도:O(1)
풀이:최소 2개이상의 노드가있을때 분석할 가치가있다.
만일 둘이 같으면 현재값 -> 다음 다음값 으로 수정해준다.
위에는 그냥 while문으로 조건으로 푼 버전.
밑에 다른 풀이도 첨부 이건 재귀적으로푼 버젼이다.
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode solve= head;
        while(solve!=null && solve.next!=null){
            if(solve.val==solve.next.val){
                solve.next= solve.next.next;
            }
            else{
                solve= solve.next;
            }
        }
        return head;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null || head.next==null)return head;
        head.next = deleteDuplicates(head.next);//앞의 값에 대해서도 중복을 없애줌
       return head.val == head.next.val? head.next:head; //현재값이 다음값하고 같면 없앰
    }
}
