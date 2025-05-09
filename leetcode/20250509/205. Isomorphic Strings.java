
/*
start:13:20
end:13:44
시간복잡도:O(N)
공긴복잡도:O(N)
풀이: 동형인지 보는것이므로 둘이 서로가 매핑되어야한다!!!~
*/

//개선된풀이
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] mapST = new char[256]; // s -> t
        char[] mapTS = new char[256]; // t -> s

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (mapST[cs] == 0 && mapTS[ct] == 0) {
                mapST[cs] = ct;
                mapTS[ct] = cs;
            } else {
                if (!(mapST[cs] == ct && mapTS[ct] == cs)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] arr = new char[200];
        boolean[] vis= new boolean[200];
        for (int i = 0; i < s.length(); i++) {
             if(vis[t.charAt(i)]){
                if(arr[s.charAt(i)]!= t.charAt(i))return false;
                continue;
            }
            arr[s.charAt(i)] = t.charAt(i);
            vis[ t.charAt(i)]=true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] != t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
