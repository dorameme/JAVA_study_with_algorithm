/*
start:19:59
end:20:37
시간복잡도:O(N)
공간복잡도:O(N)
풀이:슬라이딩 윈도우 문제였다.. 막 어렵지는 않은데, 개인적으로 hard난이도라그런지 조금 헷갈렸다
문제를 제대로 이해하고 구현을 잘해야함. hashmap으로 t를 구성하는 모든부분이 윈도우안에 있는지 확인하며 풀면 된다. 

*/
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mS = new HashMap<>();
        HashMap<Character, Integer> mT = new HashMap<>();
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            mT.merge(t.charAt(i), 1, Integer::sum);
        }
        int left = 0;
        int count = 0;
        int need = t.length();
        int num = 0;
        int answerL = -1;
        int answerR =-1;
        int answer = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            num = mS.merge(s.charAt(r), 1, Integer::sum);
            if (mT.getOrDefault(s.charAt(r), 0) != 0) {///타겟도 가지고있고
                if (num <= mT.getOrDefault(s.charAt(r), 0)) {
                    count++;
                } //그리고 그 수가 지금은 부족함
            }
            if (count == need) {
                while (true) {
                    int mSCnt = mS.getOrDefault(s.charAt(left), 0);
                    int mTCnt = mT.getOrDefault(s.charAt(left), 0);
                    if (mSCnt > mTCnt) {
                        mS.merge(s.charAt(left), -1, Integer::sum);
                        left++;
                    } else {//필요함 근데 이제 여분이없음
                        break;
                    }
                }
                if (answer > r + 1 - left) {
                    answerL = left;
                    answerR = r;
                    answer = r + 1 - left;
                }
            }
        }
        if(answerL==-1)return "";
        return s.substring(answerL, answerR + 1); -> substring은 오버헤드가있으니 마지막에 계산.
    }
}
