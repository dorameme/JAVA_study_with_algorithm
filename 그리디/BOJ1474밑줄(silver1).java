/*
 * start:10:41
 * end:12:00
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이:
 Key Strategy

Equal Distribution First
Distribute the available spaces equally among all gaps
Calculate: baseSpaces = totalNeededSpaces / (wordCount - 1)


Handle Remaining Spaces
If there are remaining spaces after equal distribution
Calculate: remainingSpaces = totalNeededSpaces % (wordCount - 1)


Priority Queue Approach
Create a priority queue based on word characteristics
Prioritize lower case words first, then upper case words
Only use as many positions from the queue as needed (remainingSpaces)
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nm[0];
        int M = nm[1];
        int wordsLen = 0;
        String[] words = new String[N];
        LinkedList<Integer> lowerCase = new LinkedList<>();
        LinkedList<Integer> upperCase = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            wordsLen += words[i].length();
            if (i > 0 && words[i].charAt(0) >= 'a') {
                lowerCase.add(i);
            } else {
                upperCase.addFirst(i);
            }
        }
        LinkedList<Integer> dash = new LinkedList<>(lowerCase);
        dash.addAll(upperCase);
        int need = M - wordsLen;
        int defalut = need / (N - 1);//모두 이정도는 가지고 있어야한다.
        int add = need % (N - 1);//새로 변수를 할당하는게 안전하다.
      
        while(dash.size()>add){
            dash.removeLast();//
        }

        for (int i = 0; i < N; i++) {
            if (dash.contains(i)){
                System.out.print('_');
            }
            System.out.print(words[i]);
            for (int j = 0;i!=N-1 && j < defalut; j++) {
                System.out.print('_');
            }
        }
    }
}
