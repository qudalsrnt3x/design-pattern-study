## Ch1. 디자인패턴 소개와 전략 패턴

### 소프트웨어 개발 불변의 진리
``변화``

### 변화하는 코드에서 상속 사용의 문제점

- 서브클래스마다 행동이 바뀔 수 있다.
- 구현체를 직접 클래스에 구현하기 때문에 변화에 유연하지 못한다.
- 한 가지 행동을 바꿀 때마다 그 행동이 정의되어 있는 서로 다른 서브클래스를 전부 찾아서 코드를 일일이 고쳐야 한다.
- 특정 구현제에 의존하게 되면 코드 변경이 어렵다.

> 디자인 원칙 <br>
> 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분과 분리한다. <br>
> 달라지는 부분을 '캡슐화' 한다.

바뀌는 부분을 따로 뽑아서 캡슐화 한다. 그러면 나중에 바뀌지 않는 부분에는 영향을 미치지 않고 그 부분만 고치거나 확장할 수 있다. <br>

- 재사용, 확장에 유리

<br>

> 디자인 원칙 <br>
> 구현보다는 인터페이스에 맞춰서 프로그래밍한다.

기존 서브클래스에서 행동을 직접 구현하거나 구체적으로 구현하는 것이 아니라, 
특정 행동을 구현한 클래스의 인터페이스를 참조하게되면 변화에 유리하게 된다.

- 실제 실행 시에 쓰이는 객체가 코드에 고정되지 않도록 상위 형식에 맞춰서 프로그래밍을 한다.

<br>

> 디자인 원칙
> 상속보다는 구성(콤포지션)을 활용한다.

- "A는 B다." 보다 "A에는 B가 있다." 관계를 생각하자.

### 전략 패턴

알고리즘군을 정의하고 캡슐화해서 각각의 알고리즘군을 수정해서 쓸 수 있게 해 줍니다. 전략 패턴을 사용하면 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경할 수 있습니다.


### 디자인 패턴 사용하는 이유

- 유연한 애플리케이션을 만드는 데 도움이 된다.
- 객체지향의 기초를 토대로 좋은 객체지향 디자인을 할 수 있다.

