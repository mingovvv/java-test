package xyz.devyu.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@DisplayName("테스트 순서 TEST")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(FindSlowTestExtension.class) // [junit5 확장모델] 선언방식
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(2000L); // [junit5 확장모델] 프로그래밍 등록 방식(생성자를 통한 클래스 코드 조작)


    @Test
    @Order(3)
    void OrderTest1() {
        System.out.println("method name = OrderTest1");
    }

    @Test
    @Order(1)
    void OrderTest2() throws InterruptedException {
        Thread.sleep(1010);
        System.out.println("method name = OrderTest2");
    }

    @Test
    @Order(2)
    void OrderTest3() {
        System.out.println("method name = OrderTest3");
    }
}
