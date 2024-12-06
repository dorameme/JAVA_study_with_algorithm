/*
start: 17:55
end: 18:41
시간복잡도: O(n * log(n)) - n은 문자열의 길이
공간복잡도: O(n) - 큐 사용
풀이: 문자열을 그룹으로 나누어 각 그룹의 합을 구하는 과정을 반복
1. 문자열의 각 숫자를 큐에 저장
2. 큐 크기가 k보다 클 동안 반복:
  - k개씩 그룹화하여 각 그룹의 합 계산
  - 계산된 합을 문자열로 변환하여 다시 큐에 저장
3. 최종 큐의 값들을 문자열로 변환하여 반환

근데 String t=s.substring(i,Math.min(i+k,s.length()));  로 푸는게 더 나았을듯.
괜히 더 어렵게 풀었다.
애초에 서브문자열 구할때 마지막문자열 보다 k가 큰경우 어떻게 처리하나 싶어서 이렇게풀었지만 .다음부터는 substring쓰자.
*/
class Solution {
   public String digitSum(String s, int k) {
       Queue<Integer> queue = new LinkedList<>();
       
       // 초기 문자열을 숫자로 변환하여 큐에 저장
       for(char c : s.toCharArray()) {
           queue.add(c - '0');
       }
       
       // 큐 크기가 k보다 클 동안 반복
       while(queue.size() > k) {
           Queue<Integer> tempQueue = new LinkedList<>();
           
           // k개씩 그룹화하여 합 계산
           while(!queue.isEmpty()) {
               int groupSum = 0;
               for(int i = 0; i < k && !queue.isEmpty(); i++) {
                   groupSum += queue.poll();
               }
               tempQueue.add(groupSum);
           }
           
           // 계산된 합을 문자열로 변환 후 다시 큐에 저장
           String currentSum = tempQueue.stream()
               .map(String::valueOf)
               .reduce("", String::concat);
               
           for(char c : currentSum.toCharArray()) {
               queue.add(c - '0');
           }
       }
       
       // 최종 결과를 문자열로 변환
       return queue.stream()
           .map(String::valueOf)
           .reduce("", String::concat);
   }
}

//더 나은 코드.. 
class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            String ns=""; // replace the old string with updated one
            for(int i=0;i<s.length();i+=k){
                String t=s.substring(i,Math.min(i+k,s.length())); // form the string of k size
                int sum=0;
                for(int l=0;l<t.length();l++){ // to find the character sum of string t
                    sum+=t.charAt(l)-'0';
                }
                ns+="" + sum;    //update the string with sum of k size string character                 
            }
            s=ns; //update the old string with updated one
        }
        return s;
    }
}
