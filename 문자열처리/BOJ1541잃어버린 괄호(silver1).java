/*
 * start:13:03
 * end:13:24
 * 시간복잡도:O(N)
 * 공간복잡도:O(N)
 * 풀이: 문자열을 처리해서 푸는문제였다. 정규식을 쓸줄알면 더 쉬운문제 
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Integer> dq =
            (Deque<Integer>) Arrays.stream(str.split("[+-]")).map(Integer::valueOf).collect(
                Collectors.toCollection(ArrayDeque::new));
        int answer = dq.pollFirst();
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                minus = true;
                answer -= dq.pollFirst();
            } else if(str.charAt(i) == '+') {
                if (minus == true) {
                    answer -= dq.pollFirst();
                } else {
                    answer += dq.pollFirst();
                }
            }
        }
        System.out.println(answer);
    }
}

clean ver 

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        
        // 숫자만 추출하여 Deque에 저장
        Deque<Integer> numbers = Arrays.stream(expression.split("[+-]"))
            .map(Integer::valueOf)
            .collect(Collectors.toCollection(ArrayDeque::new));
        
        int result = numbers.pollFirst(); // 첫 번째 숫자로 초기화
        boolean isMinus = false;
        
        // 식의 각 문자를 순회하며 연산 수행
        for (char operator : expression.toCharArray()) {
            if (operator == '+' || operator == '-') {
                int nextNum = numbers.pollFirst();
                
                if (operator == '-') {
                    isMinus = true;
                }
                
                // '-' 이후의 모든 수는 빼기
                result += isMinus ? -nextNum : nextNum;
            }
        }
        
        System.out.println(result);
        br.close();
    }
}
