# 변수와 타입
#### 변수는 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름이다. 변수를 통해 프로그램은 메모리 번지에 값을 저장하고 읽을 수 있다.
## 선언
#### 변수를 선언할 때는 변수의 타입과 변수의 이름을 지정해야 한다.
- 자바의 변수는 다양한 타입의 값을 저장할 수 없다. 즉, 정수형 변수에는 정수값만 저장 가능하며 실수형 변수에는 실수값만 저장 가능하다.
- 변수 이름은 첫 번째 글자가 문자여야 하고, 숫자로 시작할 수 없다. 또한, 자바의 예약어는 변수 이름으로 사용할 수 없다.
- 변수 이름은 대소문자가 구분된다.
- 변수 이름은 의미를 파악할 수 있도록 지어야 한다.
- 변수 선언은 저장되는 값의 타입만 결정한 것이지, 아직 메모리에 할당된 것은 아니다. 
- 변수에 최초로 값이 대입될 때 메모리에 할당되고 이런 동작을 초기화라 한다,그후  해당 메모리에 값이 저장된다.
## 기본 타입
|값의 분류|기본 타입|
|:---:|:---:|
|정수|byte, char, short, int, long|
|실수|float, double|
|논리|boolean|
## 정수 타입
|타입|   메모리크기    |저장되는 값의 허용 범위|
|:---:|:----------:|:---:|
|byte| 1byte 8bit |-128~127|
|char| 2byte 16bit|0~65535|
|short| 2byte 16bit|-32768~32767|
|int| 4byte 32bit|-2147483648~2147483647|
|long| 8byte 64bit|-9223372036854775808~9223372036854775807|

- byte, short, int, long 타입은 정수값을 저장할 때 사용한다. 최상위 bit는 부호 bit로 사용된다.
- char 타입은 문자를 저장할 때 사용한다. char 타입은 부호가 없으므로 음수값을 저장할 수 없다.

## 실수 타입

|타입|   메모리크기    |저장되는 값의 허용 범위| 유효 소수 이하자리 |
|:---:|:----------:|:---:|:----------:|
|float| 4byte 32bit |1.4E-45~3.4028235E38|    7자리     |
|double| 8byte 64bit|4.9E-324~1.7976931348623157E308|15자리|
- 값을 부동 소수점(floating point) 방식으로 저장한다고 해서 float, double 타입이라고 한다.
- double 타입이 float 타입보다 더 큰 범위의 수를 저장할 수 있으며, 더 정밀한 값을 저장할 수 있다.
- 컴파일러는 실수 리터럴을 기본으로 double 타입으로 간주한다. float 타입으로 사용하려면 리터럴 뒤에 f나 F를 붙여야 한다.
## 논리 타입
- 논리 타입은 true와 false 두 가지 값만을 가질 수 있다.
- boolean 타입 변수는 주로 두 가지 상태값을 저장할 필요가 있을 경우에 사용되며, 상태값에 따라 조건문과 제어문의 실행 흐름을 변경하는 데 사용된다.
- boolean 타입 변수는 1byte의 메모리를 사용한다.
## 문자열 타입
- 작은따옴표(')로 감싼 한 개의 문자는 char 타입이지만, 큰따옴표(")로 감싼 여러 개의 문자들은 유니코드로 변환되지 않는다.
- 큰따옴표(")로 감싼 문자들을 문자열이라고 부른다. 문자열은 String 타입으로 표현한다.
- 자바 13부터는 텍스트 블록 문법을 사용하여 문자열을 표현할 수 있다.
    #### 텍스트 블록 문법
    큰따옴표 3개로 감싸면 이스케이프 문자를 사용하지 않고 여러 줄로 문자열을 표현할 수 있다.
    ```java
    String textBlock = """
    Hello,
    hi,
    how are you
    """;
    ```
## 자동 타입 변환
#### 자동 타입 변환은 작은 크기를 가지는 타입이 큰 크기를 가지는 타입에 저장될 때 발생한다.
#### 기본 타입의 허용 범위 순
```java
byte < short < int < long < float < double
```
- char 타입보다 허용 범위가 작은 byte 타입은 char 타입으로 자동 변환될 수 없다. char 타입의 허용 범위는 음수를 포함하지 않는데, byte 타입은 음수를 포함하기 때문이다.
## 강제 타입 변환(casting)
#### 강제 타입 변환은 큰 크기의 타입을 작은 크기의 타입으로 쪼개어 저장할 때 발생한다.
- 강제 타입 변환은 (타입) 연산자를 사용하여 수행한다.
    ```java
    int intValue = 103029770;
    byte byteValue = (byte) intValue;
    ```
## 연산식에서 자동 타입 변환
- 자바는 실행 성능을 향상시키기 위해 컴파일 단계에서 연산을 수행한다.
- 연산을 수행하기 전에 컴파일러가 타입을 일치시킨다.
- 피연산자의 타입을 일치시킨다.
- 피연산자의 타입이 다를 경우 크기가 큰 타입으로 자동 변환된다.
- 피연산자의 타입이 서로 다른 경우 크기가 큰 타입으로 자동 변환된다.
- 피연산자의 타입이 표현할 수 있는 값의 범위보다 크면 컴파일 오류가 발생한다.
#### + 연산자
- 피연산자가 모두 숫자일 경우에는 덧셈 연산식을 수행하고, 피연산자 중 하나가 문자열일 경우에는 문자열 연결 연산식을 수행한다.
- 연산식에서 + 가 연이어 나오면 앞에서부터 순차적으로 +연산을 수행한다. 먼저 수행된 연산이 덧셈이라면 덧셈 결과를 가지고 다음 + 연산을 수행한다.
## 문자열을 기본 타입으로 반환
- 문자열을 기본 타입으로 변환할 때는 Wrapper 클래스를 사용한다.

|반환타입 | 사용 예| 
|:---:|:---:|
|byte|Byte.parseByte("10")|
|short|Short.parseShort("10")|
|int|Integer.parseInt("10")|
|long|Long.parseLong("10")|
|float|Float.parseFloat("3.14")|
|double|Double.parseDouble("3.14")|
|boolean|Boolean.parseBoolean|

- 기본 타입의 값을 문자열로 변경하는 경우는 Stinrg 클래스의 valueOf() 메소드를 사용한다.
## 변수 사용범위
- 변수는 중괄호 {} 블록 내에서 선언되고 사용된다.
- 중괄호 블록 내에서 선언된 변수는 중괄호 블록 내에서만 사용할 수 있다.
- 중괄호 블록 내에서 선언된 변수는 중괄호 블록을 벗어나면 메모리에서 자동으로 제거된다.
## 콘솔로 변수값 출력
- System.out.println() 메소드는 매개값으로 주어진 값을 콘솔에 출력하고 줄을 바꾼다.
- System.out.print() 메소드는 매개값으로 주어진 값을 콘솔에 출력하고 줄을 바꾸지 않는다.
- System.out.printf() 메소드는 지시자를 사용하여 변수의 값을 여러 가지 형식으로 출력할 수 있다.
    #### 지시자
    |지시자|설명|
    |:---:|:---:|
    |%d|10진 정수|
    |%x|16진 정수|
    |%f|부동소수점 실수|
    |%c|문자|
    |%s|문자열|
    |%%|%|
    #### 정렬과 공백
    |지시자|설명|
    |:---:|:---:|
    |%10d|10칸 만큼의 공간을 확보한 후 오른쪽으로 정렬하여 출력|
    |%-10d|10칸 만큼의 공간을 확보한 후 왼쪽으로 정렬하여 출력|
    |%010d|10칸 만큼의 공간을 확보한 후 오른쪽으로 정렬하고 빈 공간은 0으로 채워서 출력|
    #### 소수점 제어
    |지시자|설명|
    |:---:|:---:|
    |%.2f|소수점 아래 두 자리까지 출력|
    |%10.2f|10칸 만큼의 공간을 확보한 후 오른쪽으로 정렬하고 소수점 아래 두 자리까지 출력|
    |%-10.2f|10칸 만큼의 공간을 확보한 후 왼쪽으로 정렬하고 소수점 아래 두 자리까지 출력|