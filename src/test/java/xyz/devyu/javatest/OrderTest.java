package xyz.devyu.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

@DisplayName("테스트 순서 TEST")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @Test
    @Order(3)
    void OrderTest1() {
        System.out.println("method name = OrderTest1");
    }

    @Test
    @Order(1)
    void OrderTest2() {
        System.out.println("method name = OrderTest2");
    }

    @Test
    @Order(2)
    void OrderTest3() {
        System.out.println("method name = OrderTest3");
    }
}
