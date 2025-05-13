/*
start:12:11
end:12:23
시간복잡도:O(N)
공간복잡도:O(N)
풀이: 서로 pair가 되는애들을 맵에 넣어풀면  훨씬 간결한 풀이가된다.
그리고 deque을 쓰는방식 -> stack일땐 push pop / queue일땐 add remove

*/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> d=new LinkedList<>();
        Map<Character,Character> m= new HashMap<>();
        m.put(')','(');
        m.put(']','[');
        m.put('}','{');

        for(int i=0;i<s.length();i++){
            Character c =s.charAt(i);
            if(m.containsKey(c)){
               if(d.isEmpty() || d.pollLast() != m.get(s.charAt(i))){
                   return false;
               }
            }
            else{
                d.addLast(c);
            }
        }
        return d.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> d=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== ')'){
                if(d.isEmpty() || d.peekLast()!= '(')return false;
                d.pollLast();
            }
            else if(s.charAt(i)== ']'){
                if(d.isEmpty() || d.peekLast()!= '[')return false;
                d.pollLast();
            }
            else if(s.charAt(i)== '}'){
                if(d.isEmpty() || d.peekLast()!= '{')return false;
                d.pollLast();
            }
            else{
                d.add(s.charAt(i));
            }
        }
        if(d.isEmpty())return true;
        return false;
    }
}
