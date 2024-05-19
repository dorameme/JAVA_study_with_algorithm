공부한 날짜 2024-05-19

1. 전처리 작업 후 개수 처리 및 추출
    point: 정규표현식를 다루는 법을 더 공부할 수 있었다.
    +는 한개이상을 뜻한다. []는 문자셋을 의미한다.
    replaceAll("[^a-z]"," "); -> 알파벳이 아니면 다 공백으로 바꾼뒤 split("\\s+")이런 식으로 공백 다잡아 줬는데
    replaceAll("[\\W+]"," "); -> 이렇게 하면 따로 split에서 " " 이렇게만 써도 된다.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph= paragraph.toLowerCase();
        paragraph= paragraph.replaceAll("[^a-z]"," ");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> map =new HashMap<>();
        Set<String> ban =new HashSet<>();

        for(String s : banned){
            ban.add(s);
        }
        ban.add(" ");
        for(String s : words){
            if(!ban.contains(s))
                map.put(s,map.getOrDefault(s,0)+1);
        }//map엔트리셋에서 maxr값을 찾는데 비교기준은 Map.Entry.comparingByValue...->여기서 key를 뽑아냄
        return Collections.max(map.entrySet() , Map.Entry.comparingByValue()).getKey();
    }
}