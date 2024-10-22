/*
* start:10:26
* end:10:50
* 시간복잡도:O(N^N)
* 공간복잡도:O(N)
* 풀이: 
1. For printing arrays, always use Arrays.toString() (or Arrays.deepToString() for multi-dimensional arrays) to get a readable output.
2. The plain .toArray() returns Object[], which can't be automatically cast to String[].
  so you can write like ->  strs = Arrays.stream(strs).sorted().toArray(String[]::new);
* */

import static java.util.Arrays.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }
        int answer= N;
        strs = Arrays.stream(strs).sorted().toArray(String[]::new);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(strs[i].length()<=strs[j].length() && strs[i].equals(strs[j].substring(0,strs[i].length()))){
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}



//clean version
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(countUniqueStrings(readInput()));
    }
    
    // 입력 처리를 별도 메서드로 분리
    private static String[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        
        return strings;
    }
    
    // 핵심 로직을 별도 메서드로 분리
    private static int countUniqueStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return 0;
        }
        
        // 정렬된 배열 생성
        String[] sortedStrings = Arrays.stream(strings)
                                     .sorted()
                                     .toArray(String[]::new);
        
        int uniqueCount = strings.length;
        
        // 접두어 검사
        for (int i = 0; i < sortedStrings.length; i++) {
            String current = sortedStrings[i];
            
            for (int j = i + 1; j < sortedStrings.length; j++) {
                if (isPrefix(current, sortedStrings[j])) {
                    uniqueCount--;
                    break;
                }
            }
        }
        
        return uniqueCount;
    }
    
    // 접두어 검사 로직을 별도 메서드로 분리
    private static boolean isPrefix(String shorter, String longer) {
        return shorter.length() <= longer.length() && 
               longer.startsWith(shorter);
    }
}
