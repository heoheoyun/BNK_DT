# 🛠️ 핵심 기술 역량

## 열거형(Enum) 설계 및 활용
- **타입 안전성**: `enum`을 통해 컴파일 타임에 타입 체크가 가능한 상수 정의
- **인터페이스 기반 상수의 한계 극복**: `interface`의 `public static final` 상수는 타입 안전성이 없어 잘못된 값 전달 가능
- **enum의 고급 기능**:
  - 생성자를 통한 필드 초기화
  - 추상 메소드 정의로 각 상수별 고유 동작 구현
  - `toString()` 재정의로 커스텀 출력 형식 제공
- **실무 적용**: 회원 권한(`ADMIN`, `MEMBER`, `GUEST`)별 페이지 라우팅 로직 구현

## 중첩 클래스(Nested Class) 구조
- **Static Nested Class**: 외부 클래스의 인스턴스 없이 독립적으로 생성 가능
- **Member Inner Class**: 외부 클래스의 인스턴스에 종속되며, 외부 클래스의 `private` 멤버에 접근 가능
- **Local Inner Class**: 메소드 내부에서만 사용 가능한 클래스로 캡슐화 강화
- **Anonymous Inner Class**: 이름 없는 클래스로 인터페이스 구현체를 즉석에서 생성
- **접근 범위 차이**: Static은 외부 인스턴스 불필요, Non-Static은 외부 인스턴스 참조 필수

## 람다 표현식(Lambda Expression)
- **함수형 인터페이스**: `@FunctionalInterface` 애너테이션으로 추상 메소드가 하나인 인터페이스 정의
- **람다 문법 단순화**:
  - 매개변수 타입 생략: `(String s) -> ...` → `s -> ...`
  - 중괄호 생략: `() -> { return value; }` → `() -> value`
  - 매개변수 괄호 생략: `(x) -> ...` → `x -> ...` (매개변수 1개일 때)
- **익명 클래스 대체**: 코드 길이를 획기적으로 줄이고 가독성 향상
- **제네릭과 결합**: `Calculatable<T>` 인터페이스로 타입 안전성을 유지하며 범용 연산 구현

## 함수형 프로그래밍 패러다임
- **메소드를 값으로 취급**: 람다 표현식으로 메소드를 변수처럼 전달 및 저장
- **간결한 코드**: 익명 클래스 대비 코드 라인 수 70% 이상 감소
- **유연한 설계**: 동작을 파라미터로 전달하여 코드 재사용성 극대화

---

# 📂 주요 실습 프로젝트 (d0119)

## 1. 인터페이스 기반 상수의 한계 (`Ex01_ClassBasedConst.java`, `Ex02_NoSafeConst.java`)
- **상수 정의**: `interface Role`에 `ADMIN=1`, `MEMBER=2`, `GUEST=3` 정의
- **타입 안전성 부재**: `who(Person.MAN)` 메소드에 `Animal.DOG`를 전달해도 컴파일 에러 없음
- **근본 원인**: `int` 타입으로 선언되어 서로 다른 도메인의 상수를 구분할 수 없음
- **문제 상황**: `Person.MAN`과 `Animal.DOG`의 값이 모두 1이면 논리적으로 잘못된 동작 발생

## 2. Enum을 통한 타입 안전 상수 (`Ex03_SafeConst.java`)
- **enum 기본 구조**: `enum Person2 { MAN, WOMAN }`로 타입 안전 상수 정의
- **생성자 활용**: `MAN("MAN 입니다.")` 형태로 각 상수에 메시지 필드 부여
- **추상 메소드**: `abstract void go()`를 정의하여 각 상수별로 고유 동작 구현
  - `MAN.go()`: "군대 갑니다."
  - `WOMAN.go()`: "일반대 갑니다."
- **타입 안전성**: `who(Animal2.CAT)` 호출 시 컴파일 에러 발생으로 잘못된 타입 전달 방지
- **비교 연산**: `==` 연산자로 enum 상수 비교 가능 (equals() 불필요)

## 3. 회원 권한 시스템 (`Member.java`, `Role.java`)
- **Role enum 설계**:
  - `ADMIN`: "관리자 페이지로 이동합니다."
  - `MEMBER`: "메인 페이지로 이동합니다."
  - `GUEST`: "회원가입 페이지로 이동합니다."
- **Member 클래스**: `Role` 타입 필드로 회원 권한 관리
- **동적 권한 변경**: `setRole()`로 런타임에 권한 변경 및 각 권한별 페이지 라우팅
- **비즈니스 로직 캡슐화**: 권한별 동작을 enum 내부에 정의하여 중복 코드 제거

## 4. Static Nested Class (`Ex04_NestedClass.java`)
- **구조**: `Outer` 클래스 내부에 `static class Nested1`, `Nested2` 정의
- **공유 데이터**: `private static int num`을 두 중첩 클래스가 공유
- **생성 방법**: `Outer.Nested1 nst1 = new Outer.Nested1()`로 외부 인스턴스 없이 생성
- **활용**: `nst1.add(5)`로 값 증가, `nst2.print()`로 결과 출력

## 5. Member Inner Class (`Ex05_NonStaticNested.java`)
- **구조**: `Outer1` 클래스 내부에 `class Inner`, `Inner2` 정의 (static 아님)
- **외부 인스턴스 의존성**: `Outer1 o1 = new Outer1()` 생성 후 `o1.new Inner()` 형태로 내부 클래스 인스턴스 생성
- **인스턴스 종속**: 각 `Outer1` 인스턴스마다 별도의 내부 클래스 인스턴스 생성
- **데이터 공유**: `o1`의 `Inner`와 `Inner2`는 같은 `result` 변수 공유하지만, `o2`의 인스턴스들과는 별도

## 6. Local Inner Class (`Ex06_UseMemberInner.java`)
- **메소드 내부 클래스**: `getPrinter()` 메소드 안에서만 `class Printer` 정의
- **외부 변수 접근**: `Papers`의 `private String con` 필드에 접근 가능
- **캡슐화 강화**: `Printer` 클래스는 메소드 외부에서 접근 불가, 정보 은닉 극대화
- **인터페이스 반환**: `Printable` 타입으로 반환하여 구현 세부사항 숨김

## 7. Anonymous Inner Class와 람다 전환 (`Ex07_AnonymousInner.java`)
- **익명 클래스**: `new Printable2() { @Override public void print() {...} }` 형태로 즉석 구현
- **람다 표현식**: `() -> System.out.println(con)`으로 간결하게 변환
- **코드 비교**: 7줄의 익명 클래스 → 1줄의 람다 표현식 (86% 코드 감소)

## 8. 람다 표현식 기본 문법
### 매개변수 없음, 반환값 없음 (`Ex08_NoParamNoReturn.java`)
```java
// 익명 클래스
f = new Flyable() {
    @Override
    public void fly() {
        System.out.println("날자~~");
    }
};

// 람다 - 중괄호 포함
f = () -> { System.out.println("날자고~~"); };

// 람다 - 여러 줄
f = () -> { 
    System.out.println("날자고라~~");
    System.out.println("Hello");
};
```

### 매개변수 1개, 반환값 없음 (`Ex09_OneParamNoReturn.java`)
```java
// 익명 클래스
s = new Singable() {
    @Override
    public void sing(String song) {
        System.out.println(song);
    }
};

// 람다 - 타입 명시
s = (String song) -> { System.out.println(song); };

// 람다 - 타입 생략
s = (song) -> { System.out.println(song); };

// 람다 - 중괄호 생략
s = (song) -> System.out.println(song);

// 람다 - 괄호 생략 (매개변수 1개일 때만)
s = song -> System.out.println(song);
```

### 매개변수 1개, 반환값 있음 (`Ex10_OneParamOneReturn.java`)
```java
// 람다 - return 명시
hl = (s) -> { return s.length(); };

// 람다 - return 생략 (표현식만 있을 때)
hl = s -> s.length();
```

### 매개변수 2개, 반환값 있음 (`Ex11_TwoParamOneReturn.java`)
```java
// 람다 - return 명시
calc = (n, m) -> { return n + m; };

// 람다 - return 생략
calc = (n, m) -> n + m;
```

## 9. 함수형 인터페이스 고급 기능 (`Ex11_TwoParamOneReturn.java`)
- **@FunctionalInterface**: 컴파일러가 추상 메소드가 1개인지 검증
- **default 메소드**: `default int sub(int n, int m)` 정의로 기본 구현 제공
- **static 메소드**: `static int mul(int n, int m)` 정의로 유틸리티 메소드 제공
- **람다와 함께 사용**: 추상 메소드는 람다로 구현, default/static 메소드는 직접 호출

## 10. 제네릭 람다 (`LamdaGeneric.java`)
- **제네릭 함수형 인터페이스**: `Calculatable<T>`로 타입 매개변수 정의
- **타입별 람다**: 
  - `Calculatable<Integer> ci = (n, m) -> n + m`
  - `Calculatable<Double> cd = (n, m) -> n + m`
  - `Calculatable<Float> cf = (n, m) -> n + m`
- **타입 안전성**: 각 람다는 선언된 타입에 맞게 연산 수행

---

# 📝 실습 회고

## Enum의 강력함
단순한 상수 정의를 넘어 생성자, 필드, 추상 메소드를 가진 enum을 구현하며 객체지향 설계의 확장성을 경험함. 특히 회원 권한 시스템에서 각 권한별 동작을 enum 내부에 캡슐화하여 코드 중복을 제거하고 유지보수성을 향상시킴

## 중첩 클래스의 실용성
Static Nested Class는 외부 클래스의 네임스페이스를 활용하면서도 독립적으로 동작하고, Member Inner Class는 외부 인스턴스의 private 멤버에 접근 가능한 점이 강력함. Local Inner Class는 메소드 스코프로 캡슐화를 극대화할 수 있음을 체감함

## 람다 표현식의 혁명
익명 클래스 대비 코드 감소를 직접 확인하며 람다 표현식의 강력함을 실감함. 매개변수 타입 생략, 중괄호 생략, return 생략 등 단계적으로 간결화하는 과정을 통해 함수형 프로그래밍의 핵심 철학을 이해함

## 함수형 인터페이스의 설계
`@FunctionalInterface` 애너테이션으로 컴파일 타임에 추상 메소드 개수를 검증하고, default/static 메소드로 유틸리티 기능을 추가하는 설계 패턴을 학습함. 람다는 추상 메소드만 구현하므로 인터페이스의 역할이 명확히 분리됨을 체득함

## 제네릭과 람다의 결합
`Calculatable<T>` 인터페이스를 통해 타입 안전성을 유지하면서도 람다의 간결함을 활용할 수 있음을 확인함. Integer, Double, Float 등 다양한 타입에 대해 동일한 람다 형식으로 연산을 구현하는 유연성이 인상적이었음

## 타입 안전성의 중요성
인터페이스 기반 상수와 enum을 비교하며, 컴파일 타임 타입 체크의 중요성을 깊이 이해함. `Person.MAN`과 `Animal.DOG`가 같은 값(1)을 가져도 enum으로 정의하면 타입 불일치 에러를 사전에 방지할 수 있음

---

**[허윤] | 금융DT 아카데미 교육생**
