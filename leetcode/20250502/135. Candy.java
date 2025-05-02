/*
start:어제꺼 복습차원으로 품
end:13:58
사간복잡도:O(N)
공간복잡도:O(N)
풀이: 너무나 아이디어가 어려웠다. 이래저래 풀어보려했는데 잘안되어서 
답을 보고 다음날 혼자 다시풀어보았다.
[조건]
각각의 아이는 최소 1개의 사탕을 받아야 한다.
성적이 높은 아이는 양 옆의 아이보다 더 많은 사탕을 받아야 한다.
조건을 만족하면서 사탕의 총 개수를 최소로 하는 것이 목표이다.

따라서 일단 나보다 앞에가 작으면 나에게 사탕을 더주고
반복문을 한번 더 돌려서 뒤에가 나보다 작으면 Max함수로 내가가진사탕이 더 크도록 분배한다.
*/

class Solution {
    public int candy(int[] r) {
        int cnt=0;
        
        int[] candies = new int[r.length];
        Arrays.fill(candies, 1);
        for(int i=1;i<r.length;i++){
            if(r[i-1]<r[i]){
                candies[i]= candies[i-1]+1;
            }
            else cnt=0;
        }
        for(int i=r.length-2;i>=0;i--){
            if(r[i+1]<r[i]){
                candies[i] = Math.max(candies[i+1]+1,candies[i]);
            }
            
        }
        int answer=0;
        for(int candy: candies){
        answer+= candy;            
        }return answer;
    }
}
