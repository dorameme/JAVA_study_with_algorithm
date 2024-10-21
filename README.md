
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




<details>
  <summary><strong>개념-플로이드 워셜</strong></summary>

### 1. 플로이드 워셜의 개념
- 모든 노드에서 다른 모든 노드까지의 최단 경로를 한번에 구하는 알고리즘
- 음수 가중치가 있어도 사용 가능 (단, 음수 사이클이 없어야 함)
- 거쳐가는 정점을 기준으로 최단 거리를 구함
- DP(다이나믹 프로그래밍) 기반의 알고리즘

### 2. 시간복잡도
- 시간복잡도: O(V³)
  - 3중 for문을 사용하기 때문
- 공간복잡도: O(V²)
  - V x V 크기의 2차원 배열 필요

### 3. 사용법 (코드)
```java
// dist[i][j]: i에서 j로 가는 최단 거리
void floydWarshall() {
    // 경유지 k를 거쳐가는 경우를 고려
    for(int k = 0; k < n; k++)
        // 출발지 i
        for(int i = 0; i < n; i++)
            // 도착지 j
            for(int j = 0; j < n; j++)
                if(dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
}
```

### 4. 활용
1. 그래프의 최단 경로 찾기
   - 모든 정점 쌍 간의 최단 거리 계산
2. 경로 존재 여부 확인
   - 연결성 파악에 활용
3. 경유지가 있는 경로 탐색
   - 특정 노드를 반드시 거쳐가는 경로 찾기
4. 네트워크 라우팅
   - 네트워크 토폴로지에서 최적 경로 결정
</details>


<details>
  <summary><strong>Primitive vs Wrapper Class의 특징</strong></summary>

| 특징 | Primitive 타입 | Wrapper 클래스 |
|------|---------------|----------------|
| 종류 | boolean, byte, char, short, int, long, float, double | Boolean, Byte, Character, Short, Integer, Long, Float, Double |
| 기본값 | 0, 0.0, false, '\u0000' | null |
| 메모리 | 스택에 직접 저장 (적은 용량) | 힙 메모리 사용 (더 많은 용량) |
| null 허용 | 불가능 | 가능 |
| 컬렉션 사용 | 불가능 | 가능 |
| 메서드 | 없음 | 다양한 유틸리티 메서드 제공 |
| 성능 | 빠름 | 상대적으로 느림 |
| 자동 초기화 (멤버변수) | O | O (null로) |
| 자동 초기화 (지역변수) | X | X |
| 용도 | 간단한 값 저장, 성능 중시 | 객체가 필요한 경우, null 필요시 |
| 박싱/언박싱 | 해당 없음 | 자동 지원 |

p.s Java에서 지역 변수는 프리미티브 타입이든 참조 타입이든 자동 초기화되지 않습니다.
단, 배열을 생성할 때는 배열의 각 요소가 자동으로 초기화됩니다

### 사용 예시
```java
// Primitive
int num1 = 10;
num1 = null;  // 컴파일 에러

// Wrapper
Integer num2 = 10;  // 자동 박싱
num2 = null;       // 가능
int num3 = num2;   // 자동 언박싱

// 컬렉션 사용
ArrayList<Integer> list = new ArrayList<>();  // 가능
ArrayList<int> list2;                        // 불가능
```
</details>
