/*
start:16:37
end:17:15
시간복잡도:O(N)
공간복잡도:O(N)
풀이:오늘푼 다른문제와 거의 같은문제인데 
 Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); 이런식으로
 소트하는법을 오랜만에 써서 생소하게느껴졌다.

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        ArrayList<int[]> answer=new ArrayList<>();
        answer.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            if(answer.getLast()[1]>=intervals[i][0]){
                int a= Math.min(answer.getLast()[0], intervals[i][0]);
                int b= Math.max(answer.getLast()[1], intervals[i][1]);
                answer.removeLast();
                answer.add(new int[]{a,b});
            }
            else{
                answer.add(intervals[i]);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
