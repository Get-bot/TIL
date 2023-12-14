# 스트림으로 데이터 수집
# 컬렉터란 무엇인가?

```java
//명령형
Map<Currency, List<Transaction>> transactionsByCurrenciesOld = new HashMap<>();

    for (Transaction transaction : transactions) {
      Currency currency = transaction.getCurrency();
      List<Transaction> transactionsForCurrency = transactionsByCurrenciesOld.get(currency);
      if (transactionsForCurrency == null) {
        transactionsForCurrency = new ArrayList<>();
        transactionsByCurrenciesOld.put(currency, transactionsForCurrency);
      }
      transactionsForCurrency.add(transaction);
    }

//함수형
Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
        .collect(Collectors.groupingBy(Transaction::getCurrency));
```

- 두 코드를 비교 했을 때 명령형 코드는 함수형 코드에 비해 다중루프, 조건문 등 가독성과 유지보수성이 떨어진다. 반면 함수형 코드는 이해하기 쉽고 간결하게 구현 되었다.
- 다수준으로 그룹화를 수행할 떄 차이점이 더욱 두드러진다.

## 고급 리듀싱 기능을 수행하는 컬렉터

- 훌륭하게 설계된 함수형 API의 장점으로 높은 수준의 조합성과 재사용성을 꼽을 수 있다.
- collect로 결과를 수집하는 과정을 간단하고 유연한 방식으로 정의할 수 있다.
- 스트림에 collect를 호출하면 내부적으로 **리듀싱 연산**이 일어난다.
- Collector인터페스의 메서드를 어떻게 구현하느냐에 따라 스트림에 어떤 리듀싱이 연산을 수행할지 결정된다.
- 보통 함수 요소로 변환 할 때는 컬렉터를 적용하며 최종 결과를 저장하는 자료구조에 값을 누적한다
    
    스트림의 각 요소 → 변환함수 → 요소 추출 → 최종 결과 저장 자료구조 값 누적 
    

## 미리 정의된 컬렉터

- Collectors에서 제공하는 메서드의 기능 구분
    1. 스트림 요소를 하나의 값으로 리듀스하고 요약
    2. 요소 그룹화
    3. 요소 분할

# 리듀싱과 요약

- 컬렉터(Stream.collect 메서드의 인수)로 스트림의 항목을 컬렉션으로 재구성 가능하다.
- 트리를 구성하는 다수준 맵, 단순한 정수 등 다양한 형식으로 결과를 도출 가능하다.

```java
long howManyDishes = menu.stream().collect(Collectors.counting());

//불필요한 과정 생략
long skipSteps_howManyDishes = menu.stream().count();
```

## 스트림 값에서 최대값과 최솟값 검색

```java
// Comparator는 두 객체를 비교하는 데 사용
Comparator<Dish> dishCaloriesComparator =
    Comparator.comparingInt(Dish::getCalories);

//최댓값
Optional<Dish> mostCalorieDish = menu.stream()
    .collect(maxBy(dishCaloriesComparator));
```

- 컬렉션이 아무런 요소도 가지고 있지 않다면 값을 반환 받을 수 없다. 이런 경우를 위해 Java에서는 Optional이라는 특별한 컨테이너 클래스를 제공한다. 이 Optional 클래스는 값을 감싸서, 그 값이 존재하거나 존재하지 않을 수 있는 상황을 명확하게 표현할 수 있게 한다.

## 요약 연산

- 스트림에 있는 객체의 숫자 필드의 합계나 평균 등을 반환하는 연산

### summingInt

- summingInt의 인수로 전달된 함수는 객체를 int로 매핑한 컬렉터를 반환

```java
//summingInt가 collect메서드로 전달되면 요약 작업 수행
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

long totalCaloriesLong = menu.stream().collect(summingLong(Dish::getCalories));

Double totalCaloriesDouble = menu.stream().collect(summingDouble(Dish::getCalories));
```

- summingInt 컬렉터의 누적 과정

    ![Untitled](./img/Untitled.png)

    - 매핑된 각 요소의 값을 탐색하며 초깃값으로 설정되어 있는 누적자에 칼로리를 더한다.
- summingLong, summingDouble 메서드도 같은 방식으로 동작하며 각각 형식의 데이터로 요약한다는 차이만 있다.

### averagingInt

- 평균값 계산

```java
double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

double avgCaloriesLong = menu.stream().collect(averagingLong(Dish::getCalories));
    
double avgCaloriesDouble = menu.stream().collect(averagingDouble(Dish::getCalories));
```

### summarizingInt

- 두개 이상의 연산을 한 번에 수행

```java
IntSummaryStatistics menuStatistics = menu.stream()
      .collect(summarizingInt(Dish::getCalories));

LongSummaryStatistics menuStatisticsLong = menu.stream()
    .collect(summarizingLong(Dish::getCalories));

DoubleSummaryStatistics menuStatisticsDouble = menu.stream()
    .collect(summarizingDouble(Dish::getCalories));

//SummaryStatistics로 모든 정보가 수집된다.
//IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
```

## 문자열 연결

### joining

- 스트림의 각 객체에 toString 메서드를 호출해서 모든 문자열을 하나의 문자열로 연결해서 반환한다.
- 내부적으로 StringBuilder를 이용해서 문자열을 하나로 만든다
- 연결된 요소 사이에 구분 문자열을 넣을 수 있도록 오버로드된 메서드도 제공한다.

```java
String shortMenu = menu.stream()
        .map(Dish::getName)
      .collect(joining());

~~~~// 구분 문자열
String shortMenuSeparator = menu.stream()
    .map(Dish::getName)
    .collect(joining(", "));
```

## 범용 리듀싱 요약 연산

### reducing

- 모든 컬렉터는 reducing 팩토리 메서드로도 정의할 수 있다.
- 범용 팩터리 메서드 대신 특화 컬렉터를 사용한 이유는 가독성과 편의성 때문이다.

```java
int totalCaloriesReducing = menu.stream()
  .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

//인수가 하나인 reducing
Optional<Dish> mostCaloriesDish = menu.stream()
    .collect(
        reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
    );
```

- reducing의 인수
    
    ```java
    public static <T, U> java.util.stream.Collector<T, ?, U> reducing(
    	U identity,
    	@NotNull  java.util.function.Function<? super T, ? extends U> mapper,
    	@NotNull  java.util.function.BinaryOperator<U> op
    );
    ```
    
    1. identity - 리듀스를 위한 식별 값(또한 입력 요소가 없을 때 반환되는 값)
    2. mapper - 각 입력 값에 적용할 매핑 함수
    3. op - 매핑된 값을 리듀스 시키는 데 사용되는 BinaryOperator<U>
- 인수가 하나인 reducing
    
    ```java
    public static <T> java.util.stream.Collector<T, ?, java.util.Optional<T>> reducing(     java.util.function.BinaryOperator<T> op );
    ```
    
    1. op - 입력 요소를 리듀스 할 때 사용되는 BinaryOperator<T>입니다.
    - identity 를 첫 번째 인수로 받고 자신을 그대로 반환하는 **항등** **함수**를 두 번째 인수로 받는 상황에 해당한다. 즉, 시작값이 없으므로 Optional객체를 반환한다.

### 컬렉션 프레임워크 유연성 : 같은 연산도 다양한 방식으로 수행할 수 있다.

- 람다 표현식 대신 Integer 클래스의 sum 메서드를 참조하여 단순화

```java
int totalCalories = menu.stream()
	.collect(reducing(0, Dish::getCalories, Integer::sum));
```

- 리듀싱 과정
    
    ![Untitled](./img/Untitled 1.png)

    1. 누적자를 초깃값으로 초기화
    2. 합계 함수를 이용해 각 요소에 변환 함수를 적용한 결과를 반복적으로 조합.
- 스트림을 IntStream으로 매핑한 다음에 sum 메서드 호출

```java
int totalCalories = menu.stream()
 .mapToInt(Dish::getCalories).sum();
```

- 이렇게 같은 연산을 다양한 방법으로 수행할 수 있다.

### 상황에 맞는 최적의 해법 선택

- 스트림 인터페이스 제공 메서드: 컬렉터에 비해 복잡도가 낮음
- 컬렉터: 코드가 좀 더 복잡한 대신 재사용성과 커스터마이즈 가능성을 제공하는 높은 수준 추상화와 일반화를 얻음
- 문제를 해결할 수 있는 다양한 해결 방법을 확인한 다음 가장 일반적으로 문제에 특화된 해결책을 고르는 것이 바람직하다. 이렇게 해서 가독성과 성능을 모두 잡을 수 있다.

**예제**

```java
int totalCalories = menu.stream()
 .mapToInt(Dish::getCalories).sum();
```

- 전체 칼로리를 계산한다 가정할 때 위 코드는 가독성이 좋고 간결하며 IntStream 덕분에 자동 언박싱연산을 수행하거나 Integer를 int로 변환하는 과정을 피할 수 있으므로 성능도 챙길 수 있다.

# 그룹화

- 데이터 집합을 하나 이상의 특성으로 분류해서 그룹화

### groupingBy

```java
Map<DishType, List<Dish>> dishesByType = menu.stream()
	.collect(groupingBy(Dish::getType));

// 람다 표현식으로 그룹화 구현
Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
    .collect(groupingBy(dish -> {
      if (dish.getCalories() <= 400) return CaloricLevel.DIET;
      else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
      else return CaloricLevel.FAT;
    }));
```

- 자바 8의 합수형을 이용해 가독성 있는 코드로 그룹화를 구현 가능하다.
- 함수를 기준으로 스트림이 그룹화되므로 **분류 함수**라고 부른다
- 그룹화로 스트림 분류 과정

    ![Untitled](./img/Untitled 2.png)
    
    - 그룹화 연산의 결과로 그룹화 함수가 반환하는 키 그리고 키에 대응하는 스트림의 모든 항목 리스트를 갖는 맵이 반환된다.
- 단순한 속성 접근자 대신 더 복잡한 분류 기준이 필요하면 메서드 참조를 분류 함수로 사용 불가능하기 때문에 함다 표현식으로 필요한 로직을 구현할 수 있다.

## 그룹화된 요소 조작

```java
Map<DishType, List<Dish>> highCaloricDishesByType = menu.stream()
        .filter(dish -> dish.getCalories() < 500)
      .collect(groupingBy(Dish::getType));

//두번째 Collector 안으로 필터 프레디케이트 이동
Map<DishType, List<Dish>> caloricDishesByType = menu.stream()
    .collect(groupingBy(Dish::getType,
        filtering(dish -> dish.getCalories() > 500, toList())));
```

- 모든 DishType의 결과를 유지해야 한다고 가정했을때 filter메소드가 groupingBy 이전에 호출되어서 만족하는 조건이 없을경우 해당 키 자체가 사라졌다. 두 번째 방법으로 filtering() 컬렉터가 grouping내부에서 사용되게 하여 문제를 해결 할 수 있다.
- 이 두 가지 방법은 필터링 조건에 대해 다른 결과를 생성하므로. 결과를 어떻게 표현하고 싶은지, 결과에서 어떤 정보를 보여줄지에 따라 각 방법의 장단점을 고려해서 선택 해야한다.

### filtering

- filtering() 은 스트림의 각 요소를 필터링하여 원하는 조건에 부합하는 요소들만 특정 방식으로 수집할 수 있다.
- 인수
    1. 첫번째 매개변수는 프레디케이트로, 스트림의 각 요소에 적용된다.
    2. 두번째 매개변수는 다른 Collector로, 프레디케이트가 참인 결과 요소들만 수집한다.

```java
Map<DishType, List<Dish>> caloricDishesByType = menu.stream()
        .collect(
            groupingBy(
                Dish::getType,
                filtering(
                    dish -> dish.getCalories() > 500,
                    toList()
                )
            ));
```

### mapping

- mapping()은 입력 스트림의 각 요소를 원하는 형태로 변환(매핑)하고, 그 변환된 요소들을 원하는 방식으로 수집할 수 있도록 한다.
- 인수
    1. 첫 번째 매개변수는 매핑 함수로, 스트림의 각 요소에 적용된다.
    2. 두 번째 매개변수는 다른 Collector로, 매핑 함수가 반환한 결과를 수집한다.

```java
Map<DishType, List<String>> dishNamesByType = menu.stream()
        .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
```

### flatMap

- flatMapping()은 '매핑'과 '평면화'라는 두 가지 스트림 연산을 결합하는 메서드입니다. 그 결과로, 스트림의 각 요소를 여러 개의 결과로 '분해'하고, 이들을 하나의 '평탄화된' 스트림으로 만듭니다.
- 인수
    1. 첫 번째 매개변수는 함수로, 스트림의 각 요소에 적용됩니다. 이 함수는 스트림의 각 요소를 스트림으로 변환합니다. 즉, 각 요소를 여러 요소로 분해합니다. 이 때 이 '분해'는 조건에 따라 비어있는 스트림일 수 있습니다.
    2. 두 번째 매개변수는 컬렉터로, 변환 및 평면화된 요소들을 수집하는 데 사용됩니다.
    
    ```java
    return Map.of(
            "pork", List.of("greasy", "salty"),
            "beef", List.of("salty", "roasted"),
            "chicken", List.of("fried", "crisp"),
            "french fries", List.of("greasy", "fried"),
            "rice", List.of("light", "natural"),
            "season fruit", List.of("fresh", "natural"),
            "pizza", List.of("tasty", "salty"),
            "prawns", List.of("tasty", "roasted"),
            "salmon", List.of("delicious", "fresh")
        );
    
    Map<DishType, Set<String>> dishNamesByType = menu.stream()
            .collect(
                groupingBy(Dish::getType,
                    flatMapping(
                        dish -> dishTags.get(dish.getName()).stream(),
                        toSet()
                    )
                )
            );
    
    // dishNamesByType = {MEAT=[salty, greasy, roasted, fried, crisp], OTHER=[salty, greasy, natural, light, tasty, fresh, fried], FISH=[roasted, tasty, fresh, delicious]}
    ```