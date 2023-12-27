# 챕터 01. 객체, 설계

## 밑줄 친 문장

> “이 책은 훌륭한 객체지향 프로그램을 설계하고 유지보수하는 데 필요한 원칙과 기법을 설명하기 위해 쓰여진 책이다. 일반적으로 이런 종류의 책들은 객체지향의 역사를 장황하게 설명하거나 기억하기조차 버거운 용어와 난해한 개념들을 줄줄이 나열하는 것으로 시작하곤 한다. 하지만 글래스의 이야기에서 알 수 있는 것처럼 설계나 유지보수를 이야기할 때 이론을 중심에 두는 것은 적절하지 않다. 설계 분야에서 실무는 이론을 압도한다. 설계에 관해 설명할 때 `가장 유용한 도구는 이론으로 덕지덕지 치장된 개념과 용어가 아니라 ‘코드’ 그 자체다`.”

> “모든 소프트웨어 모듈에는 세 가지 목적이 있다. 첫 번째 목적은 실행 중에 제대로 동작하는 것이다. 이것은 모듈의 존재 이유라고 할 수 있다. 두 번째 목적은 변경을 위해 존재하는 것이다. 대부분의 모듈은 생명주기 동안 변경되기 때문에 간단한 작업만으로도 변경이 가능해야 한다. 변경하기 어려운 모듈은 제대로 동작하더라도 개선해야 한다. 모듈의 세 번째 목적은 코드를 읽는 사람과 의사소통하는 것이다. 모듈은 특별한 훈련 없이도 개발자가 쉽게 읽고 이해할 수 있어야 한다. 읽는 사람과 의사소통할 수 없는 모듈은 개선해야 한다[Martin02].”

> “우리는 관람객과 판매원이 자신의 일을 스스로 처리할 것이라고 예상한다. 하지만 절차적 프로그래밍의 세계에서는 관람 객과 판매원이 수동적인 존재일 뿐이다. 타인이 자신의 가방을 마음대로 헤집어 놓아도 아무런 불만을 가지지 않는 소극적인 존재다. 절차적 프로그래밍의 세상은 우리의 예상을 너무나도 쉽게 벗어나기 때문에 코드를 읽는 사람과 원활하게 의사소통하지 못한다.”

> 더 큰 문제는 절차적 프로그래밍의 세상에서는 데이터의 변경으로 인한 영향을 지역적으로 고립시키기 어렵다는 것이다. Audience 와 TicketSeller 의 내부 구현을 변경하려면 Theater 의 enter 메서드를 함께 변경해야 한다. 변경은 버그를 부르고 버그에 대한 두려움은 코드를 변경하기 어렵게 만든다. 따라서 절차적 프로그래밍의 세상은 변경하기 어려운 코드를 양산하는 경향이 있다.

> 해결 방법은 자신의 데이터를 스스로 처리하도록 프로세스의 적절한 단계를 Audience 와 TicketSeller 로이동시키는 것이다. 수정한 후의 코드에서는 데이터를 사용하는 프로세스가 데이터를 소유하고 있는
Audience 와 TicketSeller 내부로 옮겨졌다. 이처럼 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식을 객체지향 프로그래밍(Object-Oriented Programming)이라고 부른다.

> “그러나 Theater 는 어떤가? Bag 은? TicketOffice 는? 이들은 실세계에서는 자율적인 존재가 아니다. 소극 장에 관람객이 입장하기 위해서는 누군가가 소극장의 문을 열고 입장을 허가해줘야 한다. 가방에서 돈을 꺼내는 것은 관람객이지 가방이 아니다. 판매원이 매표소에 없는데도 티켓이 저절로 관람객에게 전달되지는 않을 것이다. 그럼에도 우리는 이들을 관람객이나 판매원과 같은 생물처럼 다뤘다. 무생물 역시 스스로 행동하고 자기 자신을 책임지는 자율적인 존재로 취급한 것이다.”

> “비록 현실에서는 수동적인 존재라고 하더라도 일단 객체지향의 세계에 들어오면 모든 것이 능동적이고 자율적인 존재로 바뀐다. 레베카 워프스브록(Rebecca Wirfs-Brock)은 이처럼 능동적이고 자율적인 존재로 소프트웨어 객체를 설계하는 원칙을 가리켜 의인화(anthropomorphism)라고 부른다.”

## 티켓 판매 어플리케이션

### v1

- “객체의 주체성”, Theater에서 ticketSeller를 통해 Audience의 티켓을 획득하는 것, 지갑을 뒤져(?) 티켓을 판매하는 일 등을 수행하였음.

```java
public class Theater { 
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) { 
		this.ticketSeller = ticketSeller;
	}
	public void enter(Audience audience) { 
		if (audience.getBag().hasInvitation()) { 
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);
		} else { 
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().minusAmount(ticket.getFee());
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
			audience.getBag().setTicket(ticket);
		} 
	} 
}
```

- **“문제는 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재라는 점이다.”**
- “**더 큰 문제는 변경에 취약하다는 것이다**. 이 코드는 관람객이 현금과 초대장을 보관하기 위해 항상 가방을 들고 다닌다고 가정한다. 또한 판매원이 매표소에서만 티켓을 판매한다고 가정한다. 관람 객이 가방을 들고 있지 않다면 어떻게 해야 할까? 관람객이 현금이 아니라 신용카드를 이용해서 결제 한다면 어떻게 해야 할까? 판매원이 매표소 밖에서 티켓을 판매해야 한다면 어떻게 해야 할까? 이런 가정이 깨지는 순간 모든 코드가 일시에 흔들리게 된다.”
- “이것은 객체 사이의 의존성(dependency)과 관련된 문제다. `문제는 의존성이 변경과 관련돼 있다는 점이다. 의존성은 변경에 대한 영향을 암시한다`. 의존성이라는 말 속에는 어떤 객체가 변경될 때 그 객체에게 의존하는 다른 객체도 함께 변경될 수 있다는 사실이 내포돼 있다.”

### v2

```java
package object._01_ticket;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        ticketSeller.sellTo(audience);
    }
}
```

- Theater 는 오직 TicketSeller 의 인터페이스(interface)에만 의존한다. TicketSeller 가 내부에
TicketOffice 인스턴스를 포함하고 있다는 사실은 구현(implementation)의 영역에 속한다. 객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하기 위해 따라야 하는 가장 기본적인 설계 원칙이다.


```java
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.minusAmount(ticket.getFee());
            bag.plusAmount(ticket.getFee());
            bag.setTicket(ticket);
            return ticket.getFee();
        }
    }
}
```

- buy, 능동적인 객체로 변경

## 객체지향의 객체..

(해리포터, 마법의 분류 모자)

- 의인화

```java
public class 마법의_분류_모자 {
	public 기숙사 분류하다(호그와트학생 학생){
		if(학생 has "용기"){
			return 그리핀도르 
		}	else if(학생 is "마법사 집안 출신") {
			return 슬레더린 
		} ....
	}
}
```

## 객체 지향 설계

- 중요한 까닭은? 항상 요구사항이 변경되기 때문! 따라서 변경에 유연하게 대응할 수 있는 설계가 필요하다.
- 단순히 데이터와 프로세스를 객체라는 덩어리 안으로 밀어 넣었다고 해서 변경하기 쉬운 설계를 얻을 수 있는 것은 아니다. 객체지향의 세계에서 애플리케이션은 객체들로 구성되며 애플리케이션의 기능은 객체들 간의 상호작용을 통해 구현된다. 그리고 객체들 사이의 상호작용은 객체 사이에 주고 받는 메시지로 표현된다.
- “훌륭한 객체지향 설계란 협력하는 객체 사이의 의존성을 적절하게 관리하는 설계다. 세상에 엮인 것이 많은 사람일수록 변하기 어려운 것처럼 객체가 실행되는 주변 환경에 강하게 결합될수록 변경하기 어려워진다. 객체 간의 의존성은 애플리케이션을 수정하기 어렵게 만드는 주범이다.”

## 테스트코드

[https://github.com/joonfluence/java-object-study/tree/chapter1](https://github.com/joonfluence/java-object-study/tree/chapter1)