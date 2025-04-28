/*
start:11:12
end:11:16
시간복잡도:O(N) 
공간복잡도:O(N)->개선된 풀이 O(1)
풀이:나는 아래와 같이 풀었는데 무조건 과반수인 넘버가 있다는 가정이있으므로 아래답은 따로 자료구조를 사용하지않고
변수 2개로 풀어 훨씬 더 공간도 조금쓰고 쉽게 풀수있다! 아이디어가 대단하다고 생각했다!
*/
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer=0;
        int cnt=0;
        for (int num : nums) {
            int cur= map.merge(num, 1, Integer::sum);
           if(cur > cnt){
               cnt=  cur;
               answer= num;
           }
        }
        return answer;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
