/*
start:8:50
end:10:57
시간복잡도:O(N)
공간복잡도:O(N)
풀이:새로운걸 배웠다. 일단 tmp.equals(m) 이 성립하려면 안에 foo=0도 남으면 안된다.
따라서 버킷을 remove해줄거 아니면 m에 들어있는애들만 건드려야한다.
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        int wordlen = words[0].length();
        HashMap<String, Integer> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            m.merge(words[i], 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() && i < wordlen; i++) {
            HashMap<String, Integer> tmp = new HashMap<>();
            for (int j = i; j + wordlen <= s.length() && j + wordlen <= i + (len) * (wordlen); j += wordlen) {
                String next = s.substring(j, j + wordlen);
                if (m.getOrDefault(next, 0)!=0)
                tmp.merge(next, 1, Integer::sum);
            }
            if ( tmp.equals(m)) {
                ans.add(i);
            }
            for (int j = i ;  j  + wordlen*(1+len) <= s.length(); j += wordlen) {
                System.out.println(j+" "+(j  + wordlen*(len) ));
                String before = s.substring(j, j+wordlen );
                String  next = s.substring(j +wordlen*len, j +(wordlen*(1+len)));
                if (m.getOrDefault(before, 0)!=0)
                    tmp.merge(before,-1, Integer::sum);
                if ( m.getOrDefault(next, 0)!=0)
                    tmp.merge(next, 1, Integer::sum);
                if (tmp.equals(m)) {
                    ans.add( j+wordlen);
                }
            }
        }
        return ans;
    }
}
