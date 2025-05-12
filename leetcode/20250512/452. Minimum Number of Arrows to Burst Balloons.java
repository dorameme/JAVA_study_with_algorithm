/*
start:17:21
end:17:37
시간복잡도:O(NlgN)
공간복잡도:O(N)
풀이: 이전문제랑 비슷한데 주의할점은 비교할때 그냥 A-B를 넣는게아닌 Integer.compare(A.B);를 써줘야한다는 것이다!
왜냐면 A-B로하면 Integer오버플로우가 날 수 있다.
Integer.compare는 내부적으로 이렇게 작동하므로 오버플로우없이 안전하게 비교가 가능하다.
if (a < b) return -1;
if (a == b) return 0;
return 1;

*/
class Solution {
    public int findMinArrowShots(int[][] p) {
   
        Arrays.sort(p ,(a,b)->{return a[0]!=b[0]? Integer.compare(a[0],b[0]): Integer.compare(a[1],b[1]);});
        // Arrays.sort(p, (a, b) -> {return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);});

        int ans=1;     

        int start= p[0][0];
        int end=p[0][1];
        for(int i=1;i<p.length;i++){
            // System.out.println(start + " "+end);
            // System.out.println(p[i][0] + " "+p[i][1]);
            if(p[i][0]<=end){
                start = Math.max(start , p[i][0]);
                end = Math.min(end , p[i][1]);
            }
            else{
                ans++;
                start= p[i][0];
                end= p[i][1];
            }
        }
        return ans;
    }
}
