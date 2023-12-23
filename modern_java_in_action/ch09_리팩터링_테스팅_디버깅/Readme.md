# 가독성과 유연성을 개선하는 리팩터링

람다, 메서드참조, 스트림 등의 기능을 이용해서 더 가독성이 좋고 유연한 코드로 리팩터링 하는 방법

## 코드 가독성 개선

코드 가독성이 좋다는 것은 어떤 코드를 다른 사람도 쉽게 이해할 수 있음 을 의미한다.

- 자바 8의 새 기능을 이용해 코드를 간결하고 이해하기 쉽게 만들고, 메서드 참조와 스트림 API를 이용해 코드의 의도를 명확하게 보여줄 수 있다.
    - 익명 클래스를  람다 표현식으로 리팩터링하기
    - 람다 표현식을 메서드 참조로 리팩터링하기
    - 명령형 데이터 처리를 스트림으로 리팩터링하기

## 익명 클래스를 람다 표현식으로 리팩터링하기

- 하나의 추상 메서드를 구현하는 익명 클래스는 람다 표현식으로 리팩터링할 수 있다.
- 람다 표현식을 이용해서 간결하고, 가독성이 좋은 코드를 구현할 수 있다.

```java
// 익명 클래스
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// 람다 표현식으로 변환
Runnable r = () -> System.out.println("Hello");
```

- 모든 익명 클래스를 람다 표현식으로 변환할 수 있는 것은 아니다.
    1. 익명 클래스에서 사용한 this와 super는 람다 표현식에서 다른 의미를 갖는다.
        1. 익명 클래스에서 this는 익명 클래스 자신을 가리킨다.
        2. 람다에서 this는 람다를 감싸는 클래스를 가리킨다.
    2. 익명 클래스는 감싸고 있는 클래스의 변수를 가릴 수 있다.(섀도 변수)
    3. 람다 표현식으로는 변수를 가릴 수 없다.

    ```java
    int a = 10;
    Runnable r = () -> {
        // a = 20; // 컴파일 에러
        System.out.println("Hello");
    };
    ```

    1. 익명 클래스를 람다 표현식으로 바꾸면 콘텍스트 오버로딩에 따른 모호함이 초래될 수 있다.
        1. 익명 클래스는 인스턴스화할 때 명시적으로 형식이 정해지는 반면 람다의 형식은 콘텍스트에 따라 달라지기 때문이다.

        ```java
        interface Task {
              public void execute();
        }
        
        public void doSomething(Runnable r) {
            r.run();
        }
        
        public void doSomething(Task a) {
            a.execute();
        }
        
        //익명 클래스 콘텍스트 전달
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });
        
        //모호함 발생 Runnable or Task ???
        doSomething(() -> System.out.println("Danger danger!!");)
        
        //람다 표현식 콘텍스트 전달
        doSomething((Task) () -> System.out.println("Danger danger!!"));
        ```


## 람다 표현식을 메서드 참조로 리팩터링하기

람다 표현식은 쉽게 전달할 수 있는 짧은 코드다. 하지만 람다 표현식 대식 메서드 참조를 이용하면 가독석을 높일 수 있다. 메서드 참조의 메서드명으로 코드의 의도를 명확하게 알릴 수 있다.

```java
//람다 표현식
Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
  .collect(groupingBy(
      dish -> {
          if (dish.getCalories() <= 400) return CaloricLevel.DIET;
          else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
          else return CaloricLevel.FAT;
      }
  ));
  
//메서드 참조
Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu.stream()
    .collect(groupingBy(Dish::getCaloricLevel));
```

- 람다 표현식을 별도의 메서드로 추출한 다음에 groupingBy에 인수로 전달.

### comparing

```java
inventory.sort(
	(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
	// 비교 구현에 신경 써야한다.
)

// 메서드 참조
inventroy.sort(comparing(Apple::getWeight)); //코드 자체가 문제를 설명
```

### sum, maximum등 자주 사용하는 리듀싱 연산

```java
//저수준 리듀스
int totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (c1, c2) -> c1 + c2);

//메서드 참조
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
```

## 명령형 데이터 처리를 스트림으로 리팩터링하기

- 스트림 API를 이용하면 문제를 더 직접적으로 기술할 수 있을 뿐 아니라 쉽게 병렬화할 수 있다.

```java
List<String> dishNames = new ArrayList<>();
for(Dish dish: menu) {
	if(dish.getCalories() > 300) {
		dishNames.add(dish.getName());
	}
}

menu.parallelStream()
	.filter(d -> d.getCalories > 300)
	.map(Dish::getName)
	.collect(toList());
```

## 코드 유연성 개선

- 람다 표현식을 이용하면 동작 파라미터화를 쉽게 구현할 수 있다. 즉, 다양한 람다를 전달해서 다양한 동작을 표현할 수 있다.
- 변화하는 요구사항에 대응할 수 있는 코드를 구현할 수 있다.

### 함수형 인터페이스 적용

람다 표현식을 이용하려면 함수형 인터페이스가 필요하다. 조건부 연기 실행과 실행 어라운드 두 가지 패턴으로 살펴보자

### 조건부 연기 실행

```java
if(logger.isLoggable(Level.FINER)) {
    logger.finer("Problem: " + generateDiagnostic());
}
```

- looger의 상태가 isLoggable이라는 메서드에 의해 클라이언트 코드로 노출된다.
- 메세지를 로깅할 때마다 logger 객체의 상태를 매번 확인한다.

```java
public void log(Level level, Supplier<String> msgSupplier) {
	if(logger.isLoggable(level) {
		log(level, msgSupler.get()); //람다 실행
	}
}

logger.log(Level.FINER, () -> "Problem: " + generateDiagnostic());

```

- 특정 조건에서만 메시지가 생성될 수 있도록 메시지 생성 과정을 연기할 수 있어야 한다.
- 이와 같은 logger 문제를 해결할 수 있도록 Supplier를 인수로 갖는 오버로드된 log 메서드를 제공했다.
- log 메서드는 logger의 수준이 적절하게 설정되어 있을 때만 인수로 넘겨진 람다를 내부적으로 실행하
- 해결한 문제
    - 만일 클라이언트 코드에서 객체 상태를 자주 확인하거나, 객체의 일부 메서드를 호출하는 상황 이라면 내부적으로 객체의 상태를 확인한 다음에 메서드를 호출 하도록 새로운 메서드를 구현하는 것이 좋다.
    - 코드 가독성이 좋아질 뿐 아니라 캡슐화도 강화된다.

### 실행 어라운드

매번 같은 준비, 종료 과정을 반복적으로 수행하는 코드가 있다면 이를 람다로 변환할 수 있다.

- 준비, 종료 과정을 처리하는 로직을 재사용함으로써 코드 중복을 줄일 수 있다.

```java
//기존 코드
public static String processFile() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        return br.readLine();
    }
}

//함수형 인터페이스를 이용해 리팩터링한 코드
public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        return p.process(br);
    }
}

//함수형 인터페이스를 이용해 리팩터링한 코드를 호출하는 코드
String oneLine = processFile((BufferedReader br) -> br.readLine());
```