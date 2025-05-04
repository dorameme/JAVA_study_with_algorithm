/*
start:15:30
end:15:40
시간복잡도:O(N)
공간복잡도:O(1)
풀이: 나는 일일이 경우의수를 다 따져서 풀어줬는데, 그럴필요없다~~!
아래와같이 맵에 넣고 풀어주면 더 수월하다. 다시느끼지만 문제를 완벽하게 이해하는것이 중요하다..
*/
//개선된 풀이
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> m =new HashMap<>();
        int len = s.length();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int answer=0;
        for(int i=0;i<len;i++){
            if(i<len-1 && m.get(s.charAt(i))<m.get(s.charAt(i+1))){
                answer-= m.get(s.charAt(i));
            }else{
                answer+= m.get(s.charAt(i));
            }
        }return answer;
    }
}

class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    answer += 4;
                    i++;
                    continue;
                }
                if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    answer += 9;
                    i++;
                    continue;
                }
                answer += 1;
            } else if (s.charAt(i) == 'V')
                answer += 5;
            else if (s.charAt(i) == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    answer += 40;
                    i++;
                    continue;
                }
                if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    answer += 90;
                    i++;
                    continue;
                }
                answer += 10;
            } else if (s.charAt(i) == 'L')
                answer += 50;
            else if (s.charAt(i) == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    answer += 400;
                    i++;
                    continue;
                }
                if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    answer += 900;
                    i++;
                    continue;
                }
                answer += 100;
            } else if (s.charAt(i) == 'D')
                answer += 500;
            else if (s.charAt(i) == 'M')
                answer += 1000;
        }
        return answer;
    }
}
