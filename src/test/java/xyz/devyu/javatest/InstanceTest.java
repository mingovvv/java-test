package xyz.devyu.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@DisplayName("테스트 인스턴스 TEST")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class InstanceTest {

    // junit5는 각 메서드의 의존성을 낮추기 위해 Test Method마다 각각 인스턴스를 생성하는 전략이 default 전략
    // @TestInstance(TestInstance.Lifecycle.PER_CLASS) : class단위로 인스턴스를 생성

    @Test
    void test1() {
        System.out.println(this);
    }

    @Test
    void test2() {
        System.out.println(this);
    }

    @Test
    void test3() {
        System.out.println(this);
    }
}
