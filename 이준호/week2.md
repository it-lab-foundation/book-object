# 챕터 02. 객체지향 프로그래밍

# 목차

- 영화 예매 시스템
    - 요구사항 살펴보기
- 객체지향 프로그래밍을 향해
    - 협력, 객체, 클래스
    - 도메인의 구조를 따르는 프로그램 구조
    - 클래스 구현하기
    - 협력하는 객체들의 공동체
    - 협력에 관한 짧은 이야기
- 할인 요금 구하기
    - 할인 요금 계산을 위한 협력 시작하기
    - 할인 정책과 할인 조건
    - 할인 정책 구성하기
- 상속과 다형성
    - 컴파일 시간 의존성과 실행 시간 의존성
    - 차이에 의한 프로그래밍
    - **상속과 인터페이스**
    - 다형성
    - 인터페이스와 다형성
- 추상화와 유연성
    - 추상화의 힘
    - 유연한 설계
    - 추상 클래스와 인터페이스 트레이트오프
    - 코드 재사용
    - 상속
    - 합성

# 밑줄 친 문장

> 첫째, 어떤 클래스가 필요한지를 고민하기 전에 `어떤 객체들이 필요한지 고민`하라. 클래스는 공통적인 상태와 행동을 공유하는 객체들을 추상화한 것이다. 따라서 **클래스의 윤곽을 잡기 위해서는 어떤 객체 들이 어떤 상태와 행동을 가지는지를 먼저 결정해야 한다**. 객체를 중심에 두는 접근 방법은 설계를 단순하고 깔끔하게 만든다.
> 

> 둘째, 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 `협력하는 공동체의 일원으로 봐야 한다`. 
객체는 홀로 존재하는 것이 아니다. 다른 객체에게 도움을 주거나 의존하면서 살아가는 협력적인 존재 다. **객체를 협력하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다**. 객체 지향적으로 생각하고 싶다면 객체를 고립된 존재로 바라보지 말고 협력에 참여하는 협력자로 바라보기 바란다. 객체들의 모양과 윤곽이 잡히면 공통된 특성과 상태를 가진 객체들을 타입으로 분류하고 이 타입을 기반으로 클래스를 구현하라. 훌륭한 협력이 훌륭한 객체를 낳고 훌륭한 객체가 훌륭한 클래스를 낳는다.
> 

> 인터페이스는 객체가 이해할 수 있는 메시지의 목록을 정의한다는 것을 기억하라. 상속을 통해 자식 클래스는 자신의 인터페이스에 부모 클래스의 인터페이스를 포함하게 된다. 결과적으로 자식 클래스는 부모 클래스가 수신할 수 있는 모든 메시지를 수신할 수 있기 때문에 외부 객체는 자식 클래스를 부모 클래스와 동일한 타입으로 간주할 수 있다.
> 

> 한 가지 간과해서는 안 되는 사실은 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드를 이해하기 어려워진다는 것이다. 코드를 이해하기 위해서는 코드뿐만 아니라 객체를 생성하고 연결하는 부분을 찾아야 하기 때문이다. 반면 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드는 더유연해지고 확장 가능해진다. 이와 같은 `의존성의 양면성은 설계가 트레이드오프의 산물이라는 사실`을 잘 보여준다.
> 

# 객체 설계 방법 (협력, 객체, 클라스)

1. 첫째, 클래스부터 설계하는 실수를 하지 말라. **어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라**. 클래스는 공통적인 상태와 행동을 공유하는 객체들을 추상화한 것이다. 따라서 클래스의 윤곽을 잡기 위해서는 어떤 객체들이 어떤 상태와 행동을 가지는지를 먼저 결정해야 한다. 객체를 중심에 두는 접근 방법은 설계를 단순하고 깔끔하게 만든다. 
2. 둘째, **객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다**. 객체는 홀로 존재하는 것이 아니다. 다른 객체에게 도움을 주거나 의존하면서 살아가는 협력적인 존재다. 객체를 협력하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다. 

## 자율적인 객체

1. 첫 번째 사실은 객체가 상태(state)와 행동(behavior)을 함께 가지는 복합적인 존재라는 것이다. 두 번째 사실은 객체가 스스로 판단하고 행동하는 자율적인 존재 라는 것이다. 두 가지 사실은 서로 깊이 연관돼 있다.
많은 사람들은 객체를 상태와 행동을 함께 포함하는 식별 가능한 단위로 정의한다. 객체지향 이전의 패러다임에서는 데이터와 기능이라는 독립적인 존재를 서로 엮어 프로그램을 구성했다. 이와 달리 객체 지향은 객체라는 단위 안에 데이터와 기능을 한 덩어리로 묶음으로써 문제 영역의 아이디어를 적절하게 표현할 수 있게 했다. 이처럼 데이터와 기능을 객체 내부로 함께 묶는 것을 **캡슐화**라고 부른다. 
2. 대부분의 객체지향 프로그래밍 언어들은 상태와 행동을 캡슐화하는 것에서 한 걸음 더 나아가 외부에 서의 접근을 통제할 수 있는 접근 제어(access control) 메커니즘도 함께 제공한다. 많은 프로그래밍 언어들은 접근 제어를 위해 public , protected , private 과 같은 접근 수정자(access modifier)를 제공 한다.
3. 객체 내부에 대한 접근을 통제하는 이유는 객체를 자율적인 존재로 만들기 위해서다. **객체지향의 핵심은 스스로 상태를 관리하고, 판단하고, 행동하는 자율적인 객체들의 공동체를 구성하는 것이다**. 객체가 자율적인 존재로 우뚝 서기 위해서는 외부의 간섭을 최소화해야 한다. 외부에서는 객체가 어떤 상태에 놓여 있는지, 어떤 생각을 하고 있는지 알아서는 안 되며, 결정에 직접적으로 개입하려고 해서도 안 된다. 객체에게 원하는 것을 요청하고는 객체가 스스로 최선의 방법을 결정할 수 있을 것이라는 점을 믿고 기다려야 한다.
4. **캡슐화와 접근 제어는 객체를 두 부분으로 나눈다**. 하나는 외부에서 접근 가능한 부분으로 이를 `퍼블릭 인터페이스(public interface)`라고 부른다. 다른 하나는 외부에서는 접근 불가능하고 오직 내부에서만 접근 가능한 부분으로 이를 `구현(implementation)`이라고 부른다. 뒤에서 살펴보겠지만, 인터페이스와 구현의 분리(separation of interface and implementation) 원칙은 훌륭한 객체지향 프로그램을 만들기 위해 따라야 하는 핵심 원칙이다. 

## 프로그래머의 자유

1. 프로그래머의 역할을 클래스 작성자(class creator)와 클라이언트 프로그래머(client programmer) 로 구분하는 것이 유용하다[Eckel06]. 클래스 작성자는 새로운 데이터 타입을 프로그램에 추가하고, 클라이언트 프로그래머는 클래스 작성자가 추가한 데이터 타입을 사용한다. 
2. 클라이언트 프로그래머의 목표는 필요한 클래스들을 엮어서 애플리케이션을 빠르고 안정적으로 구축 하는 것이다. 클래스 작성자는 클라이언트 프로그래머에게 필요한 부분만 공개하고 나머지는 꽁꽁 숨겨야 한다. 클라이언트 프로그래머가 숨겨 놓은 부분에 마음대로 접근할 수 없도록 방지함으로써 클라 이언트 프로그래머에 대한 영향을 걱정하지 않고도 내부 구현을 마음대로 변경할 수 있다. 이를 구현 은닉(implementation hiding)이라고 부른다. 
3. 구현 은닉은 클래스 작성자와 클라이언트 프로그래머 모두에게 유용한 개념이다. 클라이언트 프로그래 머는 내부의 구현은 무시한 채 인터페이스만 알고 있어도 클래스를 사용할 수 있기 때문에 머릿속에 담아둬야 하는 지식의 양을 줄일 수 있다. 클래스 작성자는 인터페이스를 바꾸지 않는 한 외부에 미치는 영향을 걱정하지 않고도 내부 구현을 마음로 변경할 수 있다. 다시 말해 public 영역을 변경하지 않는 다면 코드를 자유롭게 수정할 수 있다는 것이다. 
4. 설계가 필요한 이유는 **변경을 관리하기 위해서**라는 것을 기억하라. 객체지향 언어는 객체 사이의 의존 성을 적절히 관리함으로써 변경에 대한 파급효과를 제어할 수 있는 다양한 방법을 제공한다. **객체의 변경을 관리할 수 있는 기법 중에서 가장 대표적인 것이 바로 접근 제어다**. 여러분은 **변경될 가능성이 있는 세부적인 구현 내용을 private 영역 안에 감춤으로써 변경으로 인한 혼란을 최소화할 수 있다**. 
5. 영화를 예매하기 위해 Screening, Movie, Reservation 인스턴스들은 서로의 메서드를 호출하며 상호 작용한다. 이처럼 **시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용을 협력(Collaboration)이라고 부른다**. 그림 2.5는 Screening , Movie , Reservation 인스턴스 사이의 협력을 그림으로 표현한 것이다. 

# 상속과 인터페이스

- 상속이 가치 있는 이유는 부모 클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있기 때문이다. 이것은 상속을 바라보는 일반적인 인식과는 거리가 있는데 대부분의 사람들은 상속의 목적이 메서드나 인스턴스 변수를 재사용하는 것이라고 생각하기 때문이다.
- 인터페이스는 객체가 이해할 수 있는 메시지의 목록이다.

# 영화 예매 시스템

## 요구사항 분석

- 할인 조건 (순서 조건 : 상영 순번으로 진행, 기간 조건 : 영화 상영 시작 시간을 이용해 할인 여부를 결정),할인 정책 (금액 할인 정책, 비율 할인 정책) 이 있다. **하나의 영화에 대해 단 하나의 할인 정책만 설정할 수 있지만 할인 조건의 경우에는 여러 개를 적용할 수 있다**.

## v1


```java
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
```

```java
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
```

```java
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
```

```java
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

		... 

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
```

## v2

- 협력하는 객체들의 공동체
    
    
    ```java
    public class NoneDiscountPolicy implements DiscountPolicy {
        @Override
        public Money calculateDiscountAmount(Screening screening) {
            return Money.ZERO;
        }
    }
    ```
    
    ```java
    public interface DiscountPolicy {
        Money calculateDiscountAmount(Screening screening);
    }
    ```
    

# 합성

- 합성을 사용하라
    - Movie 는 요금을 계산하기 위해 DiscountPolicy 의 코드를 재사용한다. 이 방법이 상속과 다른 점은 상속이 부모 클래스의 코드와 자식 클래스의 코드를 컴파일 시점에 하나의 단위로 강하게 결합하는 데 비해
    Movie 가 DiscountPolicy 의 인터페이스를 통해 약하게 결합된다는 것이다. 실제로 Movie 는 DiscountPolicy가 외부에 calculateDiscountAmount 메서드를 제공한다는 사실만 알고 내부 구현에 대해서는 전혀 알지 못한다. 이처럼 인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법을 **합성**이라고 부른다.
    - 합성은 상속이 가지는 두 가지 문제점을 모두 해결한다. 인터페이스에 정의된 메시지를 통해서만 재사 용이 가능하기 때문에 구현을 효과적으로 캡슐화할 수 있다. 또한 의존하는 인스턴스를 교체하는 것이 비교적 쉽기 때문에 설계를 유연하게 만든다. 상속은 클래스를 통해 강하게 결합되는 데 비해 합성은 메시지를 통해 느슨하게 결합된다. 따라서 코드 재사용을 위해서는 상속보다는 합성을 선호하는 것이더 좋은 방법이다[GOF94].

# 결론

객체지향 설계의 핵심은 적절한 협력을 식별하고 협력에 필요한 역할을 정의한 후에 역할을 수행할 수있는 적절한 객체에게 적절한 책임을 할당하는 것이다. 다음 장에서는 클래스나 상속과 같은 프로그래밍 개념을 잠시 미뤄두고 객체의 책임과 협력이라는 주제에 좀 더 초점을 맞추겠다.

# 적용된 디자인패턴

- 템플릿 메서드패턴
    - 부모 클래스 : 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에 위임
    - 자식 클래스 : 중간에 필요한 처리를 자식 클래스에서 처리
        
        ```java
        public abstract class DiscountPolicy {
            private List<DiscountCondition> conditions = new ArrayList<>();
        
            public DiscountPolicy(DiscountCondition ... conditions) {
                this.conditions = Arrays.asList(conditions);
            }
        
            public Money calculateDiscountAmount(Screening screening) {
                for(DiscountCondition each : conditions) {
                    if (each.isSatisfiedBy(screening)) {
                        return getDiscountAmount(screening);
                    }
                }
        
                return Money.ZERO;
            }
        
            abstract protected Money getDiscountAmount(Screening Screening);
        }
        ```
        
        ```java
        public class PercentDiscountPolicy extends DiscountPolicy {
            private double percent;
        
            public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
                super(conditions);
                this.percent = percent;
            }
        
            @Override
            protected Money getDiscountAmount(Screening screening) {
                return screening.getMovieFee().times(percent);
            }
        }
        ```
        
    

# 테스트코드

# 챕터 02. 객체지향 프로그래밍

# 목차

- 영화 예매 시스템
    - 요구사항 살펴보기
- 객체지향 프로그래밍을 향해
    - 협력, 객체, 클래스
    - 도메인의 구조를 따르는 프로그램 구조
    - 클래스 구현하기
    - 협력하는 객체들의 공동체
    - 협력에 관한 짧은 이야기
- 할인 요금 구하기
    - 할인 요금 계산을 위한 협력 시작하기
    - 할인 정책과 할인 조건
    - 할인 정책 구성하기
- 상속과 다형성
    - 컴파일 시간 의존성과 실행 시간 의존성
    - 차이에 의한 프로그래밍
    - **상속과 인터페이스**
    - 다형성
    - 인터페이스와 다형성
- 추상화와 유연성
    - 추상화의 힘
    - 유연한 설계
    - 추상 클래스와 인터페이스 트레이트오프
    - 코드 재사용
    - 상속
    - 합성

# 밑줄 친 문장

> 첫째, 어떤 클래스가 필요한지를 고민하기 전에 `어떤 객체들이 필요한지 고민`하라. 클래스는 공통적인 상태와 행동을 공유하는 객체들을 추상화한 것이다. 따라서 **클래스의 윤곽을 잡기 위해서는 어떤 객체 들이 어떤 상태와 행동을 가지는지를 먼저 결정해야 한다**. 객체를 중심에 두는 접근 방법은 설계를 단순하고 깔끔하게 만든다.
> 

> 둘째, 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 `협력하는 공동체의 일원으로 봐야 한다`. 
객체는 홀로 존재하는 것이 아니다. 다른 객체에게 도움을 주거나 의존하면서 살아가는 협력적인 존재 다. **객체를 협력하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다**. 객체 지향적으로 생각하고 싶다면 객체를 고립된 존재로 바라보지 말고 협력에 참여하는 협력자로 바라보기 바란다. 객체들의 모양과 윤곽이 잡히면 공통된 특성과 상태를 가진 객체들을 타입으로 분류하고 이 타입을 기반으로 클래스를 구현하라. 훌륭한 협력이 훌륭한 객체를 낳고 훌륭한 객체가 훌륭한 클래스를 낳는다.
> 

> 인터페이스는 객체가 이해할 수 있는 메시지의 목록을 정의한다는 것을 기억하라. 상속을 통해 자식 클래스는 자신의 인터페이스에 부모 클래스의 인터페이스를 포함하게 된다. 결과적으로 자식 클래스는 부모 클래스가 수신할 수 있는 모든 메시지를 수신할 수 있기 때문에 외부 객체는 자식 클래스를 부모 클래스와 동일한 타입으로 간주할 수 있다.
> 

> 한 가지 간과해서는 안 되는 사실은 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드를 이해하기 어려워진다는 것이다. 코드를 이해하기 위해서는 코드뿐만 아니라 객체를 생성하고 연결하는 부분을 찾아야 하기 때문이다. 반면 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드는 더유연해지고 확장 가능해진다. 이와 같은 `의존성의 양면성은 설계가 트레이드오프의 산물이라는 사실`을 잘 보여준다.
> 

# 객체 설계 방법 (협력, 객체, 클라스)

1. 첫째, 클래스부터 설계하는 실수를 하지 말라. **어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라**. 클래스는 공통적인 상태와 행동을 공유하는 객체들을 추상화한 것이다. 따라서 클래스의 윤곽을 잡기 위해서는 어떤 객체들이 어떤 상태와 행동을 가지는지를 먼저 결정해야 한다. 객체를 중심에 두는 접근 방법은 설계를 단순하고 깔끔하게 만든다. 
2. 둘째, **객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다**. 객체는 홀로 존재하는 것이 아니다. 다른 객체에게 도움을 주거나 의존하면서 살아가는 협력적인 존재다. 객체를 협력하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다. 

## 자율적인 객체

1. 첫 번째 사실은 객체가 상태(state)와 행동(behavior)을 함께 가지는 복합적인 존재라는 것이다. 두 번째 사실은 객체가 스스로 판단하고 행동하는 자율적인 존재 라는 것이다. 두 가지 사실은 서로 깊이 연관돼 있다.
많은 사람들은 객체를 상태와 행동을 함께 포함하는 식별 가능한 단위로 정의한다. 객체지향 이전의 패러다임에서는 데이터와 기능이라는 독립적인 존재를 서로 엮어 프로그램을 구성했다. 이와 달리 객체 지향은 객체라는 단위 안에 데이터와 기능을 한 덩어리로 묶음으로써 문제 영역의 아이디어를 적절하게 표현할 수 있게 했다. 이처럼 데이터와 기능을 객체 내부로 함께 묶는 것을 **캡슐화**라고 부른다. 
2. 대부분의 객체지향 프로그래밍 언어들은 상태와 행동을 캡슐화하는 것에서 한 걸음 더 나아가 외부에 서의 접근을 통제할 수 있는 접근 제어(access control) 메커니즘도 함께 제공한다. 많은 프로그래밍 언어들은 접근 제어를 위해 public , protected , private 과 같은 접근 수정자(access modifier)를 제공 한다.
3. 객체 내부에 대한 접근을 통제하는 이유는 객체를 자율적인 존재로 만들기 위해서다. **객체지향의 핵심은 스스로 상태를 관리하고, 판단하고, 행동하는 자율적인 객체들의 공동체를 구성하는 것이다**. 객체가 자율적인 존재로 우뚝 서기 위해서는 외부의 간섭을 최소화해야 한다. 외부에서는 객체가 어떤 상태에 놓여 있는지, 어떤 생각을 하고 있는지 알아서는 안 되며, 결정에 직접적으로 개입하려고 해서도 안 된다. 객체에게 원하는 것을 요청하고는 객체가 스스로 최선의 방법을 결정할 수 있을 것이라는 점을 믿고 기다려야 한다.
4. **캡슐화와 접근 제어는 객체를 두 부분으로 나눈다**. 하나는 외부에서 접근 가능한 부분으로 이를 `퍼블릭 인터페이스(public interface)`라고 부른다. 다른 하나는 외부에서는 접근 불가능하고 오직 내부에서만 접근 가능한 부분으로 이를 `구현(implementation)`이라고 부른다. 뒤에서 살펴보겠지만, 인터페이스와 구현의 분리(separation of interface and implementation) 원칙은 훌륭한 객체지향 프로그램을 만들기 위해 따라야 하는 핵심 원칙이다. 

## 프로그래머의 자유

1. 프로그래머의 역할을 클래스 작성자(class creator)와 클라이언트 프로그래머(client programmer) 로 구분하는 것이 유용하다[Eckel06]. 클래스 작성자는 새로운 데이터 타입을 프로그램에 추가하고, 클라이언트 프로그래머는 클래스 작성자가 추가한 데이터 타입을 사용한다. 
2. 클라이언트 프로그래머의 목표는 필요한 클래스들을 엮어서 애플리케이션을 빠르고 안정적으로 구축 하는 것이다. 클래스 작성자는 클라이언트 프로그래머에게 필요한 부분만 공개하고 나머지는 꽁꽁 숨겨야 한다. 클라이언트 프로그래머가 숨겨 놓은 부분에 마음대로 접근할 수 없도록 방지함으로써 클라 이언트 프로그래머에 대한 영향을 걱정하지 않고도 내부 구현을 마음대로 변경할 수 있다. 이를 구현 은닉(implementation hiding)이라고 부른다. 
3. 구현 은닉은 클래스 작성자와 클라이언트 프로그래머 모두에게 유용한 개념이다. 클라이언트 프로그래 머는 내부의 구현은 무시한 채 인터페이스만 알고 있어도 클래스를 사용할 수 있기 때문에 머릿속에 담아둬야 하는 지식의 양을 줄일 수 있다. 클래스 작성자는 인터페이스를 바꾸지 않는 한 외부에 미치는 영향을 걱정하지 않고도 내부 구현을 마음로 변경할 수 있다. 다시 말해 public 영역을 변경하지 않는 다면 코드를 자유롭게 수정할 수 있다는 것이다. 
4. 설계가 필요한 이유는 **변경을 관리하기 위해서**라는 것을 기억하라. 객체지향 언어는 객체 사이의 의존 성을 적절히 관리함으로써 변경에 대한 파급효과를 제어할 수 있는 다양한 방법을 제공한다. **객체의 변경을 관리할 수 있는 기법 중에서 가장 대표적인 것이 바로 접근 제어다**. 여러분은 **변경될 가능성이 있는 세부적인 구현 내용을 private 영역 안에 감춤으로써 변경으로 인한 혼란을 최소화할 수 있다**. 
5. 영화를 예매하기 위해 Screening, Movie, Reservation 인스턴스들은 서로의 메서드를 호출하며 상호 작용한다. 이처럼 **시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용을 협력(Collaboration)이라고 부른다**. 그림 2.5는 Screening , Movie , Reservation 인스턴스 사이의 협력을 그림으로 표현한 것이다. 

# 상속과 인터페이스

- 상속이 가치 있는 이유는 부모 클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있기 때문이다. 이것은 상속을 바라보는 일반적인 인식과는 거리가 있는데 대부분의 사람들은 상속의 목적이 메서드나 인스턴스 변수를 재사용하는 것이라고 생각하기 때문이다.
- 인터페이스는 객체가 이해할 수 있는 메시지의 목록이다.

# 영화 예매 시스템

## 요구사항 분석

- 할인 조건 (순서 조건 : 상영 순번으로 진행, 기간 조건 : 영화 상영 시작 시간을 이용해 할인 여부를 결정),할인 정책 (금액 할인 정책, 비율 할인 정책) 이 있다. **하나의 영화에 대해 단 하나의 할인 정책만 설정할 수 있지만 할인 조건의 경우에는 여러 개를 적용할 수 있다**.

## v1

```java
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
```

```java
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
```

```java
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
```

```java
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

		... 

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
```

## v2

- 협력하는 객체들의 공동체
    
    ```java
    public class NoneDiscountPolicy implements DiscountPolicy {
        @Override
        public Money calculateDiscountAmount(Screening screening) {
            return Money.ZERO;
        }
    }
    ```
    
    ```java
    public interface DiscountPolicy {
        Money calculateDiscountAmount(Screening screening);
    }
    ```
    

# 합성

- 합성을 사용하라
    - Movie 는 요금을 계산하기 위해 DiscountPolicy 의 코드를 재사용한다. 이 방법이 상속과 다른 점은 상속이 부모 클래스의 코드와 자식 클래스의 코드를 컴파일 시점에 하나의 단위로 강하게 결합하는 데 비해
    Movie 가 DiscountPolicy 의 인터페이스를 통해 약하게 결합된다는 것이다. 실제로 Movie 는 DiscountPolicy가 외부에 calculateDiscountAmount 메서드를 제공한다는 사실만 알고 내부 구현에 대해서는 전혀 알지 못한다. 이처럼 인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법을 **합성**이라고 부른다.
    - 합성은 상속이 가지는 두 가지 문제점을 모두 해결한다. 인터페이스에 정의된 메시지를 통해서만 재사 용이 가능하기 때문에 구현을 효과적으로 캡슐화할 수 있다. 또한 의존하는 인스턴스를 교체하는 것이 비교적 쉽기 때문에 설계를 유연하게 만든다. 상속은 클래스를 통해 강하게 결합되는 데 비해 합성은 메시지를 통해 느슨하게 결합된다. 따라서 코드 재사용을 위해서는 상속보다는 합성을 선호하는 것이더 좋은 방법이다[GOF94].

# 결론

객체지향 설계의 핵심은 적절한 협력을 식별하고 협력에 필요한 역할을 정의한 후에 역할을 수행할 수있는 적절한 객체에게 적절한 책임을 할당하는 것이다. 다음 장에서는 클래스나 상속과 같은 프로그래밍 개념을 잠시 미뤄두고 객체의 책임과 협력이라는 주제에 좀 더 초점을 맞추겠다.

# 적용된 디자인패턴

- 템플릿 메서드패턴
    - 부모 클래스 : 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에 위임
    - 자식 클래스 : 중간에 필요한 처리를 자식 클래스에서 처리
        
        ```java
        public abstract class DiscountPolicy {
            private List<DiscountCondition> conditions = new ArrayList<>();
        
            public DiscountPolicy(DiscountCondition ... conditions) {
                this.conditions = Arrays.asList(conditions);
            }
        
            public Money calculateDiscountAmount(Screening screening) {
                for(DiscountCondition each : conditions) {
                    if (each.isSatisfiedBy(screening)) {
                        return getDiscountAmount(screening);
                    }
                }
        
                return Money.ZERO;
            }
        
            abstract protected Money getDiscountAmount(Screening Screening);
        }
        ```
        
        ```java
        public class PercentDiscountPolicy extends DiscountPolicy {
            private double percent;
        
            public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
                super(conditions);
                this.percent = percent;
            }
        
            @Override
            protected Money getDiscountAmount(Screening screening) {
                return screening.getMovieFee().times(percent);
            }
        }
        ```

# 테스트코드

- 총 11개의 테스트케이스
    - Movie 클래스
        - changeDiscountPolicy 메소드는
            - 주어진 영화가 '스타워즈'일때 (할인 조건 없음)
            - '타이타닉'의 할인정책이 주어지면
                - 주어진 할인 정책으로 할인정책을 교체하고 void를 리턴한다
            - '아바타'의 할인정책이 주어지면
                - 주어진 할인 정책으로 할인정책을 교체하고 void를 리턴한다
        - calculateMovieFee 메소드는
            - 주어진 영화가 '스타워즈'일때 (할인 조건 없음)
            - 주어진 영화가 '타이타닉'일때 (할인 조건: 상영 시작 시간, 상영 순번 / 할인 금액: 퍼센트)
                - 상영 순번이 할인 조건에 맞지 않는다면
                - 상영 순번이 할인 조건에 맞는다면
                - 상영 시작 시간이 할인 조건에 맞지 않는다면
                    - 할인되지 않은 금액을 리턴한다
                - 상영 시작 시간이 할인 조건에 맞는다면
            - 주어진 영화가 '아바타'일때 (할인 조건: 상영 시작 시간, 상영 순번 / 할인 금액: 고정 금액)
                - 상영 순번이 할인 조건에 맞지 않는다면
                - 상영 순번이 할인 조건에 맞는다면
                - 상영 시작 시간이 할인 조건에 맞지 않는다면
                    - 할인되지 않은 금액을 리턴한다
                - 상영 시작 시간이 할인 조건에 맞는다면
                    - 고정할인 금액만큼 할인된 금액을 리턴한다

[https://github.com/joonfluence/java-object-study/tree/chapter2](https://github.com/joonfluence/java-object-study/tree/chapter2)