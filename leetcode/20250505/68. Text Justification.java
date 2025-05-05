/*
start:어제 밤에 시작
end:13:15
시간복잡도:O(N)
공간복잡도:O(N)
풀이:어려웠다 hard난이도이기도 했고, 고려해야할 사항이많다
그중 알고가기 좋은것은

" ".repeat(n): 공백 n개 삽입 (Java 11 이상)
이걸로 makeBlank를 대체할수있다는것!
*/


  
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        int[] blank = new int[words.length];
        int[] wordIdx = new int[words.length];
        int idx = 0;

        while (idx < words.length) {
            StringBuilder helper = new StringBuilder();
            int start = idx;
            int size = 0;
            while (idx < words.length && size + words[idx].length() <= maxWidth) {
                size += words[idx++].length() + 1; //띄어쓰기 고려
            }
            size--;
            int need = maxWidth - size;
            int distribute = idx - size;
            int startIdx = start;
            while (need-- != 0) {
                blank[startIdx++]++;
                if (startIdx >= idx - 1)
                    startIdx = start;
            }
            
        }

        List<String> ret = new ArrayList<>();
        StringBuilder helper = new StringBuilder();
        int i=0;
        while(i< words.length){
            int len= words[i].length();
            StringBuilder s= new StringBuilder();
            s.append(words[i]);
            while(len<=maxWidth){
                if(i+1<words.length && len+1+ words[i+1].length()<= maxWidth){
                    len= len+1+ words[i+1].length();
                    s.append(makeBlank(blank[i]+1)+ words[i+1]);
                    i++;
                    
                }
                else{
                    if(i==words.length-1){
                        String[] more= s.toString().split(" +");
                        StringBuilder last=new StringBuilder(more[0]);
                        for(int j=1;j<more.length;j++){
                            last.append(" " + more[j]);
                        }
                        while(last.length()<maxWidth){
                            last.append(" ");
                        }
                        ret.add(last.toString());
                        return ret;
                    }
                    while(s.length()<maxWidth){
                        s.append(" ");
                    }
                    ret.add(s.toString());
                    i++;
                    break;
                }
            }
        }
       return ret;
    }

    String makeBlank(int n) {
        String b = "";
        for (int i = 0; i < n; i++) {
            b += " ";
        }
        return b;
    }
}
