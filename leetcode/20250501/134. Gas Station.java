/*
start:11:34
end:12:06
시간복잡도:O(N^2)-> O(N)
공간복잡도:O(1)
풀이: 나는 좀더 비효율적으로 풀었는데, 일단 + 로 시작하는 부분중 제일 앞에있는애들만 비교해서 풀어줬다
하지만 이렇게하지않고 어차피 중간에 안되는구간나오면 무시하고 다음꺼부터 봐주면 된다~!!
A->B->C 이러다 C에서 -가 나온다하면.. 
A 우선 시작은 무조건 +
B 따라서 B에서는 A+B이고
C 만일 C에서 전체가 -로 돌입한다면.. 당연히 마지막부분인 C는 - 고 B부터시작해도 A+B>=B이므로 가망이없다.
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // 전체 이익
        int tank = 0;    // 현재 연료 상태
        int start = 0;   // 시작 지점 후보

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            // 도중에 기름이 부족하면, 출발 지점 변경
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        // 전체적으로 연료가 부족하면 불가능
        return total < 0 ? -1 : start;
    }
}


//내풀이 
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] - cost[i] >= 0) {
                int total=0;
                for(int j=0;j<len;j++){
                    int cur= (j+i)%len;
                    total += gas[cur]-cost[cur];
                    if(total<0)break;
                    if(j==len-1)return i;
                }
                while(gas[i] - cost[i] >= 0) {
                    i++;
                    if(i==len)return -1;
                }
            }
        }
        return -1;
    }
}
