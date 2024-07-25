
# 알고리즘 문제 해결법
<details>
  <summary><strong>1. 시간 초과 문제 해결법</strong></summary>

  ### Scanner vs BufferedReader
  - **Scanner**는 다양한 기능을 포함하고 있는 무거운 클래스라 속도가 느리다.
  - 문자열 입출력에 특화된 **BufferedReader**와 **StringTokenizer**를 사용하면 시간 초과를 방지할 수 있다.

  ### Split vs StringTokenizer
  - **split**은 정규식을 기반으로 문자열을 자르는 로직으로 내부가 복잡하다.
  - 반면 **StringTokenizer**의 `nextToken()` 메소드는 단순히 공백 자리를 땡겨 채운다.
  - 정규식 처리가 필요 없고 단순히 문자열을 자르기만 한다면 **StringTokenizer**가 더 효율적이다.

  <strong>둘의 비교</strong>
  1. Scanner는 BufferedReader보다 타입에 구애받지 않는다.
  2. BufferedReader는 Scanner보다 효율적인 메모리 용량을 가진다.
  3. BufferedReader는 Scanner보다 안전하다.
  4. BufferedReader가 Scanner보다 실행 속도가 빠르다.

### StringTokenizer 사용법
자바에서는 문자열을 토큰 단위로 끊어주는 **StringTokenizer** 클래스를 제공한다.

- 예를 들어, `"A is my string"`이라는 문자열을 `"A"`, `"is"`, `"my"`, `"string"` 4개의 문자열로 끊어준다.
- 공백 외에도 다른 구획 문자(delimiter)를 사용할 수 있다.
    - 예: `"A%is%my%string"`에서 delimiter를 `%`로 설정하면 `"A"`, `"is"`, `"my"`, `"string"`으로 읽어준다.
    - 예: `"A$is^my%string"`에서 구획 문자를 `"$%^"`로 설정하면 `"A"`, `"is"`, `"my"`, `"string"`으로 끊어준다.

### 예제 코드
```java
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String str = "A is my string";
        StringTokenizer st = new StringTokenizer(str);

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        String str2 = "A%is%my%string";
        StringTokenizer st2 = new StringTokenizer(str2, "%");

        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }
    }
}
```
</details>

<details>
  <summary><strong>2. 메모리 초과 문제 해결법</strong></summary>

  ### 메모리 계산
  256MB까지 사용 가능할 때 `int`는 4바이트이므로:
  - `int`형은 4바이트
  - 1KB는 1024바이트
  - 1MB는 1024KB이므로
  - 256MB = 256 * 1024KB = 256 * 1024 * 1024바이트 = 약 268,435,456바이트
  - `int`형은 256 * 1024 * 1024 / 4개 = 약 67,108,864개 선언 가능

  대략 `int`형 67,108,864개 정도 가능!
  필요한 만큼만 할당해서 쓰자!
  (사실 1024로 계산하기가 까다로워서, 대충 1000이라고 놓고 계산하면 얼추 맞다.)


</details>
