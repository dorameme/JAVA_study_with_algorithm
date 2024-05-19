공부한 날짜 2024-05-19

1. 정렬해서 비교
    point: 문자열을 문자단위로 정렬한 뒤 hashMap에 키값이 같은게 있으면 value 인 list에 add 해주었다.
    entrySet()으로 원소들을 뽑아냈다.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map= new HashMap<>();

        for(String s :strs){

            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String word = new String(chArr);
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(s);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

