# 2022.09.07 수요일 못먹어도 고!

<br></br>

## 클래스 다이어그램

시간에 따라 변하지 않는 시스템의 정적인 면을 보여주는 대표적인 UML 구조 다이어그램
목적: 시스템을 구성하는 클래스들 사이의 관계를 표현한다.

**UML클래스의 표현**  
가장 윗 부분 : 클래스 이름  
중간부분 : 속성(클래스의 특징)  
마지막 부분 : 연산(클래스가 수행하는 책임)

경우에따라 속성과 연산 부분은 생략가능하다.(없으면!)

![uml 클래스의 표현](https://gmlwjd9405.github.io/images/class-diagram/uml-class.png)

![UML의 접근제어자](https://gmlwjd9405.github.io/images/class-diagram/access-controller.png)

**관계**
![관계](https://gmlwjd9405.github.io/images/class-diagram/association.png)

일반적으로 다대다 연관 관계는 양방향 연관 관계로 표현되는 것이 적절하다.  
하지만 양방향 연관 관계를 구현하는 것은 복잡하기 때문에 보통 다대다 연관 관계를 일대다 단방향 연관 관계 로 변환해 구현한다. -> 연관 클래스

1. 연관관계
   한 클래스가 다른 클래스와 연관관계를 가지면 각 클래스의 객체는 해당 연관 관계에서 어떤 역할을 수행하게 된다.

1-1 양방향 연관 관계
![양방향](https://gmlwjd9405.github.io/images/class-diagram/bi-directional.png)

1-2 단방향 연관 관계
![단방향](https://gmlwjd9405.github.io/images/class-diagram/uni-directional.png)

2. 일반화 관계
   한 클래스가 다른 클래스를 포함하는 상위 개념일 때 두 클래스 사이에는 일반화 관계가 존재한다.

2-1 상속관계
![상속](https://gmlwjd9405.github.io/images/class-diagram/generalization-class.png)
부모 클래스  
 추상적인 개념(실제로 존재하지 않는다.)  
 삼각형 표시가 있는 쪽  
 가전 제품

자식 클래스  
 구체적인 개념  
 삼각형 표시가 없는 쪽  
 세탁기, TV, 식기 세척기  
 ‘세탁기’ is a king of ‘가전 제품’  
 ‘TV’ is a king of ‘가전 제품’  
 ‘식기 세척기’ is a king of ‘가전 제품’

부모 클래스는 자식 클래스의 공통 속성이나 연산을 제공하는 틀이다.

추상클래스
![추상클래스](https://gmlwjd9405.github.io/images/class-diagram/abstract-class-uml.png)
추상 메서드를 하나 이상 가지는 클래스  
 추상 메서드  
 부모 클래스에서 구현되지 않은 빈 껍데기만 있는 연산  
 예를 들어, 위의 예에서 turnOn과 turnOff는 자식 클래스마다 다르기 때문에 부모 클래스인 가전 제품에서 해당 연산에 대한 정의를 하지 않고 빈 껍데기만 있는 연산(추상 메서드)를 제공한다.  
 추상 클래스는 다른 일반적인 클래스와는 달리 객체를 생성할 수 없다.

3. 집합관계  
   UML 연관 관계의 특별 경우로 전체와 부분의 관계 를 명확하게 명시하고자할 때 사용한다.
   ![집약](https://gmlwjd9405.github.io/images/class-diagram/set-uml-example.png)
   3-1 집약관계  
   한 객체가 다른 객체를 포함하는 것  
   ‘부분’을 나타내는 객체를 다른 객체와 공유할 수 있다.  
   ‘전체’를 가리키는 클래스 방향에 빈 마름모로 표시  
   전체 객체의 라이프타임과 부분 객체의 라이프 타임은 독립적이다.  
   전체 객체가 메모리에서 사라진다 해도 부분 객체는 사라지지 않는다.

```java
public class Computer {
 private MainBoard mb;
 private CPU c;
 // 생성자
 public Computer(MainBoard mb, CPU c) {
 this.mb = mb;
 this.c = c;
 }
}
생성자에서 참조값을 인자로 받아 필드를 세팅한다.
```

3-2 합성 관계(composition)  
부분 객체가 전체 객체에 속하는 관계  
‘부분’을 나타내는 객체를 다른 객체와 공유할 수 없다.  
‘전체’를 가리키는 클래스 방향에 채워진 마름모로 표시  
전체 객체의 라이프타임과 부분 객체의 라이프 타임은 의존적이다.  
전체 객체가 없어지면 부분 객체도 없어진다.

```java

public class Computer {
 private MainBoard mb;
 private CPU c;
 // 생성자
 public Computer() {
 this.mb = new MainBoard();
 this.c = new CPU();
 }
}


```

생성자에서 참조값을 인자로 받아 필드를 세팅한다.

4. 의존 관계  
   일반적으로 한 클래스가 다른 클래스를 사용하는 경우  
   클래스의 속성(“멤버 변수”)에서 참조할 때  
   연산의 “인자”(참조값)로 사용될 때  
   메서드 내부의 “지역 객체”로 참조될 때  
   1번: 연관 관계 / 2,3번: 의존 관계  
   ![연관관계와 의존의 차이](https://gmlwjd9405.github.io/images/class-diagram/dependency-uml.png)

4-1연관관계  
오랜 시간 동안 같이할 객체와의 관계  
예를 들어, 자동차(Car)와 소유한 사람(Person)의 관계

```java
public class Person {
  // 클래스의 속성("멤버 변수")에서 참조
  private Car owns;
  // getter, setter
  public void setCar(Car car) {
    this.owns = car;
  }
  public Car getCar() {
    return this.owns;
  }
}

```

4-2의존 관계  
짧은 시간 동안 이용하는 관계  
UML에서는 점선으로 나타낸다.  
예를 들어, 자동차(Car)와 주유기(GasPump)의 관계

5. 인터페이스와 실체화 관계
   인터페이스란  
   책임이다.  
   어떤 객체의 책임이란 객체가 해야 하는 일 또는 객체가 할 수 있는 일  
   즉, 객체가 외부에 제공하는 서비스나 기능은 객체가 수행하는 책임으로 본다.  
   어떤 공통되는 능력이 있는 것들을 대표하는 관점

UML에서의 인터페이스 표현  
인터페이스: 클래스에 사용하는 사각형을 그대로 사용하고 인터페이스 이름 위에 스테레오 타입으로 interface 표시(«interface»)  
인터페이스 관계: 빈 삼각형과 점선을 사용  
![인터페이스](https://gmlwjd9405.github.io/images/class-diagram/interface-uml.png)

Reference
https://gmlwjd9405.github.io/2018/07/04/class-diagram.html

<br></br>

## 유스케이스 다이어그램

![전체](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FDERHk%2FbtqFrnnJ4Qy%2FKEejnkurs5gZP3LQ50otp1%2Fimg.png)

시스템과 사용자의 상호작용을 다이어그램으로 표현한 것으로, 사용자의 관점에서 시스템의 서비스, 기능, 외부와의 관계에 대해서 다이어그램으로 표현한 것을 말한다.

사용자(액터)가 시스템 내부에 있는 기능 중에 어떤 기능을 사용할 수 있는지를 나타내는 것으로 사용자와 시스템 사이의 관계를 간략하게 표현할 수 있는 장점이 있다.

1. 유스케이스 구성요소(Component)
   유스케이스 다이어그램의 구성요소로 시스템, 액터, 유스케이스, 관계로 구성되어 있다.

2. 시스템(System Scope)
   ![시스템](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbwR2r6%2FbtqFrB68MS8%2FbkOYN0bHsWCLjqU95hReG0%2Fimg.png)

현재 개발할 프로그램을 나타낸다.

프라이머리 액터와 세컨더리 액터 사이의 사각형으로 표기한다.

3. 액터(actor)
   ![액터](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbCoY6l%2FbtqFrDKEgZh%2FkSqex3sSxxbtvhpe40yIYK%2Fimg.png)

1) 프라이머리 엑터

시스템을 사용하는 주체가 되는 액터이며 졸라맨과 같은 사람 형태의 모형으로 표기한다. 시스템의 왼쪽에 그리며 액터의 역할을 작성해준다.

2. 세컨더리 엑터

프라이머리 엑터로부터 시작되어 시스템과 상호작용하는 다른 시스템(외부 시스템)을 말하며 박스에 <.<.actor>>(..생략)를 포함하여 표기한다. 시스템의 오른쪽에 그려준다.

4. 유스케이스(Usecase)
   ![유스케이스](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FpasSz%2FbtqFo4Xqis7%2FhkwUijfukHIBt6UgkBUWWk%2Fimg.png)

사용자의 입장에서 바라본 시스템의 추상적인 기능으로 시스템의 요구사항을 나타내며 타원형으로 표기한다.

5. 관계(Relation)
   액터와 유스케이스, 유스케이스 사이의 유스케이스의 관계를 나타낸다.

관계는 연관(Assosiation), 의존(Dependency), 일반화(Generalization)이 있으며, 의존 관계는 포함(Include)와 확장(Extend)로 나눠진다.

1. 연관관계  
   액터와 유스케이스 간의 상호작용이 있음을 실선으로 표현한다
   ![연관관계](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FTovgx%2FbtqFqM9mHdD%2FAboVbzGjEqJ4meKpEU6Cwk%2Fimg.png)

2. 포함관계
   ![포함관계](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FboQHqs%2FbtqFpAhu6Ze%2FZ0KP6M9fQkJDPp9JsMDUCK%2Fimg.png)

하나의 유스케이스가 다른 유스케이스가 실행되었다는 것에 대한 전제가 되었을 때의 관계이다.

위의 유스케이스 다이어그램을 예로 들자면, 상품 주문 유스케이스는 사용자 인증 유스케이스가 반드시 실행 되어야만 상품 주문을 할 수 있게 되기 때문이다.

포함하는 유스케이스에서 포함 되는 유스케이스 방향으로 화살표를 점선으로 연결하고 <.<.include>>(..생략)라고 표기한다.

3. 확장관계
   ![확장관계](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FO15LV%2FbtqFoBOXSlh%2FSkxYusgerTeZoPNbFiVzrK%2Fimg.png)

확장기능 유스케이스와 확장대상 유스케이스 사이에 형성되는 관계로, 해당 유스케이스에 부가적인 유스케이스를 실행할 수 있을 때의 관계이다. 상품목록조회 유스케이스에서 부가적으로 상품상세조회 기능을 추가할 수 있기 때문에 확장 관계로 표기한다.

확장하는 유스케이스에서 대상 유스케이스 방향을 점선으로 연결하고 <.<.extend>>(..생략)라고 표기한다.

4. 일반화 관계
   ![일반화 관계](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Flvw5W%2FbtqFraa8JEF%2FwarWlJoEqFkm38peEkvGZk%2Fimg.png)

추상화한 유스케이스 또는 액터를 그룹화시켜 이해도를 높이기 위해 표현하는 관계이다.

구체적인 유스케이스에서 추상적인 유스케이스로 화살표를 그리고 실선으로 표기한다. 카테고리 관리가 추상적인 유스케이스가 되고 카테고리 등록, 수정, 삭제가 구체적인 유스케이스가 되는 관계이다.

6. 유스케이스 다이어그램 작성 시

1) 유스케이스 식별

액터가 원하는 시스템 제공 기능은 무엇인지, 시스템에 어떤 정보를 생성, 수정, 조회, 삭제하고 싶어 하는지, 모든 기능 요구사항들을 만족할 수 있도록 유스케이스가 모두 식별 되었는지를 확인하여 유스케이스를 정의한다.

2. 관계 정의

- 연관 관계: 액터와 유스케이스 간에 상호 작용이 존재하는지

- 포함 관계: 유스케이스를 실행하기 위하여 반드시 실행되어야 하는 유스케이스가 존재하는지

- 확장 관계: 유스케이스를 실행함으로써 선택적으로 실행되는 유스케이스가 존재하는지

- 일반화 관계: 액터 또는 유스케이스가 구체화 된 다른 액터 또는 유스케이스를 가지고 있는지

위 관계에 해당하는 상호 작용 관계를 확인하고 관계를 정의한다.

<br></br>

## 요구사항

정의

- 문제의 해결 또는 목적 달성을 위하여 고객에 의해 요구되거나, 표준이나 명세 등을 만
  족하기 위하여 시스템이 가져야 하는 서비스 또는 제약사항
- 고객이 요구한 사항과 요구하지 않았더라도 당연히 제공되어야 한다고 가정되는 사항
  들

요구사항의 중요성

- 참여자들로 하여금 개발되는 소프트웨어 제품을 전체적으로 파악하도록 하여 의사 소
  통 시간을 절약하게 해 주는 것
- 상세한 요구이 있어야만 산정이 가능하고, 이를 기반으로 계획을 세울 수 있기 때
  문

기능적 요구사항(Functional Requirements)

- 수행될 기능과 관련되어 입력과 출력 및 그들 사이의 처리과정
- 목표로 하는 제품의 구현을 위해 소프트웨어가 가져야 하는 기능적 속성
  • 예) 워드 프로세서에서 파일 저장 기능, 편집 기능, 보기 기능 등

비기능적 요구사항(Non-Functional Requirements)

- 제품의 품질 기준 등을 만족시키기 위해 소프트웨어가 가져야 하는 성능, 사용의 용이
  성, 안전성과 같은 행위적 특성
- 시스템의 기능에 관련되지 않는 사항을 나타냄
