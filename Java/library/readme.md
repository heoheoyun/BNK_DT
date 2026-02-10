# 🛠️ 핵심 기술 역량

## PreparedStatement를 활용한 안전한 SQL 실행
- **SQL Injection 방지**: `?` 플레이스홀더와 `setString()`, `setInt()` 메소드로 사용자 입력값을 안전하게 바인딩
- **재사용성**: 동일한 SQL 구조에 다른 파라미터를 반복적으로 설정 가능
- **성능 최적화**: 미리 컴파일된 SQL 문을 재사용하여 실행 속도 향상
- **타입 안전성**: `setString()`, `setInt()` 등 타입별 메소드로 데이터 타입 불일치 방지

## 3계층 아키텍처 (3-Tier Architecture)
- **Presentation Layer**: `Library.java` - 사용자 인터페이스, 메뉴 제공 및 입출력 처리
- **Business Logic Layer**: `LibraryService.java` - 비즈니스 규칙, 유효성 검증, 도서관 운영 로직 처리
- **Data Access Layer**: `LibraryDBA.java` - 데이터베이스 연결 및 CRUD 작업
- **장점**: 계층 간 책임 분리로 유지보수성, 확장성, 재사용성 향상

## 데이터베이스 CRUD 구현
- **Create**: `INSERT` 문으로 회원 가입, 도서 등록, 대출 기록 데이터 저장
- **Read**: `SELECT` 문으로 로그인 검증, 회원 정보 조회, 도서 검색, 대출 내역 조회
- **Update**: `UPDATE` 문으로 비밀번호 변경, 탈퇴 요청, 도서 대출 상태 변경, 반납 처리
- **Delete**: `DELETE` 문으로 회원 탈퇴 처리, 도서 삭제, 대출 기록 삭제
- **PreparedStatement**: 모든 SQL 실행에 `?` 파라미터 바인딩 사용으로 SQL Injection 방지

## ResultSet과 컬렉션 변환
- **단일 객체 반환**: `ResultSet`에서 데이터 추출 후 `User`, `Book` 객체 생성
- **컬렉션 반환**: `ArrayList<User>`, `ArrayList<Book>`, `ArrayList<Log>`로 여러 데이터를 리스트 형태로 반환
- **null 처리**: 조회 결과가 없을 경우 `null` 반환으로 명확한 상태 전달
- **생성자 오버로딩**: 용도별 생성자(로그인용, 회원가입용, DB 조회용) 제공으로 유연한 객체 생성

## 입력 유효성 검증 (Validation)
- **길이 검증**: 아이디, 이름, 비밀번호의 최소/최대 길이 제한 (`validTest()` 메소드 활용)
- **중복 검증**: 회원가입 시 DB 조회로 아이디 중복 확인, 도서 등록 시 책 번호 중복 확인
- **비밀번호 확인**: 입력한 비밀번호를 재입력하여 일치 여부 검증 (`checkPw()` 메소드)
- **대출 가능 여부 확인**: 책 상태(`b_inLibrary`), 대출 권수 제한(3권), 본인 대출 도서 확인
- **trim() 처리**: 공백 제거로 불필요한 공백 입력 방지

## 세션 관리 개념 구현
- **로그인 상태 유지**: `User` 객체를 변수로 저장하여 로그인 세션 표현
- **로그아웃**: `User` 객체를 `null`로 설정하여 세션 종료
- **권한 기반 메뉴**: 로그인 전/후 메뉴 분리, 일반 사용자/관리자 메뉴 구분
- **관리자 권한 체크**: `u.equals(ls.admin())` 패턴으로 관리자 여부 확인

## 트랜잭션 개념의 이해
- **대출 처리**: 대출 기록 삽입(`Loan_Record`) + 도서 상태 변경(`Books`) 순차 실행
- **반납 처리**: 대출 기록 상태 변경 + 도서 상태 변경의 원자적 처리
- **회원 삭제**: 대출 기록 삭제 후 회원 정보 삭제로 외래키 제약조건 해결
- **롤백 고려**: 중간 단계 실패 시 이전 상태로 되돌리는 개념 이해

## LIKE 연산자를 활용한 동적 검색
- **부분 검색**: `LIKE '%검색어%'` 패턴으로 포함 단어 검색 구현
- **동적 SQL 생성**: 사용자 선택(이름/출판사/저자/분류코드)에 따라 WHERE 절 동적 구성
- **컬럼명 매핑**: Switch문으로 사용자 입력을 DB 컬럼명으로 변환
- **ORDER BY**: 검색 결과를 책 번호 순으로 정렬하여 가독성 향상

---

# 📂 주요 실습 프로젝트 - 도서관 관리 시스템

## 1. 엔티티 클래스

### User.java
- **필드**: `id`, `pw`, `name`, `reason` (모두 private)
- **생성자 오버로딩**:
  - 로그인용: 2개 파라미터 (`id`, `pw`)
  - 회원가입용: 3개 파라미터 (`id`, `pw`, `name`)
  - DB 조회용: 4개 파라미터 (탈퇴 사유 `reason` 포함)
- **Getter/Setter**: 모든 필드에 대한 접근자, `pw`와 `reason`에 대한 수정자 제공
- **toString() 재정의**: ID, 이름, 탈퇴 사유(있을 경우) 출력
- **equals() 재정의**: `id` 필드 기반 동등성 비교로 관리자 권한 체크 활용

### Book.java
- **필드**: `bno`, `b_name`, `publish`, `author`, `cno`, `in_Library` (대출 가능 여부)
- **생성자 오버로딩**:
  - 신규 도서 등록용: 5개 파라미터 (`in_Library` 기본값 `true`)
  - DB 데이터 조회용: 6개 파라미터 (상태 값 "Y"/"N"을 `boolean`으로 변환)
- **Getter 메소드**: 모든 필드에 대한 접근자 제공
- **getLoanable()**: 대출 가능 여부를 문자열로 반환
- **toString() 재정의**: 책 번호, 이름, 저자, 출판사 정보 출력

### Log.java
- **필드**: `log` (대출 번호), `book`, `user` (객체 참조)
- **생성자**: 3개 파라미터로 대출 기록 객체 생성
- **Getter 메소드**: 모든 필드에 대한 접근자 제공
- **toString() 재정의**: 책 번호, 이용자 ID, 대출 상태 출력

## 2. 데이터 접근 계층 (LibraryDBA.java)

### DB 연결 관리
- 생성자에서 `DriverManager.getConnection()`으로 Oracle DB 연결 수립 및 `Connection` 객체 유지
- `close()` 메소드로 `PreparedStatement`, `Connection` 순서로 리소스 해제

### 회원 관련 기능

#### userInsert(User user)
- 회원 가입 시 사용자 정보를 `luser` 테이블에 삽입
- `PreparedStatement`로 SQL Injection 방지

#### check(User user)
- 로그인 검증용 메소드
- `COUNT(*)` 쿼리로 아이디와 비밀번호 일치 여부 확인
- `boolean` 타입으로 성공/실패 반환

#### uSearch(String id)
- 특정 회원 조회 메소드
- `User` 객체 직접 반환, 결과 없으면 `null` 반환
- 회원 가입 시 중복 체크, 로그인 후 정보 로드에 사용

#### updatePw(String id, String newPw)
- 비밀번호 변경 메소드
- `UPDATE` 쿼리로 특정 회원의 비밀번호 수정

#### requestWithdrawal(String id, String reason)
- 탈퇴 요청 메소드
- `u_reason` 컬럼에 탈퇴 사유 저장

#### userDelete(String uid)
- 회원 탈퇴 처리 메소드 (관리자 전용)
- **중요**: 외래키 제약조건을 고려한 순차 삭제
  1. `Loan_Record` 테이블에서 해당 회원의 모든 대출 기록 삭제
  2. `luser` 테이블에서 회원 정보 삭제
- 두 개의 `PreparedStatement`를 순차 실행

#### getAllUsers()
- 전체 회원 조회 메소드 (관리자 전용)
- `ArrayList<User>` 반환으로 여러 회원 데이터 관리
- `while(rs.next())` 패턴으로 모든 레코드 순회
- 탈퇴 사유(`u_reason`) 포함하여 조회

### 도서 관련 기능

#### bSearch(String bno)
- 특정 도서 조회 메소드
- `Book` 객체 직접 반환, 결과 없으면 `null` 반환
- DB의 `b_inLibrary` 값("Y" or "N")을 `boolean`으로 변환하여 생성자에 전달
- 도서 등록/삭제/대출 기능에서 책 존재 여부 확인에 사용

#### bSqlSearch(String sql)
- 동적 SQL 쿼리로 도서 목록 조회
- `ArrayList<Book>` 반환
- 도서 검색 기능에서 사용자 선택(이름/출판사/저자/분류코드)에 따라 생성된 SQL 실행

#### bookInsert(Book book)
- 신규 도서 등록 메소드 (관리자 전용)
- `b_inLibrary` 기본값을 'Y'로 설정하여 대출 가능 상태로 등록

#### bookDelete(Book book)
- 기존 도서 삭제 메소드 (관리자 전용)
- 책 번호(`b_no`)로 도서 삭제

### 대출/반납 관련 기능

#### insertLoan(String uid, String bno)
- 대출 실행 메소드
- **처리 순서**:
  1. `Loan_Record` 테이블에서 다음 대출 번호(`log`) 계산 (`COUNT(*) + 1`)
  2. 대출 기록 삽입 (`state` = '대출중')
  3. `Books` 테이블의 `b_inLibrary`를 'N'으로 변경 (대출 불가 상태)

#### returnBook(String uid, String bno)
- 반납 실행 메소드
- **처리 순서**:
  1. `Loan_Record` 테이블의 `state`를 '반납완료'로 변경 (조건: 내 아이디 + 해당 책 + '대출중' 상태)
  2. `executeUpdate()` 반환값(`result`)으로 처리 성공 여부 확인
  3. 처리 성공 시 `Books` 테이블의 `b_inLibrary`를 'Y'로 변경 (대출 가능 상태)

#### isLoaned(String bno)
- 특정 책이 현재 대출 중인지 확인
- `b_inLibrary` 값이 "N"이면 `true` 반환
- 대출 시도 전 중복 대출 방지에 사용

#### checkMyLoan(String uid, String bno)
- 내가 현재 빌리고 있는 책인지 확인
- `state`가 '대출중'인 레코드의 개수를 세어 `boolean` 반환
- 반납 시도 시 본인 대출 도서 확인에 사용

#### selectAllLogs()
- 전체 대출 기록 조회 메소드 (관리자 전용)
- `ArrayList<Log>` 반환
- **처리 방식**:
  1. `Loan_Record` 테이블에서 `log`, `b_no`, `u_id` 조회
  2. 각 레코드마다 `bSearch()`, `uSearch()`로 `Book`, `User` 객체 조회
  3. 삭제된 책이나 회원이 아닐 경우에만 리스트에 추가
- `ORDER BY log DESC`로 최신 기록부터 정렬

#### lbSearch(User user)
- 특정 회원의 대출 도서 목록 조회
- `ArrayList<Book>` 반환
- `state`가 '대출중'인 도서만 조회
- 사용자 정보 출력 시 현재 대출 중인 도서 목록 표시에 사용

#### getLoanCount(String uid)
- 현재 회원이 대출 중인 도서 권수 확인
- `COUNT(*)` 쿼리로 '대출중' 상태 레코드 개수 반환
- 대출 권수 제한(3권) 검증에 사용

## 3. 비즈니스 로직 계층 (LibraryService.java)

### 회원 기능

#### register()
- 회원 가입 기능
- **처리 순서**:
  1. 아이디 입력 및 길이 검증 (`validTest()`)
  2. 아이디 중복 체크 (`db.uSearch(id)`)
  3. 이름 입력 및 길이 검증
  4. 비밀번호 입력, 길이 검증, 재입력 확인 (`checkPw()`)
  5. `db.userInsert()` 호출하여 DB 저장

#### logIn()
- 로그인 기능
- **처리 순서**:
  1. 아이디, 비밀번호 입력
  2. `db.check()` 메소드로 검증
  3. 성공 시 `db.uSearch(id)`로 전체 회원 정보 조회하여 `User` 객체 반환
  4. 실패 시 `null` 반환

#### showMyInfo(User user)
- 사용자 정보 출력 기능
- 회원 ID, 이름 출력
- `db.lbSearch(user)`로 현재 대출 중인 도서 목록 조회 및 출력
- 대출한 책이 없을 경우 안내 메시지 출력

#### modifyPw(User user)
- 비밀번호 변경 기능
- **처리 순서**:
  1. 현재 비밀번호 입력 및 검증
  2. 새 비밀번호 입력, 길이 검증, 재입력 확인
  3. `db.updatePw()` 호출하여 DB 업데이트
  4. 메모리 상의 `User` 객체도 `setPw()`로 갱신

#### withdrawal_requests(User user)
- 탈퇴 요청 기능
- **처리 순서**:
  1. 탈퇴 의사 확인 (Y/N)
  2. 탈퇴 사유 입력
  3. `db.requestWithdrawal()` 호출하여 DB에 사유 저장
  4. 메모리 상의 `User` 객체도 `setReason()`으로 갱신

### 도서 기능

#### searchBooks(User user)
- 도서 검색 기능
- **처리 순서**:
  1. 검색 조건 선택 (이름/출판사/저자/분류코드)
  2. Switch문으로 선택값을 DB 컬럼명으로 매핑
  3. 검색어 입력
  4. `LIKE '%검색어%'` 패턴의 동적 SQL 생성
  5. `db.bSqlSearch(finalSql)` 호출하여 도서 목록 조회
  6. 검색 결과 출력 (책 정보 + 대출 가능 여부)

#### bookLoan(User user)
- 도서 대출 기능
- **처리 순서**:
  1. 대출할 책 번호 입력
  2. `db.bSearch(bno)`로 책 존재 여부 확인
  3. `db.isLoaned(bno)`로 이미 대출 중인지 확인
  4. `db.getLoanCount(user.getId())`로 현재 대출 권수 확인 (3권 제한)
  5. 대출 의사 확인 (Y/N)
  6. `db.insertLoan()` 호출하여 대출 처리

#### bookReturn(User user)
- 도서 반납 기능
- **처리 순서**:
  1. `db.lbSearch(user)`로 현재 대출 중인 도서가 있는지 확인
  2. `showMyInfo(user)`로 현재 빌린 목록 먼저 표시
  3. 반납할 책 번호 입력
  4. `db.checkMyLoan()`으로 본인이 빌린 책인지 확인
  5. 반납 의사 확인 (Y/N)
  6. `db.returnBook()` 호출하여 반납 처리

### 관리자 기능

#### admin()
- 관리자 계정 객체 반환 (`id`: "admin", `pw`: "admin1234")
- `User.equals()` 메소드와 함께 사용하여 관리자 권한 체크

#### registBook()
- 도서 등록 기능 (관리자 전용)
- **처리 순서**:
  1. 책 번호 입력 및 중복 체크
  2. 책 이름, 출판사, 저자, 분류코드 입력
  3. 등록 의사 확인 (Y)
  4. `db.bookInsert(book)` 호출하여 DB 저장

#### deleteBook()
- 도서 삭제 기능 (관리자 전용)
- **처리 순서**:
  1. 삭제할 책 번호 입력
  2. `db.bSearch(bno)`로 책 존재 여부 확인
  3. 삭제 의사 확인 (Y)
  4. `db.bookDelete(book)` 호출하여 DB에서 삭제

#### showAllMember()
- 회원 정보 확인 기능 (관리자 전용)
- `db.getAllUsers()`로 전체 회원 목록 조회
- 관리자 계정("admin")은 제외하고 출력

#### showLog()
- 대출 및 반납 내역 조회 (관리자 전용)
- `db.selectAllLogs()`로 전체 대출 기록 조회
- `Log.toString()`으로 각 기록 출력

#### check_withdrawal_requests()
- 탈퇴 요청 확인 (관리자 전용)
- `db.getAllUsers()`로 전체 회원 조회
- `reason` 필드가 `null`이 아닌 회원만 출력 (탈퇴 요청한 회원)

#### delete_member()
- 탈퇴 처리 기능 (관리자 전용)
- **처리 순서**:
  1. `check_withdrawal_requests()` 호출하여 요청 목록 먼저 표시
  2. 삭제할 회원 ID 입력
  3. `db.uSearch(targetId)`로 회원 존재 여부 확인
  4. 삭제 의사 확인 (Y/N)
  5. `db.userDelete(targetId)` 호출하여 회원 영구 삭제

### 유틸리티 메소드

#### validTest(String s, int min, int max)
- 입력 길이 검증 메소드
- 최소/최대 길이 범위 체크
- 유효하지 않으면 재입력 요구

#### checkPw(String pw)
- 비밀번호 재입력 확인 메소드
- 두 번 입력한 비밀번호 일치 여부 확인
- 불일치 시 `true` 반환하여 재입력 유도

## 4. 실행 클래스 (Library.java)

### 시작 화면 (로그인 전)
- 회원 가입(1), 로그인(2), 메뉴 종료(3) 선택
- 로그인 성공 시 `User` 객체 반환 받아 로그인 후 메뉴로 전환
- `while(u == null)` 패턴으로 로그인될 때까지 반복

### 일반 사용자 메뉴 (로그인 후)
- 내 정보(1), 책 조회(2), 책 대출(3), 책 반납(4), 비밀번호 변경(5), 회원탈퇴 신청(6), 로그아웃(0)
- `while(u != null && !u.equals(ls.admin()))` 패턴으로 일반 사용자 메뉴 루프
- 로그아웃 시 `u = null`로 설정하여 세션 종료

### 관리자 메뉴 (관리자 로그인 후)
- 책 등록(1), 책 삭제(2), 책 조회(3), 회원 정보 조회(4), 대출 내역 조회(5), 탈퇴 요청 확인(6), 탈퇴 처리(7), 로그아웃(0)
- `while(u != null && u.equals(ls.admin()))` 패턴으로 관리자 메뉴 루프
- 관리자는 도서 관리, 회원 관리, 대출 내역 조회, 탈퇴 처리 권한 보유

---

# 📝 실습 회고

## PreparedStatement를 통한 SQL Injection 방지의 중요성
모든 SQL 쿼리에서 `?` 플레이스홀더와 `setString()`, `setInt()` 메소드를 사용하여 사용자 입력값을 안전하게 바인딩함. 특히 동적 검색 기능에서 컬럼명은 Switch문으로 검증하고, 검색어는 `PreparedStatement`로 바인딩하지 않고 문자열 연결을 사용했는데, 실제 프로젝트에서는 컬럼명도 화이트리스트 방식으로 엄격히 검증해야 함을 깨달음

## 외래키 제약조건과 삭제 순서의 이해
회원 삭제(`userDelete()`) 시 `Loan_Record` 테이블의 대출 기록을 먼저 삭제한 후 `luser` 테이블의 회원 정보를 삭제하는 순서가 중요함을 체득함. 외래키 제약조건을 무시하면 무결성 제약 조건 위반 에러가 발생하므로, 참조 관계를 파악하고 역순으로 삭제하는 패턴이 필수임

## 트랜잭션 개념의 필요성 인식
대출 처리(`insertLoan()`)와 반납 처리(`returnBook()`)에서 여러 테이블을 순차적으로 수정하는데, 중간 단계에서 실패하면 데이터 불일치가 발생할 수 있음. 현재는 자동 커밋 모드로 동작하지만, 실무에서는 `Connection.setAutoCommit(false)`와 `commit()`, `rollback()`을 사용한 명시적 트랜잭션 관리가 필요함을 깨달음

## 계층 간 책임 분리의 명확성
- `LibraryDBA`: SQL 실행과 데이터 변환만 담당
- `LibraryService`: 비즈니스 로직과 유효성 검증 담당
- `Library`: 사용자 인터페이스와 메뉴 흐름 제어 담당

각 계층이 자신의 역할에만 집중하여 코드 수정 시 영향 범위가 최소화됨을 경험함. 특히 `LibraryService`에서 `LibraryDBA`의 메소드를 조합하여 복잡한 비즈니스 로직을 구현하는 패턴이 실무에서 자주 사용됨을 체감함

## ResultSet 대신 객체 반환의 장점
`bSearch()`, `uSearch()` 메소드에서 `ResultSet` 대신 `Book`, `User` 객체를 직접 반환함으로써 Service 계층에서 SQL 관련 객체를 직접 다루지 않아도 되어 관심사 분리가 명확해짐. 조회 결과가 없을 때 `null`을 반환하여 호출부에서 결과 유무를 판단할 수 있도록 한 패턴이 매우 유용함

## ArrayList를 활용한 다중 데이터 관리
`getAllUsers()`, `bSqlSearch()`, `selectAllLogs()` 메소드에서 `ArrayList`를 사용하여 여러 객체를 반환하고 관리하는 방법을 익힘. `while(rs.next())` 패턴으로 모든 레코드를 순회하며 리스트에 추가하고, 향상된 for문으로 리스트를 순회하며 출력하는 패턴이 실무에서 자주 사용됨을 체감함

## 생성자 오버로딩의 실용성
`User` 클래스에서 로그인용(2개 파라미터), 회원가입용(3개 파라미터), DB 조회용(4개 파라미터) 생성자를 제공하여 용도에 맞게 객체를 생성할 수 있도록 함. `Book` 클래스에서도 신규 등록용과 DB 조회용 생성자를 분리하여 상태 값 변환 로직을 캡슐화함

## 동적 SQL 생성과 LIKE 연산자 활용
`searchBooks()` 메소드에서 사용자가 선택한 검색 조건(이름/출판사/저자/분류코드)에 따라 WHERE 절을 동적으로 생성하고, `LIKE '%검색어%'` 패턴으로 부분 검색을 구현함. Switch문으로 사용자 입력을 DB 컬럼명으로 매핑하는 패턴이 유용함을 깨달음

## 상태 관리와 비즈니스 규칙 구현
도서의 대출 가능 여부(`b_inLibrary`)를 DB에 저장하고, 대출/반납 시 상태를 변경하는 패턴을 구현함. 대출 권수 제한(3권), 본인 대출 도서 확인, 이미 대출 중인 도서 체크 등의 비즈니스 규칙을 Service 계층에서 구현하여 데이터 무결성을 보장함

## 관리자 권한 체크 패턴
`User.equals()` 메소드를 재정의하여 `id` 필드 기반으로 동등성을 비교하고, `u.equals(ls.admin())` 패턴으로 관리자 여부를 확인함. 이를 통해 일반 사용자와 관리자 메뉴를 명확히 분리하고 권한 기반 접근 제어를 구현함

## 예외 처리와 리소스 관리
모든 DB 작업 메소드에서 `throws Exception`을 선언하여 예외를 상위 계층으로 전파함. `close()` 메소드에서 `PreparedStatement`, `Connection` 순서로 리소스를 명시적으로 해제하는 패턴을 일관되게 적용함. 실무에서는 try-with-resources 문을 사용한 자동 리소스 관리가 권장됨을 깨달음

## 사용자 경험 개선
대출 가능 여부 표시, 대출 권수 제한 경고 메시지, 탈퇴 요청 목록 먼저 표시 후 처리, 반납 전 현재 빌린 목록 표시 등 사용자 편의를 고려한 기능을 구현함. 단순히 기능만 구현하는 것이 아니라 사용자 관점에서 직관적이고 안전한 인터페이스를 제공하는 것이 중요함을 깨달음

---

**[허윤, 조현] | 금융DT 아카데미 교육생**
