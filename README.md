# 출입 통제 시스템

## Requirements

- Java 17
- SpringBoot 3.x.

# 설계

## 이벤트 스토밍

* 관리 Tool
  URL : [miro - NHN IDC](https://miro.com/welcomeonboard/MGNyZkRkajFFbEd1czJZZjI5aVh6dEtaekpLekgyMmR2dFJRTXJSRVBPQmJpS0lyZkpZOEJaMmVmUUZpa21BU3wzNDU4NzY0NTE1NTQ3ODg4MTEyfDI=?share_link_id=952913919009)
* 설명
    * 색깔 별 역할
        * <span style="color:#009800">**연두색**</span>(Actor) : Command를 수행하는 주체자
        * <span style="color:#207de5">**파란색**</span>(Command) : Event 를 발생시키는 요인. ex) 상품 장바구니 추가
        * <b><span style="color:#eb6420">주황색</span></b>(Event) : Domain Events, 과거형 or 수동형. ex) 상품 장바구니 추가 됨
        * <span style="color:#e11d21">빨강색</span>(External System) : 외부 시스템으로 요청. ex) E-mail, SMS 전송 등
    * 시간순 정렬
        * 왼쪽 -> 오른쪽
        * 위 -> 아래

![image](https://user-images.githubusercontent.com/53864640/235571430-539437f5-8bb3-4971-88bb-be0639dc214a.png)

## 도메인 설계

* 관리 Tool URL : [draw.io](https://drive.google.com/file/d/1RBAFm_5Ct6FpbNp0LnLGkR2ewc_aPfdQ/view?usp=sharing)

<br>

![image](https://user-images.githubusercontent.com/53864640/235571495-2891d539-cfab-4d85-88fc-75f078c26024.png)

![image](https://user-images.githubusercontent.com/53864640/235571539-c361b82b-fb37-4dc4-9618-b3118ffe5231.png)

## 애플리케이션 아키텍처

* DDD
* [헥사고날 아키텍처](https://tonyjev93.github.io/architecture/hexagonal%20architecture/hexagonal-architecture/)
* Event Driven Architecture
    * [참고1 - 이벤트 기반 아키텍처(Event-Driven Architecture)란?](https://velog.io/@youngeui_hong/Event-Driven-Architecture)
    * [참고2 - 이벤트 기반 아키텍처](https://cloud.google.com/eventarc/docs/event-driven-architectures?hl=ko)
* MSA(X) = Overengineering

**도메인 중심의 설계**(DDD)를 위해 **헥사고날 아키텍처**를 사용하며 의존성 완화를 위해 **이벤트 기반**으로 모듈 및 서비스간 상호작용이 가능 하도록 한다.
**MSA**의 경우 서비스의 규모와 개발자의 학습 정도를 고려할 때 **과한 기술적용**이기 때문에 적용하지 않는다.

# 구현

## Hexagonal Architecture(Sample)

![image](https://user-images.githubusercontent.com/53864640/235586328-e853be12-0af4-41b8-8247-93a6e147f70f.png)

## 모듈

* portal-server : IDC 포탈 서버를 실행하기 위한 모듈(서비스 실행을 위한 Root)
    * 필요되는 모듈의 adapter를 의존
* user : 사용자 관리
    * 회원 가입, 로그인, 탈퇴, 권한
* data-center : 데이터 센터 관리
    * 데이터 센터 등록, 수정, 삭제
* visit : 방문 관리
    * 방문 신청, 승인, 반려, 취소
* access : 출입 관리
    * 출입증 발급, 반납, 폐기, 출입 이력 조회
* sms : SMS 관리
    * SMS 전송, 전송 이력 조회

## 모듈 구성

### {domain}-adapter

: 외부 시스템과 소통하기 위한 Layer

* **in** : 외부에서 요청이 들어오는 곳. ex) Controller, EventListen
* **out** : 외부로 요청을 보내는 곳. ex) DB, 다른 모듈 호출, 외부 API 호출
* **global(Optional)** : adapter에 전체적으로 적용 되는 기능. ex) ExceptionHandler, 공통 API 응답, config 파일 등

### {domain}-application

: 비즈니당 핵심 로직에 접근할 수 있도록 지원 해주는 중계 Layer

* **port** : adapter와 소통하기 위한 인터페이스
    * **in** : 이용 가능한 도메인 서비스를 노출시키는 인터페이스(= UseCase)
    * **out** : 도메인 서비스가 사용할 외부 시스템에 대한 인터페이스
    * **dto(Optional)** : adapter와 소통할 때 사용될 객체들
        * **vo** : 값 만을 가지고 있는 객체
    * **exception(Optional)** : port 내에서 발생 가능한 예외
* **service** : port in의 구현체, UseCase의 내부 로직

### {domain}-domain

: 비즈니스 핵심 로직 담당

* **domain** : 핵심 도메인 정의
* **vo** : 도메인에 사용되는 값 객체 정의

## 모듈 간 의존성 관계

* Adapter -> Application -> Domain

다른 도메인의 데이터가 필요한 경우 다른 도메인의 Adapter를 통해 받아온다.

> 해당 프로젝트에서는 해당 모듈의 UseCase를 사용할 수 있도록 **Proxy** 역할을 수행하는 서비스를 Adapter.In 내에 추가 하였고 이를 통해 외부의 다른 모듈에서도 해당 모듈의 UseCase를 이용할 수 있도록 하였음.
>
> 각 모듈이 Micro Service로 분리가 된다면 Adapter.Out.Proxy -> Adapter.In.Proxy 간의 의존성을 API 호출을 통해 끊어낼 수 있기 때문에 유연한 확장이 가능한 구조라고 생각한다.
