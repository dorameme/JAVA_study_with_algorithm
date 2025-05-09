/*
start:16:20
end:16:40
시간복잡도:O(NM)
공간복잡도:O(NM)
풀이:
int[]는 equals()를 오버라이딩하지 않는다
int[]는 Java에서 참조 타입이지만, equals() 메서드를 오버라이딩하지 않았기 때문에 ==과 동일하게 참조(주소) 를 비교한다. 
따라서 값이 같아도 객체가 다르면 equals()는 false를 반환한다.
비교하려면 Arrays.equals(); 써야해!~~
그리고 나는 먼저 다분석해서 풀었는데..
더 빠른 풀이법이있어서 첨부한다.

그리고 유의할점 
            // String str = c.toString(); -> 에러  이부분인데  c.toString() 하면 String이 아니라 참조값이 넘어가서.. new String(c)가 필요하다.
**/
//개선된 풀이
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> helper = new HashMap<>();
        
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            // String str = c.toString(); -> 에러 
            String str= new String(c);
            List<String> get = helper.getOrDefault(str, new ArrayList<>());
            get.add(s);
            helper.put(str,get);
        }
        return new ArrayList<>(helper.values());
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<int[]> arr = new ArrayList<>();
         int[] tmp;
        for (int i = 0; i < strs.length; i++) {
            tmp = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                tmp[strs[i].charAt(j)-'a']++;
            }
            arr.add(tmp);
        }
        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[strs.length];
        List<String> tmp2;
        for (int i = 0; i < strs.length; i++) {
            if (!vis[i]) {
                tmp2 = new ArrayList<>();
                tmp2.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (Arrays.equals(arr.get(i),arr.get(j)) && !vis[j]) {
                        vis[j] = true;
                        tmp2.add(strs[j]);
                    }
                }
                ans.add(tmp2);
            }
        }
        return ans;
    }

}
