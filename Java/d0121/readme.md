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
- **생성자 오버로딩**:
  - `Member(String id, String pw)`: 로그인 검증용
  - `Member(String id, String pw, String name)`: 전체 정보용 (생성자 체이닝 `this()` 사용)
- **Getter 메소드**: 각 필드에 대한 접근자 제공
- **toString() 재정의**: 회원 정보를 보기 좋게 포맷팅하여 출력

## 2. 데이터 접근 계층 (`DBAccess.java`)

### 2-1. DB 연결 관리
```java
private String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
private String user = "green";
private String pw = "1234";
private Connection con;

public DBAccess() throws Exception {
    con = DriverManager.getConnection(url, user, pw);
}
```
- 생성자에서 DB 연결 수립 및 `Connection` 객체 유지

### 2-2. 회원가입 (INSERT)
```java
public void insert(Member member) throws Exception {
    sql = "INSERT INTO Member (id, pw, name) Values (?, ?, ?)";
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, member.getId());
    pstmt.setString(2, member.getPw());
    pstmt.setString(3, member.getName());
    pstmt.executeUpdate();
}
```
- `?` 플레이스홀더 3개에 `setString()`으로 값 바인딩
- `executeUpdate()`: INSERT, UPDATE, DELETE에 사용

### 2-3. 로그인 검증 (SELECT COUNT)
```java
public boolean check(Member member) throws Exception {
    sql = "Select Count(*) as cnt from Member where id = ? and pw = ?";
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, member.getId());
    pstmt.setString(2, member.getPw());
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    return rs.getInt("cnt") > 0;
}
```
- `COUNT(*)`로 일치하는 레코드 개수 확인
- 1 이상이면 로그인 성공, 0이면 실패

### 2-4. 회원 조회 (SELECT)
```java
// 전체 회원 조회
public ResultSet searchAll() throws Exception {
    sql = "Select * From Member order by id";
    pstmt = con.prepareStatement(sql);
    return pstmt.executeQuery();
}

// 특정 회원 조회
public ResultSet search(String id) throws Exception {
    sql = "Select * From Member where id = ?";
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, id);
    return pstmt.executeQuery();
}
```
- `executeQuery()`: SELECT 쿼리에 사용, `ResultSet` 반환

### 2-5. 회원 정보 수정 (UPDATE)
```java
public void update(Member member) throws Exception {
    sql = "Update Member set name = ?, pw = ? where id = ?";
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, member.getName());
    pstmt.setString(2, member.getPw());
    pstmt.setString(3, member.getId());
    pstmt.executeUpdate();
}
```
- `SET` 절에 새 값 바인딩, `WHERE` 절에 조건 바인딩

### 2-6. 리소스 해제
```java
public void close() throws Exception {
    if (pstmt != null) pstmt.close();
    if (con != null) con.close();
}
```
- null 체크 후 `PreparedStatement`, `Connection` 순서로 종료

## 3. 비즈니스 로직 계층 (`MemberService.java`)

### 3-1. 회원가입 (`register()`)
```java
public void register() throws Exception {
    DBAccess db = new DBAccess();
    
    // 아이디 중복 검증
    String id = null;
    while(id == null) {
        id = validTest("아이디", 3, 20);
        ResultSet rs = db.search(id);
        if(rs.next()) {
            id = null;
            System.out.println("이미 있는 ID 입니다.");
        }
        rs.close();
    }
    
    // 이름, 비밀번호 입력 및 검증
    String name = validTest("이름", 3, 20);
    String pw = validTest("비밀번호", 3, 20);
    while(checkPw(pw)); // 비밀번호 재입력 확인
    
    db.insert(new Member(id, pw, name));
    db.close();
}
```
- 아이디 중복 체크: DB 조회로 기존 아이디 존재 여부 확인
- 유효성 검증: 3~20자 길이 제한
- 비밀번호 확인: 두 번 입력하여 일치 여부 검증

### 3-2. 로그인 (`logIn()`)
```java
public Member logIn() throws Exception {
    DBAccess db = new DBAccess();
    String id = sc.nextLine().trim();
    String pw = sc.nextLine().trim();
    
    if(db.check(new Member(id, pw))) {
        Member m = newMember(id);
        db.close();
        return m; // 로그인 성공 시 Member 객체 반환
    } else {
        db.close();
        return null; // 로그인 실패 시 null 반환
    }
}
```
- `check()` 메소드로 아이디/비밀번호 일치 여부 확인
- 성공 시 DB에서 전체 회원 정보 조회하여 `Member` 객체 생성 및 반환

### 3-3. 비밀번호 변경 (`modifyPW()`)
```java
public Member modifyPW(Member member) throws Exception {
    DBAccess db = new DBAccess();
    
    String pw = validTest("비밀번호", 3, 20);
    
    // 원래 비밀번호 확인
    if(!checkPw(member.getPw())) {
        return member; // 확인 실패 시 기존 Member 반환
    }
    
    db.update(new Member(member.getId(), pw, member.getName()));
    db.close();
    
    return newMember(member.getId()); // 갱신된 정보로 새 Member 반환
}
```
- 새 비밀번호 입력 및 길이 검증
- 원래 비밀번호 재입력으로 본인 확인
- DB 업데이트 후 최신 정보로 `Member` 객체 재생성

### 3-4. 이름 변경 (`modifyName()`)
```java
public Member modifyName(Member member) throws Exception {
    DBAccess db = new DBAccess();
    
    String name = validTest("이름", 3, 20);
    
    if(!checkPw(member.getPw())) {
        return member;
    }
    
    db.update(new Member(member.getId(), member.getPw(), name));
    db.close();
    
    return newMember(member.getId());
}
```
- 비밀번호 변경과 유사한 구조, 이름만 수정

### 3-5. 유틸리티 메소드

**입력 길이 검증**
```java
public String validTest(String s, int min, int max) {
    String result = null;
    while(result == null) {
        result = sc.nextLine().trim();
        if (!(result.length() >= min && result.length() <= max)) {
            System.out.println(min + "자 이상 " + max + "자 이내로 써주세요.");
            result = null;
        }
    }
    return result;
}
```

**비밀번호 재입력 확인**
```java
public boolean checkPw(String pw) {
    if(!pw.equals(sc.nextLine().trim())) {
        System.out.println("비밀번호가 일치 하지않습니다.");
        return true; // 불일치
    }
    return false; // 일치
}
```

**DB에서 최신 회원 정보 조회**
```java
public Member newMember(String id) throws Exception {
    DBAccess db = new DBAccess();
    ResultSet rs = db.search(id);
    rs.next();
    Member m = new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
    rs.close();
    db.close();
    return m;
}
```

## 4. 실행 클래스 (`Member_Test.java`)

### 4-1. 로그인 전 메뉴
```java
while(menu) {
    System.out.println("=[ 시작  화면 ]=");
    System.out.println(" 회원 가입 : 1 ");
    System.out.println("   로그인  : 2 ");
    System.out.println(" 메뉴 종료 : 3 ");
    
    switch (select) {
        case 1: ms.register(); break;
        case 2: 
            m = ms.logIn();
            if(m != null) menu = false; // 로그인 성공 시 루프 종료
            break;
    }
}
```

### 4-2. 로그인 후 메뉴
```java
while (m != null) {
    System.out.println("=[ 회원 화면 ]=");
    System.out.println("    내 정보    : 1 ");
    System.out.println("   이름 변경   : 2 ");
    System.out.println(" 비밀번호 변경 : 3 ");
    System.out.println("    로그 아웃  : 0 ");
    
    switch (select) {
        case 1: ms.showMyInfo(m); break;
        case 2: m = ms.modifyName(m); break;
        case 3: m = ms.modifyPW(m); break;
        case 0: 
            m = null; // 로그아웃
            System.out.println("로그아웃 되었습니다.");
            break;
    }
}
```
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
