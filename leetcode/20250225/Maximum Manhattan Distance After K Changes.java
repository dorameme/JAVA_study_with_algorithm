/*
start:13:54
end: 14:57
시간복잡도:O(N)
공간복잡도:O(N)
풀이:나는 좀 어렵고 복잡하게 풀어서 더 개선된 코드를 밑에 첨부한다.!!
*/
class Solution {
    public int maxDistance(String st, int k) {
        
        int n = 0, s = 0, e = 0, w = 0;
        int max = 0;
       
        for (char c : st.toCharArray()) {
            if (c == 'N') {
                n++;
            } else if (c == 'S') {
                s++;
            } else if (c == 'E') {
                e++;
            } else {
                w++;
            }
            max = Math.max(max, n + e - w - s + 2 * Math.min(s + w, k));
            max = Math.max(max, n + w - s - e + 2 * Math.min(s + e, k));
            max = Math.max(max, s + e - n - w + 2 * Math.min(n + w, k));
            max = Math.max(max, s + w - n - e + 2 * Math.min(n + e, k)); //-> 되는 조합이 4개 밖에 없음!! n,e를 모두 없애는 경우..혹은 k개 만큼 없애는 경우!!
        }

        return max;
    }
}

class Solution {

    public int maxDistance(String s, int K) {

        int[] dp = new int[4];
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = i;
            if (s.charAt(len) == 'N') {
                dp[0]++;
            } else if (s.charAt(len) == 'S') {
                dp[1]++;
            } else if (s.charAt(len) == 'W') {
                dp[2]++;
            } else {
                dp[3]++;
            }
            int N = dp[0], S = dp[1], W = dp[2], E = dp[3];
            int big1 = dp[0] > dp[1] ? dp[0] : dp[1];
            int small1 = dp[0] <= dp[1] ? dp[0] : dp[1];

            int big2 = dp[2] > dp[3] ? dp[2] : dp[3];
            int small2 = dp[2] <= dp[3] ? dp[2] : dp[3];


            int k = K > i? i : K;
            big1 = big1+k>i+1? i+1: big1+k;
            if (small1 >= k) {
                small1 -= k;
                k = 0;
            } else {
                k -= small1;
                small1 = 0;
            }
          
            if (small2 >= k) {
                small2 -= k;
                k = 0;
            } else {
                k -= small2;
                small2 = 0;
            }
            if (big2 >= k) {
                big2 -= k;
                k = 0;
            } else {
                k -= big2;
                big2 = 0;
            }
            answer = Math.max(answer, len(big1, small1, big2, small2));
        }
        return answer;
    }

    int len(int x, int y, int z, int k) {
        return Math.abs(x - y) + Math.abs(z - k);
    }
}
