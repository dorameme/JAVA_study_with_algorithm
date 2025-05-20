/*
start:18:03
end:18:20
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 위가 개선된 버전인데 아래에서 쓸모없는 코드를 정리하였다.
*/
class Solution {
    public int minDeletion(String s, int k) {
        Map<Character,Integer> m =new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.merge(s.charAt(i),1,Integer::sum);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(m.values()); //바로 넣어준다.
        int answer=0;
        while(pq.size()>k){
            answer+= pq.poll();//peek -> poll로 수정
        }
        return answer;
    }
}

//원래풀이
class Solution {
    public int minDeletion(String s, int k) {
        Map<Character,Integer> m =new HashMap<>();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(!m.containsKey(s.charAt(i)))cnt++;
            m.merge(s.charAt(i),1,Integer::sum);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.addAll(m.values());
        int answer=0;
        while(pq.size()>k){
            answer+= pq.peek();
            pq.poll();
        }
        return answer;
    }
}
