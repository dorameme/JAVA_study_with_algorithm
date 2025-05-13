
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
<details> <summary><strong>개념-다익스트라</strong></summary>

### 1. 다익스트라의 개념
- 하나의 시작점에서 다른 모든 노드까지의 최단 경로를 구하는 알고리즘
- 음수 가중치가 있으면 사용 불가능
- 매 단계마다 방문하지 않은 노드 중 가장 비용이 적은 노드를 선택
- 그리디(Greedy) 알고리즘의 일종

### 2. 시간복잡도
* **O((V + E) log V)**: 다익스트라 알고리즘은 우선순위 큐(힙)를 사용하는 경우에 이 복잡도를 가진다.
   * **V**는 정점의 개수, **E**는 간선의 개수이다.
   * 알고리즘은 각 정점을 한 번씩 방문하며, 우선순위 큐를 사용해 최단 거리를 가진 정점을 선택하고, 그 정점에서 나가는 간선을 탐색.
   * 각 정점을 큐에서 꺼낼 때의 복잡도는 **log V**이며, 총 V개의 정점을 다루므로 **V * log V**가 발생.
   * 또한, 각 간선을 업데이트할 때마다 큐에 삽입하거나 갱신하게 되는데, E개의 간선에 대해 **log V** 연산이 소요됨.
   * 이를 종합하여 **O((V + E) log V)**가 됨.

### 3. 공간복잡도
* **O(V + E)**: 공간복잡도는 주로 **V**와 **E**에 따라 결정.
   * **V**는 각 정점에 대한 최단 거리 정보를 저장하는 배열.
   * **E**는 각 간선을 저장하는 그래프의 인접 리스트 또는 배열에 대한 공간.
   * 따라서, 공간복잡도는 **O(V + E)**가 됨.

### 4. 사용법 (코드)
```java
void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));
    
    while(!pq.isEmpty()) {
        Node current = pq.poll();
        
        if(dist[current.vertex] < current.weight) continue;
        
        for(Node next : graph[current.vertex]) {
            if(dist[next.vertex] > dist[current.vertex] + next.weight) {
                dist[next.vertex] = dist[current.vertex] + next.weight;
                pq.offer(new Node(next.vertex, dist[next.vertex]));
            }
        }
    }
}

class Node implements Comparable<Node> {
    int vertex, weight;
    
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
```

### 4. 활용
1. 내비게이션 시스템
   - 실제 도로 네트워크에서 최단 경로 찾기
2. 네트워크 라우팅 프로토콜
   - OSPF(Open Shortest Path First) 등의 라우팅 프로토콜
3. 소셜 네트워크
   - 최소 단계로 연결된 사용자 찾기
4. 게임 개발
   - AI 경로 탐색
   - 캐릭터 이동 경로 계산
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
<details>
  <summary><strong>변수 스코프에 대한 이해</strong></summary>

### 1. 변수 스코프
변수 스코프는 **변수가 사용할 수 있는 영역**을 의미하며, 변수의 선언 위치에 따라 접근 가능 범위가 달라진다. 자바에서는 변수 스코프가 **멤버 변수**와 **지역 변수**로 나뉘며, 메서드 안에서 선언된 지역 변수는 해당 메서드 내부에서만 사용 가능하다.

### 2. 람다와 변수 스코프
람다식은 자바 8에서 도입된 **익명 함수**로, 외부 지역 변수를 람다 내부에서 사용하려면 **effective final** 상태여야 한다. 이는 람다식 내부에서 외부 변수를 사용할 수 있으나, 해당 변수는 변경될 수 없고 사실상 final과 같은 상태여야 함을 의미한다.

```java
int num = 10;
Runnable r = () -> System.out.println(num); // 가능, num이 변경되지 않음
num = 20; // 불가능, 람다식에서 접근하는 변수는 effective final 상태여야 함
```

### 3. effective final
effective final은 **final 키워드가 명시적으로 없더라도 변경되지 않는 변수**를 의미한다. 람다식 내부에서 사용하는 외부 변수는 이 특성을 가져야 한다.

#### 예시
```java
int x = 5;
Consumer<Integer> consumer = (y) -> System.out.println(x + y); // x는 effective final
x = 10; // 오류 발생
```

해당 코드에서 `x`가 수정되지 않으면 `x`는 effective final로 간주되어 사용할 수 있지만, `x`의 값을 변경하려 할 경우 자바는 이를 허용하지 않는다.

#### effective final 제약 이유
자바는 변수의 일관성과 **안전한 동시성**을 유지하기 위해 람다 내부에서 외부의 지역 변수를 수정할 수 없도록 제한하며, 여러 스레드에서 람다식을 동시에 호출할 때 외부 변수를 보호하기 위함이다.

### 4. 예제 코드: 람다식과 effective final
```java
public class Main {
    public static void main(String[] args) {
        int base = 5;
        Runnable r = () -> {
            System.out.println("Result: " + (base + 10));
        };
        
        // base = 20;  // 이 코드가 있다면 오류 발생
        r.run(); // 출력: Result: 15
    }
}
```

위 코드는 정상 실행되며, `base`가 변경되지 않으므로 effective final로 취급되어 안전하게 사용 가능하다.

### 5. 해결 방법: Atomic 클래스 사용
람다식 내부에서 외부 변수를 수정하려면 `AtomicInteger` 같은 **Atomic 클래스**를 사용하여 멀티스레드 환경에서 안전하게 변수 수정이 가능하도록 한다.

```java
import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger sum = new AtomicInteger(0);
numbers.forEach(num -> sum.addAndGet(num)); // sum 값을 안전하게 업데이트
System.out.println(sum.get()); // 결과 출력
```


</details>

<details>
  <summary><strong>개념-BFS/DFS 방문처리 시점</strong></summary>

### 1. BFS/DFS 방문처리의 차이점
DFS와 BFS에서 방문 체크 타이밍은 탐색 방식과 목적에 따라 다르게 설정된다. 
이는 각각의 구조와 동작 방식에서 오는 차이로 이해할 수 있다.

### 2. BFS의 방문체크
BFS는 **큐에 넣을 때 방문체크**를 해야 한다.

#### 2-1. 이유
1. **큐의 중복 방지**
   - BFS는 탐색할 노드들을 큐에 넣어서 처리한다.
   - 방문체크를 큐에 넣을 때 하지 않으면 동일한 노드가 여러 번 큐에 들어가서 중복 탐색이 발생할 수 있다.
   - 예를 들어, 서로 연결된 노드 A와 B가 있을 때, A를 탐색하면서 B를 큐에 넣고, B를 탐색하면서 다시 A를 큐에 넣는 문제가 발생한다.

2. **메모리 관리**
   - 중복된 노드들이 큐에 쌓이면 큐 크기가 불필요하게 커질 수 있다.
   - 이는 메모리 사용량을 증가시키고, BFS의 성능 저하로 이어진다.

#### 2-2. 코드 예시
```java
void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N];
    
    q.add(start);         // 큐에 시작 노드 추가
    visited[start] = true; // 큐에 넣을 때 방문 체크
    
    while (!q.isEmpty()) {
        int node = q.poll();
        System.out.println(node);

        for (int next : graph[node]) {
            if (!visited[next]) {
                q.add(next);      
                visited[next] = true; // 큐에 넣으면서 방문 체크
            }
        }
    }
}
```

### 3. DFS의 방문체크
DFS는 **노드를 방문했을 때 체크**를 한다.

#### 3-1. 이유
1. **재귀적 특성**
   - DFS는 재귀(스택)를 이용해 깊이 우선 탐색을 수행한다.
   - 노드를 방문한 시점에서 방문체크를 수행해도 이미 호출된 함수가 끝난 후 스택에서 제거되므로 중복 탐색 문제가 발생하지 않는다.

2. **백트래킹 용이성**
   - DFS는 탐색 후 되돌아가야 하는 경우가 있다(백트래킹).
   - 이 경우, 방문체크를 해제해야 하므로 방문 시점에서 체크하는 것이 자연스럽다.

3. **구조적 단순성**
   - 방문체크를 노드를 방문했을 때 수행하면, 다음 노드를 탐색하기 전후로 명확한 구분이 가능하다.
   - 이는 재귀 구조에서 코드 작성과 가독성을 높이는 데 도움을 준다.

#### 3-2. 코드 예시
```java
// 일반적인 DFS
void dfs(int node) {
    visited[node] = true; // 노드를 방문하며 체크
    System.out.println(node);

    for (int next : graph[node]) {
        if (!visited[next]) {
            dfs(next);
        }
    }
}

// 백트래킹이 필요한 DFS
void dfsBacktracking(int node) {
    visited[node] = true;
    System.out.println(node);

    for (int next : graph[node]) {
        if (!visited[next]) {
            dfsBacktracking(next);
        }
    }

    visited[node] = false; // 백트래킹 시 방문 해제
}
```

### 4. 실전 적용 팁
1. **BFS 사용시**
   - 큐를 효율적으로 관리하기 위해 큐에 넣을 때 방문체크를 한다.
   - 시작 노드도 큐에 넣을 때 방문체크를 해야 한다.
   - 큐에서 꺼낼 때 방문체크를 하면 메모리 초과가 날 수 있다.

2. **DFS 사용시**
   - 노드 방문 시점에서 체크한다.
   - 백트래킹이 필요한 경우 방문 해제도 고려한다.
   - 사이클이 있는 그래프는 무한루프에 빠지지 않도록 주의한다.

</details>



<details>
  <summary><strong>ArrayDeque vs LinkedList 비교</strong></summary>

| 항목      | ArrayDeque                   | LinkedList             |
| ------- | ---------------------------- | ---------------------- |
| 내부 구조   | 동적 배열 기반                     | 이중 연결 리스트              |
| 접근 속도   | 빠름 (배열 기반)                   | 느림 (노드 탐색 필요)          |
| 메모리 사용  | 더 적음                         | 노드마다 포인터를 저장하므로 더 큼    |
| null 저장 | 불가능 (`NullPointerException`) | 가능                     |
| 스레드 안전성 | 비동기 (Thread-safe 아님)         | 비동기 (Thread-safe 아님)   |
| 주요 특징   | 빠른 큐/스택 연산<br>연속된 공간에 저장     | 삽입/삭제가 자주 일어날 때 유리     |
| 성능      | 대부분의 경우 더 빠름                 | 큐/스택보다는 삽입/삭제에 특화      |
| 용도      | 큐 또는 스택 구조 구현 시 적합           | 데이터의 중간 삽입/삭제가 많을 때 적합 |

### 사용 예시

```java
// ArrayDeque 사용
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);

// LinkedList 사용
Deque<Integer> deque = new LinkedList<>();
deque.addFirst(1);
deque.addLast(2);
```

 **요약**: 큐나 스택을 구현할 때는 **ArrayDeque**가 일반적으로 더 성능이 좋으며, 연결 리스트처럼 중간 삽입/삭제가 필요한 상황에서는 **LinkedList**가 유리하다.

</details>

