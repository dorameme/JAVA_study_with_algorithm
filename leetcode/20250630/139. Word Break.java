/*
start:20:21
end:20:30
시간복잡도: O(N^3 + N * W * L)
 - N: 문자열 s의 길이
 - W: wordDict의 단어 개수
 - L: 단어의 평균 길이
 - 첫 번째 3중 루프는 최대 O(N * W * L)
 - 두 번째 3중 루프는 dp[i][j] 조합을 확인하는 데 O(N^3)

공간복잡도: O(N^2)
 - 2차원 dp 배열을 사용하여 s[i..j]가 단어 조합 가능한지를 저장함
풀이: 근데 및에 첨부한 개선된 풀이가 훨씬쉽다 그냥 Set사용해서 중복없애고 푸는형식!~!
*/
//개선된풀이
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {             // i는 1부터 s.length()까지
            for (int j = 0; j <= i; j++) {                   // j는 0부터 i-1까지
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[301][301];
        for (int m = 0; m < s.length(); m++) {
            for (int i = 0; i < wordDict.size(); i++) {
                String str = wordDict.get(i);
                for (int k = 0; k < str.length() && m + k < s.length(); k++) {
                    if (str.charAt(k) != s.charAt(m + k)) {
                        break;
                    }
                    if ( k == str.length()-1) {
                        dp[m][m + k] = true;
                    }
                }

            }
        }
        boolean ans = false;
        for (int i = 0; i < s.length(); i++) {
            for (int m = i; m < s.length(); m++) {
                for (int k = 0; i+ k+1 < s.length(); k++) {
                    if (dp[i][i+k] && dp[i+k+1][m]) {
                        dp[i][m] = true;
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
