/*
start:13:20
end:13:34
시간복잡도:O(nlogn)
공간복잡도;O(n)
풀이:
문자열 변환 및 정렬: `Arrays.stream(numbers).mapToObj(String::valueOf)`로 numbers 배열을 문자열로 변환하고, `(a, b) -> (b + a).compareTo(a + b)`로 정렬한다.

문자열 합침: `collect(Collectors.joining())`로 정렬된 문자열을 하나의 문자열로 합친다.

특수 케이스 처리: 결과 문자열이 "0"으로 시작하면, 모든 숫자가 0인 경우이므로 "0"을 반환한다.
*/
import java.util.stream.*;
import java.util.*;
class Solution {

    public String solution(int[] numbers) {
             // numbers 배열을 문자열 배열로 변환 및 정렬
        String result = Arrays.stream(numbers)
                              .mapToObj(String::valueOf)
                              .sorted((a, b) -> (b + a).compareTo(a + b))
                              .collect(Collectors.joining());
        
        // 가장 큰 수가 "0"으로 시작하는 경우 "0" 반환 (예: [0, 0])
        if (result.startsWith("0")) {
            return "0";
        }

        return result;
    }
}
