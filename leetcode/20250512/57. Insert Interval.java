/*
start:14:00
end:14:18
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 좀더 깔끔하게 풀려면 처음부터 ArrayList를 선언한뒤 in , t 에 있는 모든걸 넣고 새로만드는게 더 쉽다 
그래서 첫풀이, 개선된 풀이 두개를 첨부함.
*/
//개선된 풀이
class Solution {
    public int[][] insert(int[][] in, int[] ne) {
        int len =in.length;
        ArrayList<int[]> arr =new ArrayList<>();
        arr.add(ne);
        for(int i=0;i<len;i++){
            arr.add(in[i]);
        }
        arr.sort((a,b)->{return a[0]!=b[0]? a[0]-b[0]: a[1]-b[1];});
        
        ArrayList<int[]> ans =new ArrayList<>();
        int start=arr.get(0)[0];
        int end=arr.get(0)[1];
        for(int i=1;i<len+1;i++){
            int[] cur =arr.get(i);
            if(end<cur[0]){//이전꺼랑 안겹침
                ans.add(new int[]{start,end});
                start= cur[0];
                end= cur[1];
                continue;
            }
            //겹침
            start= Math.min(start, cur[0]);
            end= Math.max(end, cur[1]);
        }
        ans.add(new int[]{start,end});
        int[][] answer = new int[ans.size()][2];
        
        for(int i=0;i<ans.size();i++){
            answer[i]= ans.get(i);
        }
        return answer;
    }
}

class Solution {

    public int[][] insert(int[][] in, int[] t) {
        int len = in.length;
        if (len == 0) {
            return new int[][]{t};
        }
        if (in[0][0] > t[1] || in[len - 1][1] < t[0]) {
            int[][] ans = new int[len + 1][2];
            if (in[0][0] > t[1]) {
                ans[0] = t;
                for (int i = 1; i < len + 1; i++) {
                    ans[i] = in[i-1];
                }
            }
            if (in[len-1][1] < t[0]) {
                ans[len] = t;
                for (int i = 0; i < len ; i++) {
                    ans[i] = in[i];
                }
            }
            return ans;
        }
        ArrayList<int[]> arr = new ArrayList<>();
        boolean flag= false;
        for (int i = 0; i < len; i++) {
            if (t[1] < in[i][0] || t[0] > in[i][1]) {

                arr.add(in[i]);
                continue;
            } else {
                flag=true;
                int start = Math.min(in[i][0], t[0]);
                int end = Math.max(in[i][1], t[1]);
                while (i < len && !(t[1] < in[i][0] || t[0] > in[i][1])) {
                    start = Math.min(in[i][0], start);
                    end = Math.max(in[i][1], end);
                    i++;
                }
                arr.add(new int[]{start, end});
                i--;
            }
        }

        if(flag==false){
            arr.add(t);
            arr.sort((a,b)-> {return a[0]!=b[0]?a[0]-b[0]:a[1]-b[1];});
        }
        int[][] ans = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
