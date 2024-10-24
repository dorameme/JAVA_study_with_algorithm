
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


<details>
  <summary><strong>답이 계속 안나올 때 대처법</strong></summary>

1. **문제를 다시 읽어본다**
   - 문제의 제약 조건을 놓치지 않았는지 확인
   - 예제 입출력을 통해 문제의 의도를 정확히 파악
   - 문제에서 요구하는 출력 형식이 맞는지 체크

2. **변수 범위 체크**
   - int 범위: -2,147,483,648 ~ 2,147,483,647
   - long 범위: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
   - 계산 과정에서 오버플로우가 발생하지 않는지 확인
   ```java
   // Before
   int result = a * b;
   // After
   long result = (long)a * b;
   ```

3. **예외 케이스 고려**
   - 입력값이 0인 경우
   - 입력값이 1인 경우
   - 입력값이 최대값인 경우
   - 입력값이 음수인 경우
   - 입력값이 중복되는 경우

4. **초기화 확인**
   - 배열이나 변수가 제대로 초기화되었는지 확인
   - 반복문에서 사용되는 변수들의 초기화 위치가 적절한지
   ```java
   // 잘못된 예
   int sum = 0;
   for(int i = 0; i < n; i++) {
       sum = 0;  // 여기서 초기화하면 누적 합을 구할 수 없음
       sum += arr[i];
   }
   ```

5. **출력 형식 체크**
   - 띄어쓰기 확인
   - 줄바꿈 확인
   - 소수점 자리수 확인
   ```java
   // 소수점 둘째자리까지 출력
   System.out.printf("%.2f", result);
   ```

6. **알고리즘 복잡도 체크**
   - 시간 제한과 입력 크기를 고려하여 적절한 알고리즘인지 확인
   - 일반적인 기준:
     - N ≤ 500: O(N³)
     - N ≤ 2000: O(N²)
     - N ≤ 100,000: O(NlogN)
     - N ≤ 10,000,000: O(N)

7. **디버깅 출력 활용**
   ```java
   // 중간 결과 확인
   System.out.println("Debug: " + variable);
   ```

8. **테스트 케이스 만들기**
   - 극단적인 케이스
   - 경계값 케이스
   - 일반적인 케이스
</details>



<details>
<summary><strong>TLE 방지하는법</strong></summary>

1. **입출력 최적화**
   - Scanner → BufferedReader로 교체
   - System.out.println() → BufferedWriter로 교체
   - split() → StringTokenizer로 교체
   ```java
   // Before
   Scanner sc = new Scanner(System.in);
   // After
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   ```
   

2. **자료구조 최적화**
   - ArrayList의 contains() → HashSet으로 교체 (O(n) → O(1))
   - List 순차 탐색 → 배열 인덱싱으로 교체
   - String 연산 → StringBuilder 사용
   ```java
   // Before
   if(list.contains(x))  // O(n)
   // After
   if(set.contains(x))   // O(1)
   ```

3. **알고리즘 복잡도 체크**
   - N ≤ 500: O(N³) 가능
   - N ≤ 2000: O(N²) 가능
   - N ≤ 100,000: O(NlogN) 가능
   - N ≤ 10,000,000: O(N) 가능

4. **불필요한 연산 제거**
   - 반복문 내 객체 생성 지양
   - 반복문 내 불변값 미리 계산
   - 중복 계산 제거
   ```java
   // Before
   for(int i = 0; i < n; i++) {
       int temp = Math.sqrt(n);  // 매번 계산
   }
   // After
   double sqrtN = Math.sqrt(n);  // 미리 계산
   for(int i = 0; i < n; i++) {
       int temp = sqrtN;
   }
   ```

5. **메모리 사용 최적화**
   - Wrapper 클래스 대신 Primitive 타입 사용
   - 필요한 만큼만 배열 크기 할당
   - 불필요한 객체 생성 방지
   ```java
   // Before
   Integer[] arr = new Integer[n];
   // After
   int[] arr = new int[n];
   ```

6. **반복문 최적화**
   - 중첩 반복문 줄이기
   - break 조건 최적화
   - 범위를 줄일 수 있다면 줄이기
   ```java
   // Before
   for(int i = 0; i < n; i++)
       for(int j = 0; j < n; j++)
   // After (가능한 경우)
   for(int i = 0; i < n; i++)
       for(int j = i + 1; j < n; j++)
   ```

7. **전처리 활용**
   - 반복적으로 사용되는 값 미리 계산
   - 조회가 잦은 데이터는 캐싱
   ```java
   // 소수 판별 같은 경우 미리 계산
   boolean[] isPrime = new boolean[MAX_N];
   void preCalculate() {
       // 에라토스테네스의 체 등으로 미리 계산
   }
   ```

</details>

<details>
<summary><strong>자료구조 선택 가이드</strong></summary>

### 1. 순차적 데이터 저장/접근
- **ArrayList**: 인덱스로 빠른 접근, 끝에서 추가/삭제가 많은 경우
   ```java
   List<Integer> list = new ArrayList<>();  // 랜덤 접근 많을 때
   ```
- **LinkedList**: 중간에 삽입/삭제가 많은 경우
   ```java
   List<Integer> list = new LinkedList<>();  // 중간 삽입/삭제 많을 때
   ```

### 2. 중복 제거/집합 연산
- **HashSet**: 빠른 검색, 순서 불필요
   ```java
   Set<Integer> set = new HashSet<>();  // 단순 중복 제거
   ```
- **TreeSet**: 정렬 필요, 범위 검색
   ```java
   Set<Integer> set = new TreeSet<>();  // 정렬된 중복 제거
   ```
- **LinkedHashSet**: 삽입 순서 유지
   ```java
   Set<Integer> set = new LinkedHashSet<>();  // 순서있는 중복 제거
   ```

### 3. 키-값 매핑
- **HashMap**: 빠른 검색
   ```java
   Map<String, Integer> map = new HashMap<>();  // 단순 매핑
   ```
- **TreeMap**: 키 기준 정렬, 범위 검색
   ```java
   Map<String, Integer> map = new TreeMap<>();  // 정렬된 매핑
   ```
- **LinkedHashMap**: 삽입 순서 유지
   ```java
   Map<String, Integer> map = new LinkedHashMap<>();  // 순서있는 매핑
   ```

### 4. 특수 목적
- **PriorityQueue**: 우선순위 기반 처리
   ```java
   Queue<Integer> pq = new PriorityQueue<>();  // 최소힙
   Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // 최대힙
   ```
- **ArrayDeque**: 양방향 큐/스택
   ```java
   Deque<Integer> deque = new ArrayDeque<>();  // 양방향 큐
   ```
- **Stack**: LIFO(Last In First Out)
   ```java
   Stack<Integer> stack = new Stack<>();  // 스택 (권장하지 않음, ArrayDeque 사용 권장)
   ```

### 시간복잡도 비교

| 자료구조 | 접근 | 검색 | 삽입(일반) | 삽입(첫/끝) | 삭제(일반) | 삭제(첫/끝) | 정렬 상태 | 순서 보장 |
|---------|------|------|------------|------------|------------|------------|-----------|-----------|
| ArrayList | O(1) | O(n) | O(n) | O(1)* | O(n) | O(1)* | X | O |
| LinkedList | O(n) | O(n) | O(1) | O(1) | O(1) | O(1) | X | O |
| HashSet | - | O(1) | O(1) | - | O(1) | - | X | X |
| TreeSet | - | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O | X |
| LinkedHashSet | - | O(1) | O(1) | - | O(1) | - | X | O |
| HashMap | O(1) | O(1) | O(1) | - | O(1) | - | X | X |
| TreeMap | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O(log n) | O | X |
| LinkedHashMap | O(1) | O(1) | O(1) | - | O(1) | - | X | O |
| PriorityQueue | - | O(n) | O(log n) | - | O(log n) | - | 부분** | X |
| ArrayDeque | O(1) | O(n) | - | O(1) | - | O(1) | X | O |
| Stack | O(n) | O(n) | - | O(1) | - | O(1) | X | O |

\* 재할당 필요시 O(n)  
** PriorityQueue는 추출할 때만 정렬 상태 보장

### 메모리 사용량 및 추가 특징
1. ArrayList vs LinkedList:
   - ArrayList: 연속 메모리, 캐시 친화적
   - LinkedList: 분산 메모리, 추가 참조 저장

2. Hash계열 vs Tree계열:
   - Hash: 메모리 더 사용, 빠른 접근
   - Tree: 메모리 적게 사용, 정렬 보장

3. Priority Queue:
   - 힙 구조로 구현
   - 완전 이진 트리 형태로 메모리 효율적

</details>
