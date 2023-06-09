# 🛵 One Delivery BE

배달 플랫폼 API 서버 프로젝트

## 프로젝트 목표

- 배달 앱을 위한 서비스 API 서버를 구현하는 것을 목표로 하였습니다.
- 테스트 코드를 작성하여 안정적인 코드를 작성하는 것을 목표로 하였습니다.
- CI/CD 자동화를 직접 구현하여 무중단 배포를 경험해 보는 것을 목표로 하였습니다.
- Redis를 사용해 장바구니를 캐시 서버로 구현하여 응답속도를 개선하는 것을 목표로 하였습니다.
- Docker를 이용하여 CD 구현을 목표로 하였습니다.
- Mysql Replication을 통한 성능 개선을 위해 데이터베이스 이중화 구현을 목표로 하였습니다.
- API 자동 문서화 툴을 사용하여 효율적인 API 문서 생성을 목표로 하였습니다.
- AWS Lambda를 활용한 이미지 리사이징 작업 구현하여 서버의 부담을 줄이는 것을 목표로 하였습니다.
- 다양한 프로젝트 환경을 경험하는 것을 목표로 하였습니다.
  - Spring -> Spring Boot
  - Maven -> Gradle
  - MyBatis -> JPA
  - Session -> JWT
  - properties -> yml

## 프로젝트 주요 기능

- 회원가입 및 로그인
- 사용자 매장 조회 및 주문
- 사장님 매장 및 메뉴 관리
- 사장님 매장 상태 관리

## 프로젝트 Vaildation 계획

### Controller

- 값 유효성 검사
- javax, vaildation API 사용

### Service

- 비즈니스 유효성 검사
- 논리적 유효성 검사

### DB

- 데이터 무결성 검사
- DB 내장 Column Validation 활용
- Controller 레이어와 동일 적용

## API 명세

| No. | Method | URL | 기능 |
| --- | --- | --- | --- |
| 1 | GET | /stores | 매장 리스트 조회 |
| 2 | GET | /stores/{storeId} | 매장 조회 |
| 3 | POST | /stores | 매장 생성 |
| 4 | GET | /menus/{storeId} | 메뉴 리스트 조회 |