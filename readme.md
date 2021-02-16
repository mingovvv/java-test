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

