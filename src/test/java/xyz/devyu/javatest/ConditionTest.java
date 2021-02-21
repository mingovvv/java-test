package xyz.devyu.javatest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {

    @Test
    @DisplayName("환경변수에 따른 테스트")
    void condition_test1() {
        // 서비스 환경변수에 따라 실행되는 테스트 조건 문

        // case 1 : 조건에 부합하는지 검사한 뒤, 일치할 경우 다음 라인을 실행
        Assumptions.assumeTrue("DEV".equalsIgnoreCase(System.getenv("TEST_ENV")));

        // case 2 : 조건에 부합하는지 검사한 뒤, 하위 메소드를 실행
        Assumptions.assumingThat("DEV".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {

            // test 1

            // test 2

            // ...

        });

        Assumptions.assumingThat("QA".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {

            // test 1

            // test 2

            // ...

        });

    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @DisplayName("윈도우와 리눅스 운영체제에서 활설화 되는 테스트")
    void condition_test2() {

    }

    @Test
    @DisabledOnOs({OS.MAC, OS.LINUX})
    @DisplayName("맥 운영체제에서 비활성화 되는 테스트")
    void condition_test3() {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    @DisplayName("Java 8에서 활성화 되는 테스트")
    void condition_test4() {
        System.out.println("자바 8");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_11)
    @DisplayName("Java 11에서 활성화 되는 테스트")
    void condition_test5() {
        System.out.println("자바 11");
    }

}
