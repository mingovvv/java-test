package xyz.devyu.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TestTest {

    @Test
    @DisplayName("자바 테스트 메소드 1")
    void test1() {
        System.out.println("test 1");

        Order order = new Order();

        // assert 개별 테스트 - 순차적으로 테스트를 진행하며, 테스트가 실패하면 그 즉시 테스트를 중단
        assertNotNull(order);
        assertEquals(OrderStatus.RECEIVED, order.getStatus(), () -> "주문의 첫 상태는 RECEIVED 상태");
        assertTrue(1<2, () -> "2는 1보다 커야한다.");

        // assertAll 단위 테스트 - 테스트를 모두 진행하여 실패된 테스트 전체 확인 가능
        assertAll(
                () -> assertNotNull(order),
                () -> assertEquals(OrderStatus.RECEIVED, order.getStatus(), () -> "주문의 첫 상태는 RECEIVED 상태"),
                () -> assertTrue(1<2, () -> "2는 1보다 커야한다.")
        );

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Order(-10));
        assertEquals("가격이 0원보다 작을 수 없습니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("자바 테스트 메소드 2")
    void test2() {
        System.out.println("test 2");
    }

    @Test
    @Disabled
    @DisplayName("자바 테스트 메소드 3")
    void test3() {
        System.out.println("test 3 - Disabled");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }



}