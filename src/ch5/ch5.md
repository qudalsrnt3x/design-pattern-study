## Ch5. 싱글턴 패턴

### 싱글턴 패턴

클래스 인스턴스를 하나만 만들고, 그 인스턴스로의 전역 접근을 제공한다.

### 생성방법

- 인스턴스를 오직 한개만 만들어야 한다.
- 만들어진 하나의 인스턴스에 전역으로 접근할 수 있는 방법을 제공해야 한다.

```java
public class Settings {
	
    private static Settings instance;

    private Settings() {}

    public static Settings getInstance() {
        if (instance == null)
            instance = new Settings();

        return instance;
    }
}
```

### 싱글턴 패턴 장점

- 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있다.
- 싱글톤으로 만들어진 클래스의 인스턴스는 전역(static)이기 때문에 데이터를 공유하기 쉽다.
- 공통된 객체를 여러개 생성해서 사용해야 하는 상황에서 성능이 좋아지는 장점이 있다.

### 싱글턴 패턴 단점

- 하나의 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스들 간에 결합도가 높아져서 변경에 불리해져 유지보수 비용이 높아질 수 있다.
- 멀티쓰레드 환경에서 동기화 처리를 하지 않으면 인스턴스가 2개 생성될 수 있는 가능성이 생긴다.

**주의해야할 점** : **싱글톤을 만들 때 동시성(Concurrency)문제**를 고려해서 설계해야 한다.

### 멀티쓰레드 환경에서 안전한가?

```java
public static Settings getInstance() {
    if (instance == null)
        instance = new Settings();

    return instance;
}
```

- 하나의 쓰레드가 if문에 진입한 순간, 다른 쓰레드가 if문에 진입했을 때 결과적으로 두 개의 쓰레드는 각각 인스턴스를 생성하게 될 것이고 두 개의 쓰레드는 서로 다른 인스턴스를 가지게 된다.

<br>

### 해결방법

1. **synchronized** 키워드를 사용해서 메서드를 동기화 시켜준다.

```java
public static synchronized Settings getInstance() {
    if (instance == null)
        instance = new Settings();

    return instance;
}
```

- 동기화를 처리하는 작업 때문에 성능에 불이익이 있을 수 있다.

<br>

2. 성능을 조금 더 신경쓰고 싶다면, 객체를 만드는 비용이 비싸지 않으면 객체를 미리 만들어준다.
    - 이른 초기화(eager initialization) 사용

```java
public class Settings {
	
	private static final Settings INSTANCE = new Settings();

	private Settings() {}

	public static Settings getInstance() {
		return INSTANCE;
	}

}
```

- 미리 만드는 자체가 단점이 될 수 있음

<br>

3. 인스턴스를 필요한 시점에 만들고 싶은데 synchronized 비용이 신경쓰일 때
    - DCL(double checked locking) 사용하기

```java
public class Settings {
	
    private static volatile Settings instance;
    
    private Settings() {}
    
    public static Settings getInstance() {
        if (instance == null) { // 인스턴스가 있는지 확인하고, 없으면 동기화된 블럭으로 들어간다.
            synchronized (Settings.class) {
                if (instance == null)
                        instance = new Settings();
            }
        }

        return instance;
    }
}
```

- getInstance를 불러올 때 매번 동기화가 걸리는 것이 아니다. instance가 있을 경우에는 if문 스킵됨
- 여러 쓰레드가 동시에 if문에 들어온 경우에만 synchronized 사용해서 동기화 처리해주기
- 1.5 이상 부터만 동작..

<br>

4. 권장하는 방법 중 하나
    - static inner 클래스 사용하기

```java
public class Settings {
	private Settings() {}

	private static class SettingsHolder {
            private static final Settings INSTANCE = new Settings();
	}

	public static Settings getInstance() {  
            return SettingsHolder.INSTANCE;
	}
}
```

- 멀티쓰레드 환경에서도 안전
- LAZY하게 로딩도 가능

<br>

### 싱글톤과 전역변수의 차이

- 싱글톤은 객체를 LAZY하게 로딩 가능 하다.

### 싱글톤이 깨지는 상황

1. 리플렉션 사용
2. 직렬화 & 역직렬화 사용하기 (객체를 파일로 저장할 때 직렬화, 다시 불러올 때 역직렬화 사용)

<br>

### 싱글톤 패턴을 안전하고 단순하게 구현하는 방법

- enum 타입으로 만들면 좋다.

```java
public enum Settings {
	INSTANCE;
}
```

- 장점
    - 리플렉션에 안전하다.
    - enum은 기본적으로 직렬화를 구현한다. 동일한 인스턴스로 역직렬화가 된다.
- 단점
    - 로딩하는 순간 미리 인스턴스가 생성된다.
    - 상속을 쓰지 못한다. (오로지 enum만 상속가능)