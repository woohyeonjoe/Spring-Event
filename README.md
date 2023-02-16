# Spring Event

## 이벤트를 사용하는 이유

다음과 같은 회원가입 로직이 있다고 가정해보자.

1. 회원 추가
2. 가입 축하 메세지
3. 쿠폰발급

```java
@Service
@Trancsactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final SenderService senderService;
  private final CouponService couponService;

  public void create(UserRequest userRequest) {
    		//회원 추가
		...

		//가입 축하 메세지
		...

		//쿠폰 발급
		...
  }
}
```

이렇게 하나의 Service에서 모두 처리하면 다음과 같은 문제가 있다.

**결합도**

높은 결합도는 후에 유지보수가 어려울뿐만 아니라 코드의 구조가 복잡해진다.

**트랜잭션**

가입 축하 메세지 또는 쿠폰발급 로직에서 예외가 발생하면 회원 추가까지 모두 롤백을 하게 된다.

회원 추가가 완료되고, 축하 메세지와 쿠폰 발급은 따로 관리하는게 좋은 설계일 것이다.

**성능**

메인 이벤트인 회원 추가 로직이 끝나고, 가입 축하 메세지와 쿠폰발급 로직을 기다리게 된다.

성능을 생각하면 회원 추가가 완료되면 나머지 로직들은 따로 실행되게 해야 할 것이다.

**바로 위와 같은 상황에서 이벤트를 사용하는 것이다. 이벤트는 생성 주체의 상태가 변경되면 이벤트를 발생시켜 원하는 로직을 실행시킬 수 있다.**

## 이벤트 실행 단계

1. 생성 주체(주로 도메인 객체)에서 이벤트를 발생하면 이벤트 디스패처에게 전달
2. 이벤트 디스패처가 이벤트 핸들러를 연결
3. 이벤트 핸들러(`@EventListener`)에서 이벤트에 담긴 데이터를 통해 원하는 기능을 실행

## 비동기 처리

이벤트 처리로 서비스단의 **결합도**를 낮추고, 자연스럽게 **트랜잭션** 문제도 해결 할 수 있다.

마지막 과제인 **성능**은

- 가입 축하 메세지
- 쿠폰발급

이 두가지 로직을 **비동기**로 처리하면 된다.

## 📖 Reference

[실습 프로젝트](https://github.com/tongnamuu/SpringEvent)

[https://shinsunyoung.tistory.com/88](https://shinsunyoung.tistory.com/88)

[https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-functionality-events](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-functionality-events)
