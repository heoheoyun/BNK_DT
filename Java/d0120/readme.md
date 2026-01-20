# 🛠️ 핵심 기술 역량

## 파일 입출력 (File I/O)
- **FileWriter**: 문자 기반 스트림으로 파일에 텍스트 데이터 쓰기
- **FileReader**: 문자 기반 스트림으로 파일에서 텍스트 데이터 읽기
- **자원 관리**: `finally` 블록에서 `close()` 호출로 파일 스트림 안전하게 종료
- **예외 처리**: `IOException`, `FileNotFoundException` 처리로 파일 작업 중 발생 가능한 오류 대응

## JDBC (Java Database Connectivity)
- **DB 연결**: `DriverManager.getConnection(url, user, password)`로 Oracle DB 연결
- **드라이버 로딩**: `Class.forName("oracle.jdbc.driver.OracleDriver")`로 JDBC 드라이버 명시적 로딩 (JDBC 4.0 이상에서는 생략 가능)
- **SQL 실행**: `Statement` 객체로 SQL 쿼리 실행
- **결과 처리**: `ResultSet`으로 SELECT 쿼리 결과를 행 단위로 순회하며 데이터 추출
- **연결 종료**: `Connection`, `Statement`, `ResultSet` 순서로 리소스 해제

## 통합 복습 (제네릭, 람다, Enum, 컬렉션)
- **제네릭 클래스**: `Box<T>` 클래스로 타입 안전성을 유지하며 다양한 타입 데이터 저장
- **람다 표현식**: 함수형 인터페이스를 람다로 간결하게 구현
- **Enum 활용**: `Gender` enum으로 성별 상수를 타입 안전하게 관리
- **컬렉션 프레임워크**: `HashMap`, `ArrayList`로 동적 데이터 관리

---

# 📂 주요 실습 프로젝트 (d0120)

## 1. 파일 쓰기 (`FileWriter_Test.java`)
- **FileWriter 생성**: `new FileWriter("test.txt")`로 파일 쓰기 스트림 열기
- **데이터 쓰기**: `fw.write()`로 문자열 데이터를 파일에 기록
  - "Hello Java!"
  - "FileWriter 예제입니다.\n"
  - "end.."
- **리소스 해제**: `finally` 블록에서 `fw.close()`로 스트림 안전하게 종료
- **예외 처리**: `IOException` 발생 시 스택 트레이스 출력
- **실행 결과**: "파일 쓰기가 완료되었습니다." 메시지 출력 및 test.txt 파일 생성

## 2. 파일 읽기 (`FileReader_Test.java`)
- **FileReader 생성**: `new FileReader("test.txt")`로 파일 읽기 스트림 열기
- **문자 단위 읽기**: `fr.read()`로 한 문자씩 읽으며 -1 반환 시 파일 끝으로 판단
- **형변환**: `(char)ch`로 int 타입 문자 코드를 char로 변환하여 출력
- **반복 읽기**: `while((ch = fr.read()) != -1)` 루프로 파일 전체 내용 읽기
- **예외 처리**: `FileNotFoundException`, `IOException` 각각 처리
- **리소스 해제**: `finally` 블록에서 null 체크 후 `fr.close()` 호출
- **실행 결과**: test.txt 파일 내용 콘솔 출력 후 "파일 읽기가 완료되었습니다." 메시지 출력

## 3. JDBC 연결 테스트 (`JdbcTest.java`)
- **연결 정보 설정**:
  - URL: `jdbc:oracle:thin:@//localhost:1521/testdb`
  - 사용자: `green`
  - 비밀번호: `1234`
- **드라이버 로딩**: `Class.forName("oracle.jdbc.driver.OracleDriver")`로 Oracle JDBC 드라이버 명시적 로딩
- **DB 연결**: `DriverManager.getConnection(url, user, password)`로 Connection 객체 획득
- **예외 처리**:
  - `ClassNotFoundException`: JDBC 드라이버 로딩 실패 시 발생
  - `SQLException`: DB 연결 실패 시 발생
- **연결 종료**: `finally` 블록에서 `conn.close()`로 DB 연결 해제
- **실행 결과**: "Oracle DB 연결 성공!" 및 "DB 연결 종료" 메시지 출력

## 4. Oracle SELECT 쿼리 실행 (`OracleSelectTest.java`)
- **연결 수립**: `DriverManager.getConnection()`로 DB 연결
- **Statement 생성**: `conn.createStatement()`로 SQL 실행 객체 생성
- **쿼리 실행**: `stmt.executeQuery("SELECT id, name FROM testTbl")`로 SELECT 쿼리 실행
- **결과 처리**:
  - `rs.next()`: 다음 행으로 커서 이동 (행이 없으면 false 반환)
  - `rs.getInt("id")`: id 컬럼 값을 int로 추출
  - `rs.getString("name")`: name 컬럼 값을 String으로 추출
- **리소스 해제**: ResultSet → Statement → Connection 순서로 `close()` 호출
- **실행 결과**: testTbl 테이블의 모든 행의 id와 name 콘솔 출력

## 5. 통합 복습 문제 (`Exam.java`)

### 5-1. HashMap 기본 사용
```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "James");
map.put(2, "Ann");
map.put(3, "David");

for(int key : map.keySet()) {
    System.out.println(key + " : " + map.get(key));
}
```
- Key-Value 쌍 저장 및 keySet()으로 전체 순회

### 5-2. ArrayList 기본 사용
```java
List<Double> list = new ArrayList<>();
list.add(1.1);
list.add(2.2);
list.add(3.3);
System.out.println(list);
```
- Double 타입 요소를 동적 배열로 관리

### 5-3. 람다 표현식
```java
HowLong hl;
hl = s -> s.length();
System.out.println(hl.len("Hello"));
```
- 함수형 인터페이스 `HowLong`을 람다로 구현하여 문자열 길이 반환

### 5-4. 제네릭 클래스
```java
Box<String> box = new Box<>("Word");
box.setData("CAT");
System.out.println(box.getData());
```
- `Box<T>` 제네릭 클래스로 String 타입 데이터 저장 및 조회

### 5-5. 객체 간 상호작용
```java
box.rideBus(new Bus(1));
```
- `Box` 객체가 `Bus` 객체와 상호작용하여 버스 탑승 시도
- `Bus.increase()`: 현재 인원(`cnt`)이 30명 미만이면 1 증가 후 1 반환, 아니면 0 반환

### 5-6. Enum 활용
```java
Person p = new Person("허윤", 22, Gender.MALE);
System.out.println(p);
```
- `Gender` enum으로 성별을 타입 안전하게 관리
- Person 객체 생성 시 이름, 나이, 성별 전달 및 toString()으로 정보 출력

---

# 📝 실습 회고

## 파일 입출력의 기본 원리
`FileWriter`와 `FileReader`를 통해 파일 I/O의 기본 메커니즘을 학습함. 특히 `finally` 블록에서 스트림을 안전하게 닫는 패턴의 중요성을 체감함. 파일이 제대로 닫히지 않으면 리소스 누수가 발생할 수 있음을 이해함

## JDBC의 구조와 흐름
드라이버 로딩 → 연결 수립 → SQL 실행 → 결과 처리 → 리소스 해제의 5단계 흐름을 체득함. `ResultSet.next()`로 커서를 이동하며 행 단위로 데이터를 추출하는 방식이 인상적이었음. 리소스 해제 순서(ResultSet → Statement → Connection)를 지켜야 함을 배움

## 예외 처리의 중요성
파일 작업과 DB 연결 모두 예외 처리가 필수임을 경험함. `FileNotFoundException`, `IOException`, `SQLException` 등 각 상황에 맞는 예외를 구분하여 처리하는 방법을 익힘. 특히 `finally` 블록에서도 `close()` 호출 시 예외가 발생할 수 있으므로 try-catch로 감싸야 함을 체득함

## 통합 개념 복습
제네릭, 람다, Enum, 컬렉션 프레임워크를 하나의 프로그램에서 통합적으로 사용하며 각 개념의 실용성을 재확인함. `Box<T>` 제네릭 클래스가 `Bus` 객체와 상호작용하는 설계는 객체지향 프로그래밍의 유연성을 잘 보여줌

## JDBC와 SQL의 연계
Java 코드에서 SQL 쿼리를 실행하여 데이터베이스와 통신하는 경험이 매우 실무적이었음. `Statement`로 SQL을 전달하고, `ResultSet`으로 결과를 받아 처리하는 흐름이 웹 애플리케이션 개발의 기초가 됨을 깨달음

## 자원 관리의 책임
파일 스트림과 DB 연결은 명시적으로 `close()`를 호출해야 시스템 자원이 해제됨. 이를 잊으면 리소스 누수로 이어질 수 있으므로, `finally` 블록이나 try-with-resources 구문을 활용한 안전한 자원 관리의 중요성을 다시 한번 확인함

---

**[허윤] | 금융DT 아카데미 교육생**
