# 🛠️ 핵심 기술 역량

## PreparedStatement를 활용한 안전한 SQL 실행
- **SQL Injection 방지**: `?` 플레이스홀더와 `setString()` 메소드로 사용자 입력값을 안전하게 바인딩
- **재사용성**: 동일한 SQL 구조에 다른 파라미터를 반복적으로 설정 가능
- **성능 최적화**: 미리 컴파일된 SQL 문을 재사용하여 실행 속도 향상
- **타입 안전성**: `setString()`, `setInt()` 등 타입별 메소드로 데이터 타입 불일치 방지

## 3계층 아키텍처 (3-Tier Architecture)
- **Presentation Layer**: `Member_Test.java` - 사용자 인터페이스 및 입출력 처리
- **Business Logic Layer**: `MemberService.java` - 비즈니스 규칙, 유효성 검증, 로직 처리
- **Data Access Layer**: `DBAccess.java` - 데이터베이스 연결 및 CRUD 작업
- **장점**: 계층 간 책임 분리로 유지보수성, 확장성, 재사용성 향상

## 데이터베이스 CRUD 구현
- **Create**: `INSERT` 문으로 회원 가입 데이터 저장
- **Read**: `SELECT` 문으로 로그인 검증 및 회원 정보 조회
- **Update**: `UPDATE` 문으로 회원 정보(이름, 비밀번호) 수정
- **Delete**: (미구현이지만 확장 가능한 구조)
- **PreparedStatement**: 모든 SQL 실행에 `?` 파라미터 바인딩 사용

## 입력 유효성 검증 (Validation)
- **길이 검증**: 아이디, 이름, 비밀번호의 최소/최대 길이 제한 (3~20자)
- **중복 검증**: 회원가입 시 DB 조회로 아이디 중복 확인
- **비밀번호 확인**: 입력한 비밀번호를 재입력하여 일치 여부 검증
- **trim() 처리**: 공백 제거로 불필요한 공백 입력 방지

## 세션 관리 개념 구현
- **로그인 상태 유지**: `Member` 객체를 변수로 저장하여 로그인 세션 표현
- **로그아웃**: `Member` 객체를 `null`로 설정하여 세션 종료
- **권한 기반 메뉴**: 로그인 전/후 메뉴를 분리하여 접근 제어
- **정보 갱신**: 회원 정보 수정 후 DB에서 최신 데이터를 다시 조회하여 `Member` 객체 갱신

---

# 📂 주요 실습 프로젝트 (d0121)

## 1. 엔티티 클래스 (`Member.java`)
- **필드**: `id`, `pw`, `name` (모두 private)
- **생성자 오버로딩**: 로그인용 2개 파라미터, 전체 정보용 3개 파라미터 (생성자 체이닝 `this()` 사용)
- **Getter 메소드**: 각 필드에 대한 접근자 제공
- **toString() 재정의**: 회원 정보를 보기 좋게 포맷팅하여 출력

## 2. 데이터 접근 계층 (`DBAccess.java`)

### DB 연결 관리
- 생성자에서 `DriverManager.getConnection()`으로 DB 연결 수립 및 `Connection` 객체 유지
- `close()` 메소드로 `PreparedStatement`, `Connection` 순서로 리소스 해제

### 주요 메소드
- **insert()**: `INSERT INTO Member VALUES (?, ?, ?)` - 회원 가입 데이터 저장
- **check()**: `SELECT COUNT(*) FROM Member WHERE id=? AND pw=?` - 로그인 검증, 일치하면 true 반환
- **search()**: `SELECT * FROM Member WHERE id=?` - 특정 회원 조회
- **searchAll()**: `SELECT * FROM Member ORDER BY id` - 전체 회원 조회
- **update()**: `UPDATE Member SET name=?, pw=? WHERE id=?` - 회원 정보 수정

## 3. 비즈니스 로직 계층 (`MemberService.java`)

### 회원가입 (`register()`)
- 아이디 중복 체크: DB 조회로 기존 아이디 존재 여부 확인
- 유효성 검증: `validTest()` 메소드로 3~20자 길이 제한
- 비밀번호 확인: `checkPw()` 메소드로 두 번 입력하여 일치 여부 검증
- DB 저장: `DBAccess.insert()` 호출

### 로그인 (`logIn()`)
- 아이디/비밀번호 입력 받아 `DBAccess.check()` 메소드로 검증
- 성공 시 DB에서 전체 회원 정보 조회하여 `Member` 객체 생성 및 반환
- 실패 시 `null` 반환

### 정보 수정 (`modifyPW()`, `modifyName()`)
- 새 정보 입력 및 길이 검증
- 원래 비밀번호 재입력으로 본인 확인
- DB 업데이트 후 `newMember()` 메소드로 최신 정보를 조회하여 새 `Member` 객체 반환

### 유틸리티 메소드
- **validTest()**: 입력 길이 검증 (min~max 자)
- **checkPw()**: 비밀번호 재입력 확인
- **newMember()**: DB에서 최신 회원 정보 조회 후 `Member` 객체 생성
- **showMyInfo()**: 특정 회원 정보 출력

## 4. 실행 클래스 (`Member_Test.java`)

### 로그인 전 메뉴
- 회원 가입(1), 로그인(2), 종료(3) 선택
- 로그인 성공 시 `Member` 객체 반환 받아 로그인 후 메뉴로 전환

### 로그인 후 메뉴
- 내 정보 조회(1), 이름 변경(2), 비밀번호 변경(3), 로그아웃(0)
- `Member` 객체가 `null`이 아니면 로그인 상태로 간주
- 로그아웃 시 `m = null`로 설정하여 세션 종료

---

# 📝 실습 회고

## PreparedStatement의 중요성
`Statement`와 달리 `PreparedStatement`는 SQL Injection 공격을 원천 차단하고, SQL 문을 미리 컴파일하여 성능을 향상시킴. `?` 플레이스홀더와 `setString()` 패턴이 실무에서 필수임을 체감함

## 3계층 아키텍처의 실용성
프레젠테이션, 비즈니스 로직, 데이터 접근 계층을 분리하여 각 계층의 책임이 명확해짐. 특히 `DBAccess`만 수정하면 DB 변경에 대응 가능하고, `MemberService`만 수정하면 비즈니스 규칙 변경에 유연하게 대처 가능함을 경험함

## 유효성 검증의 필수성
아이디 중복 체크, 비밀번호 재입력 확인, 길이 제한 검증 등 다층적인 검증 로직이 데이터 무결성을 보장함. 특히 DB 조회를 통한 중복 체크와 비밀번호 확인이 보안을 강화함을 이해함

## 세션 관리의 기본 개념
`Member` 객체를 변수로 유지하며 로그인 상태를 표현하는 방식이 HTTP 세션의 기본 원리와 유사함을 깨달음. 웹 애플리케이션에서는 이를 서버의 세션 저장소에 저장하는 방식으로 확장됨

## CRUD 패턴의 체득
INSERT, SELECT, UPDATE의 실제 구현을 통해 대부분의 애플리케이션이 이 패턴을 기반으로 동작함을 확인함. 특히 `executeUpdate()`와 `executeQuery()`의 구분, `ResultSet` 순회 방식 등 JDBC의 핵심 메커니즘을 체득함

## 예외 처리 전략
모든 메소드에 `throws Exception`을 선언하여 예외를 상위로 전파하는 방식을 사용함. 실무에서는 더 세밀한 예외 처리(try-catch, 커스텀 예외)가 필요하지만, 학습 단계에서는 간결한 코드로 핵심 로직에 집중할 수 있었음

## 리소스 관리의 중요성
`DBAccess.close()` 메소드로 `PreparedStatement`와 `Connection`을 명시적으로 해제하는 패턴을 학습함. 실무에서는 try-with-resources나 Connection Pool 사용이 권장되지만, 수동 관리를 통해 리소스 누수의 위험성을 체감함

---

**[허윤] | 금융DT 아카데미 교육생**
