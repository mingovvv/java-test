# 테스트 코드
JUnit5 기준으로 작성

### 테스트 기본 애노테이션

@Test
- 테스트할 메소드에 지정하는 애노테이션

@BeforeAll
- `@Test` 목록을 실행하기 전, 1회만 호출되는 메소드에 설정
- `static` 키워드 사용
  
@AfterAll
- `@Test` 목록을 실행한 이 후, 1회만 호출되는 메소드에 설정
- `static` 키워드 사용

@BeforeEach
- 각각의 `@Test` 를 실행하기 전, 호출되는 메소드에 설정

@AfterEach
- 각각의 `@Test` 를 실행한 이 후, 호출되는 메소드에 설정

@Disable
- 테스트 실행 제외 애노테이션

### 테스트 이름 표기

@DisplayNameGeneration(storage)
- 클래스, 메소드 영역 사용 가능
- 메소드 이름으로 `테스트 명` 이 표기
- 전략(storage)를 설정해 주어야 함
  - DisplayNameGenerator.ReplaceUnderscores.class : underscore를 공백으로 치환해 줌

@DisplayName("자바 테스트")
- 메소드 영역 사용 가능
- 한글, 공백, 이모지 모두 사용 가능

### Assertion
- 기대값과 실제값이 같은지 : assertEqulas(expected, actual)
- 실제값이 Null이 아닌지 : assertNotNull(actual)
- 다음 조건이 참 인지 : assertTrue(boolean)
- assetion구문 전체 확인 : assertAll(excutables...)
- 예외 발생 확인 : assertThrows(expectedType, excutable)
- 특정시간 안에 실행이 완료 되는지 : assertTimeout(duration, excutable)

### 조건에 따른 테스트
- `org.junit.jupiter.api` 패키지의 `Assumptions` 를 사용
- assumeTrue, assumingThat ...
- `@EnabledOnOs`, `@DisabledOnJre` ...

### 반복 테스트
- `org.junit.jupiter.api.RepeatedTest` 패키지
- `RepetitionInfo` 를 매개변수로 받아서 사용할 수 있음
- `@RepeatedTest`, `@ParameterizedTest` 사용
- @ParameterizedTest
  - `@ValueSource`, `@EmptySource`, `@NullSource`
  
### 테스트 인스턴스
- 메서드 마다 인스턴스를 생성하는 것이 default 전략(의존성을 낮추는 방법)
- `@TestInstance(Lifecycle.PER_CLASS)` 를 통해 클래스 당 하나의 인스턴스를 생성하고 공유할 수도 있음

### 테스트 순서
- 테스트 메서드의 실행순서는 기본적으로 보장되지 않는다.(각각의 모듈은 단위테스트의 개념으로 독립적인 상태로 완전해야 하기 때문)
- 하지만 `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` 과 `@Order` 를 통해 인위적인 순서를 줄 수 있다.
 
### test properties를 통한 전역설정
- test/resources 경로에 `junit-platform.properties` 파일을 생성
```properties
# 테스트 인스턴스 라이프사이클 설정
junit.jupiter.testinstance.lifecycle.default = per_class

# 확장팩 자동 감지 기능
junit.jupiter.extensions.autodetection.enabled = true

# @Disabled 무시하고 실행하기
junit.jupiter.conditions.deactivate = org.junit.*DisabledCondition

# 테스트 이름 표기 전략 설정
junit.jupiter.displayname.generator.default = org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores
```