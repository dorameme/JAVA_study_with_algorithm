/*
start:11:50
end:12:40
시간복잡도:O(nlgn)
공간복잡도:O(n)
풀이: 개선된풀이는 순열 사이클 분할로 풀었는데 코드가 맘에들어주석으로 설명하겠다.
정수 배열 nums가 주어질 때,
각 숫자를 "자릿수의 합"을 기준으로 정렬하되,
동일한 자릿수 합이면 숫자의 크기 오름차순으로 정렬.
정렬을 위해 최소 몇 번의 swap이 필요한지 구하는 문제
*/

//개선된 풀이
class Solution {

    public int minSwaps(int[] n) {

        int[][] nums = new int[n.length][3];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = helper(n[i]);
            nums[i][1] = n[i];
            nums[i][2] = i; //인덱스 0,1 로 어레이를 소트하고 2에서 위치값을 가지도록 한다.

        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        boolean[] vis=new boolean[n.length];
        int answer = 0;
        for(int i=0;i<n.length;i++){
            if(vis[i])continue;
            int j=i;
            int cycle=0;
            while(!vis[j]){
                vis[j]=true;
                j = nums[j][2];// 현재 인덱스의 값이 어느 인덱스에 있는지! 
                cycle++;
            }
            answer += cycle-1;
        }
        return answer;
    }

    public int helper(int num) {
        int total = 0;
        while (num != 0) {
            total += num % 10;
            num /= 10;
        }
        return total;
    }
}

class Solution {
    public int minSwaps(int[] nums) {
        int answer=0;
        int[] tmp= new int[nums.length];
        HashMap<String, Integer> m=new HashMap<>();
       
        for(int i=0;i<nums.length;i++){
            tmp[i]= helper(nums[i]);
            m.put( tmp[i]+" "+nums[i],i);
        }
        
        PriorityQueue<int[]> pq=new  PriorityQueue<>((a,b)->{if(a[0]!=b[0])return a[0]-b[0]; return a[1]-b[1];});
        
        for(int i=0;i<nums.length;i++){
           pq.add(new int[]{tmp[i], nums[i]}); 
        } 
       
        for(int i=0;i<nums.length;i++){

           int[] cur= pq.peek();
           pq.poll();
           if(cur[1]==nums[i] && helper(nums[i])== cur[0])continue;///지금 위치에 있어야하는거              
           answer++;
           int idx = m.get(cur[0]+" "+cur[1]);/// 지금 필요한 애가 있는곳
    
           m.replace(cur[0]+" "+cur[1],i);///현재 얘를 원하는 위치로 넣고
           m.replace(helper(nums[i])+" "+nums[i], idx);// 원래있던애는 그 반대위치로
           int t= nums[idx];
           nums[idx]= nums[i];
           nums[i]= t;
       }
        return answer;  
    }
    public int helper(int num){
        int total=0;
        while(num!=0){
            total+=num%10;
            num/=10;
        }
        return total;
    }
}
