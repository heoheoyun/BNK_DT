# 🏦 BNK 부산은행 웹사이트 클론 프로젝트

> **금융DT 아카데미 개발자 양성과정 - HTML/CSS 실전 프로젝트**

부산은행 공식 웹사이트를 벤치마킹하여 제작한 클론 코딩 프로젝트입니다.  
**순수 HTML/CSS만을 활용**하여 JavaScript 없이 구현 가능한 기능들을 최대한 구현했습니다.

---

## 👥 팀 구성 및 역할 분담

| 이름 | 담당 파트 | 주요 작업 |
|------|-----------|-----------|
| **허윤** | 헤더, 챗봇, 동백전 | 헤더 컴포넌트, 챗봇 페이지, 동백전 잔액조회 페이지 및 해당 CSS |
| **장진우** | 메인 페이지 | 메인 페이지 레이아웃, 슬라이더, 빠른메뉴 및 해당 CSS |
| **김건엽** | 푸터 | 푸터 컴포넌트, 금융사고예방/소비자권익보호 섹션 및 해당 CSS |

---

## 📋 프로젝트 개요

* **프로젝트명**: BNK 부산은행 웹사이트 클론
* **제작 기간**: 2026.02.06 ~ 진행중
* **개발 방식**: 순수 HTML/CSS (JavaScript 최소 사용)
* **주요 페이지**: 메인 페이지, 챗봇 페이지, 동백전 잔액조회 페이지

---

## 🎯 주요 기능

### 1️⃣ 헤더 (Header) - 담당: 허윤
* **로고 및 네비게이션 바**
* **사용자 메뉴**:
  - 로그인, 고객센터, 은행소개
  - Global 언어 선택 (hover 드롭다운)
* **메인 네비게이션**:
  - 개인뱅킹, 기업뱅킹, 금융상품
  - 검색 아이콘
  - 전체 메뉴 (체크박스 트리거 방식)
* **전체 메뉴 드롭다운**:
  - 순수 CSS로 구현 (`input:checked` 활용)
  - 풀페이지 오버레이 스타일
  - 4개 컬럼 레이아웃

### 2️⃣ 메인 페이지 (Main) - 담당: 장진우
* **메인 배너 슬라이더**:
  - 750×280px 크기
  - 3초 간격 자동 전환
  - 점(dot) 네비게이션
* **추천 상품 캐러셀**: 300×280px
* **빠른 서비스 메뉴**:
  - 빠른조회 (연한 빨강 배경)
  - 이체 (빨강 배경)
  - 서민금융/인증센터/금융보호서비스 (연한 회색 배경)
  - 호버 효과 (상승 + 그림자)
* **금융 상품 섹션**: 예금, 대출, 펀드, 신탁, 외화, 보험, ISA
* **새소식/이벤트 게시판**: 333.33×190.39px 카드형 레이아웃
* **동백전 연동**:
  - 잔액조회 버튼
  - 동백전 바로가기

### 3️⃣ 챗봇 페이지 (Chatbot) - 담당: 허윤
* **대화형 UI 디자인**:
  - 날짜별 대화 구분 (배지 스타일)
  - 챗봇 질문 말풍선 (테두리 + 그림자)
* **질문 카테고리 버튼**:
  - 계좌 개설/조회
  - 대출 상담
  - 카드 분실 신고
  - 지점 위치 안내
* **헤더 컨트롤**:
  - 이전 대화 불러오기
  - 나가기 버튼
* **입력 인터페이스**:
  - 라운드 형태의 입력창
  - 보내기 버튼 (Tomato 컬러)

### 4️⃣ 동백전 잔액조회 페이지 (Dongback) - 담당: 허윤
* **사용자 정보 태그**: "OOO님" 표시
* **사이드바 네비게이션**:
  - 이용내역
  - 금액충전
  - 자동충전
  - 호버 효과 (배경색 변경)
* **카드형 잔액 표시** (Flexbox 레이아웃):
  - 충전 잔액 (블루 그라데이션)
  - 캐시백 (블루 그라데이션)
  - 정책 지원금 (블루 그라데이션)
* **동백패스 게이지 바**:
  - 순수 CSS로 진행률 표시
  - 인라인 스타일로 퍼센트 조절

### 5️⃣ 푸터 (Footer) - 담당: 김건엽
* **금융사고예방 섹션**:
  - 보이스피싱 주의사항
  - 금융사기 예방 안내
* **소비자권익보호 섹션**:
  - 고객 권리 안내
  - 민원 접수 안내
* **푸터 네비게이션**:
  - 개인정보처리방침
  - 경영공시
  - 고객정보취급방침
  - 상품공시실
  - 전자민원접수
* **고객 상담 정보**: 1588-6299, 1544-6200
* **패밀리 사이트 드롭다운** (체크박스 방식):
  - BNK금융네트워크 (위로 펼침)
  - Family Style (위로 펼침)
* **저작권 표시**: COPYRIGHT ⓒ 2014 BUSANBANK

---

## 🎨 디자인 스펙

### 컬러 팔레트
```css
/* Primary Colors */
--brand-red: #ed1c24;          /* 부산은행 메인 컬러 */
--tomato: tomato;              /* 버튼 강조색 */

/* Background Colors */
--chatbot-bg: #EFEFEF;         /* 챗봇 페이지 배경 */
--light-red: rgb(252, 148, 148); /* 빠른조회 배경 */
--red: #f72222;                /* 이체 버튼 배경 */
--light-gray: #f8f4f4;         /* 서브 메뉴 배경 */
--blue-card: #0047bb;          /* 동백전 카드 배경 */
--footer-bg: rgb(245, 243, 243); /* 푸터 배경 */

/* Text Colors */
--text-primary: #222222;       /* 본문 텍스트 */
--text-secondary: #616161;     /* 보조 텍스트 */
--text-gray: gray;             /* 푸터 텍스트 */
--text-light: lightslategray;  /* 네비게이션 */

/* Chatbot Specific */
--date-bg: #848A92;            /* 챗봇 날짜 배경 */
--chat-white: #FFFFFF;         /* 챗봇 말풍선 */
```

### 타이포그래피
```css
/* Font Family */
font-family: 'Dotum', '돋움', sans-serif;           /* 기본 폰트 */
font-family: 'Noto Sans KR', AppleGothic, sans-serif; /* 챗봇 폰트 */

/* Font Sizes */
--fs-heading: 20px ~ 22px;  /* 헤딩 */
--fs-nav: 16px;             /* 네비게이션 */
--fs-body: 14px;            /* 본문 */
--fs-small: 12px ~ 13px;    /* 작은 텍스트 */
```

---

## 📂 파일 구조
```
project/
├── index.html          # 메인 페이지 (장진우)
├── chatbot.html        # 챗봇 페이지 (허윤)
├── dongback.html       # 동백전 잔액조회 페이지 (허윤)
└── css/
    └── style.css       # 통합 스타일시트 (869 lines)
                        # - Header (line 17~217): 허윤
                        # - Chatbot (line 218~326): 허윤  
                        # - Main Banner & Quick Menu (line 327~483): 장진우
                        # - Main Contents (line 484~562): 장진우
                        # - Footer (line 564~768): 김건엽
                        # - Dongback (line 772~869): 허윤
```

---

## 🛠️ 구현 기술 (순수 HTML/CSS)

### HTML5
* **시맨틱 태그**: `<header>`, `<nav>`, `<main>`, `<section>`, `<aside>`, `<footer>`
* **체크박스 트리거**: JavaScript 없이 드롭다운 메뉴 구현
```html
  <input type="checkbox" id="menu-trigger" style="display: none;">
  <label for="menu-trigger">메뉴</label>
```

### CSS3 핵심 기술

#### 1. Flexbox 레이아웃
```css
/* 헤더 레이아웃 - 허윤 */
.page-header {
    display: flex;
    justify-content: space-between;
}

/* 메인 배너 레이아웃 - 장진우 */
.mainpage1 {
    display: flex;
    justify-content: space-between;
}

/* 동백전 카드 레이아웃 - 허윤 */
.dongback-content-blocks {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

/* 푸터 레이아웃 - 김건엽 */
.financial-accident {
    display: flex;
    justify-content: space-between;
}
```

#### 2. 체크박스 기반 인터랙션
```css
/* 전체 메뉴 토글 - 허윤 */
#menu-trigger:checked ~ .header-menu {
    display: block;
}

/* 푸터 드롭다운 - 김건엽 */
.toggle:checked + .drop-btn + .drop-list {
    display: block;
}
```

#### 3. Hover 효과
```css
/* 네비게이션 호버 - 허윤 */
.main-nav a:hover {
    color: #ed1c24;
}

/* 빠른메뉴 호버 - 장진우 */
.quick-btn:hover {
    background-color: #f87e7e;
    transform: translateY(-3px);
    box-shadow: 0px 5px 10px rgb(27, 27, 27);
}

/* 동백전 사이드바 호버 - 허윤 */
.dongback-side-nav a:hover {
    color: #ed1c24;
    background-color: #f9f9f9;
}
```

#### 4. Position 활용
```css
/* 챗봇 아이콘 고정 - 허윤 */
#chatbot-icon {
    position: sticky;
    left: 80%;
    top: 35%;
    z-index: 9999;
}

/* 슬라이더 이미지 배치 - 장진우 */
.slide {
    position: absolute;
    width: 100%;
    height: 100%;
    opacity: 0;
    transition: opacity 0.5s ease;
}

/* 전체 메뉴 중앙 정렬 - 허윤 */
.header-menu {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
}
```

---

## 💡 순수 CSS로 구현한 기능들

### ✅ JavaScript 없이 구현 성공

1. **드롭다운 메뉴** (체크박스 + `:checked` 활용)
2. **언어 선택** (`:hover` 활용)
3. **전체 메뉴 오픈/클로즈** (체크박스 + label)
4. **푸터 패밀리사이트 메뉴** (위로 펼침, 체크박스 방식)
5. **호버 효과** (색상 변경, transform, shadow)
6. **슬라이더 전환 효과** (opacity transition)
7. **게이지 바** (width 퍼센트로 진행률 표현)

### 🎯 핵심 구현 포인트

#### 전체 메뉴 드롭다운 (허윤)
```css
/* HTML */
<input type="checkbox" id="menu-trigger" style="display: none;">
<label for="menu-trigger" class="all-menu-btn">메뉴</label>
<div class="header-menu">...</div>

/* CSS */
#menu-trigger:checked ~ .header-menu {
    display: block;
}
```

#### 슬라이더 효과 (장진우)
```css
.slide {
    position: absolute;
    opacity: 0;
    transition: opacity 0.5s ease;
}

.slide.active {
    opacity: 1;
}
```

#### 챗봇 말풍선 디자인 (허윤)
```css
.chatbot-bot-q {
    background: #FFFFFF;
    border: 1px solid #222222;
    border-radius: 0 15px 15px 15px; /* 왼쪽 상단만 각지게 */
    box-shadow: 2px 2px 0px rgba(0,0,0,0.1);
}
```

#### 동백전 게이지 바 (허윤)
```css
.dongback-gauge-track {
    height: 20px;
    background-color: #efefef;
    border-radius: 10px;
    overflow: hidden;
}

.dongback-gauge-fill {
    height: 100%;
    background-color: #ed1c24;
    /* 인라인 스타일로 width 조절: style="width: 75%;" */
}
```

#### 푸터 드롭다운 (김건엽)
```css
.drop-list {
    position: absolute;
    bottom: calc(100% + 8px);  /* 버튼 "위"로 뜨게 */
    display: none;
}

.toggle:checked + .drop-btn + .drop-list {
    display: block;
}
```

---

## 🔗 참고 리소스

### 이미지 URL

| 구분 | 크기 | URL |
|------|------|-----|
| 은행 로고 | 132×21px | `https://www.busanbank.co.kr/resource/img/tit/h1_busanbank_new.png` |
| 챗봇 아이콘 | 56×56px | `https://ibank.busanbank.co.kr/resource/img/bg/bg_faqLink4.png` |
| 메뉴 아이콘 | 32×32px | `https://www.busanbank.co.kr/resource/img/ico/cmn/ico_gnb_allmenu.png` |
| 검색 아이콘 | 32×32px | `https://www.busanbank.co.kr/resource/img/ico/cmn/ico_gnb_search.png` |
| 동백전 로고 | - | `https://busandong100.kr/tm/img/mo_logo02.png` |

---

## 🚀 실행 방법

### VS Code에서 실행
1. 프로젝트 폴더를 VS Code로 열기
2. Live Server 확장 프로그램 설치
3. `index.html` 우클릭 → `Open with Live Server`
4. 브라우저에서 `http://localhost:5500` 자동 열림

### 페이지 간 이동
* **메인 → 챗봇**: 챗봇 아이콘 클릭
* **챗봇 → 메인**: 나가기 버튼 클릭
* **메인 → 동백전**: 동백전 잔액조회 박스 클릭
* **동백전 → 메인**: 헤더 로고 클릭

---

## ✅ 파트별 개발 현황

### 허윤 담당 파트
- [x] 헤더 컴포넌트 (로고, 네비게이션, 사용자 메뉴)
- [x] Global 언어 선택 드롭다운 (hover 방식)
- [x] 전체 메뉴 드롭다운 (체크박스 트리거)
- [x] 챗봇 페이지 전체 UI/UX
  - [x] 날짜 배지
  - [x] 말풍선 디자인
  - [x] 카테고리 버튼
  - [x] 입력창 (라운드 스타일)
- [x] 동백전 잔액조회 페이지
  - [x] 사용자 태그
  - [x] 사이드바 네비게이션
  - [x] 카드형 잔액 표시 (3개)
  - [x] 동백패스 게이지 바
- [x] 해당 섹션 CSS

### 장진우 담당 파트
- [x] 메인 페이지 레이아웃
- [x] 메인 배너 슬라이더 (750×280px)
- [x] 추천 상품 캐러셀 (300×280px)
- [x] 빠른 서비스 메뉴 (빠른조회, 이체 등)
- [x] 금융 상품 섹션
- [x] 새소식/이벤트 게시판
- [x] 동백전 연동 버튼
- [x] 해당 섹션 CSS

### 김건엽 담당 파트
- [x] 푸터 전체 구조
- [x] 금융사고예방 섹션
- [x] 소비자권익보호 섹션
- [x] 푸터 네비게이션 링크
- [x] 고객 상담 정보
- [x] 패밀리 사이트 드롭다운 (위로 펼침)
- [x] 저작권 표시
- [x] 해당 섹션 CSS

---

## 📝 학습 내용 및 회고

### 배운 기술

#### 1. 순수 CSS 인터랙션
* JavaScript 없이 체크박스와 `:checked` pseudo-class를 활용한 드롭다운 구현
* `display: none` 체크박스 + `<label>` 조합으로 클릭 이벤트 처리
* 형제 선택자(`~`, `+`)를 활용한 상태 제어

#### 2. Flexbox 마스터
* `justify-content`, `align-items`로 정렬
* `flex-direction: column`으로 수직 레이아웃
* `gap` 속성으로 간격 관리
* `flex: 1`, `flex: 3`으로 비율 조절

#### 3. 고급 CSS 스타일링
* `border-radius`로 말풍선 효과 (한쪽만 각지게)
* `box-shadow`로 입체감 부여
* `overflow: hidden`으로 게이지 바 구현
* `transform: translateX(-50%)`로 정확한 중앙 정렬
* `position: absolute` + `opacity` transition으로 슬라이더 구현

### 협업 경험

#### 장점
* 파트별 분업으로 효율적인 작업 진행
* 하나의 CSS 파일로 통합 관리하여 일관성 유지
* 각자 맡은 영역의 CSS 라인을 명확히 구분

#### 개선점
* CSS 네이밍 컨벤션 사전 협의 필요
* 공통 컴포넌트(헤더, 푸터) 먼저 완성 후 메인 작업 권장
* Git을 활용한 버전 관리 도입 필요

### 프로젝트 회고

#### 잘한 점
* JavaScript 없이도 충분히 인터랙티브한 UI를 구현할 수 있다는 것을 증명
* 체크박스 트리거 패턴을 활용하여 드롭다운 일관성 있게 구현
* Flexbox만으로 복잡한 레이아웃을 깔끔하게 정리
* 3명이 역할 분담하여 효율적으로 작업 완료

#### 아쉬운 점
* 실제 동작하는 기능(메시지 전송, 잔액 조회 등)은 JavaScript 필요
* 반응형 디자인 미구현 → 모바일 환경 고려 필요
* CSS 파일이 869줄로 길어져 유지보수성 고려 필요
* Git 미사용으로 버전 관리 및 협업 히스토리 부재

#### 개선 방향
* JavaScript 추가하여 실제 동작하는 기능 구현
* 미디어 쿼리 추가로 반응형 웹 완성
* CSS 모듈화 (SCSS 도입, 파일 분리)
* Git/GitHub를 활용한 협업 체계 구축

---

## 🎓 기술 스택 정리

### 사용 기술
* **HTML5**: 시맨틱 태그, 체크박스 트리거
* **CSS3**: Flexbox, Position, Transition, Pseudo-class, Transform
* **개발 도구**: VS Code, Live Server

### 미사용 기술 (의도적 배제)
* ~~JavaScript~~ (순수 CSS 구현 목표)
* ~~jQuery~~
* ~~Bootstrap~~ (직접 스타일링)
* ~~Sass/SCSS~~ (순수 CSS 사용)

---

**[허윤]** | 금융DT 아카데미 교육생  
**프로젝트 기간**: 2026.02.06 ~ 2026.02.09
