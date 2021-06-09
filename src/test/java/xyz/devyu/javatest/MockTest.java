package xyz.devyu.javatest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class) // @Mock 애노테이션을 활용할 수 있게 해줌
public class MockTest {

    @Mock // extention과 함께 사용해야 한다.
    OrderRepository orderRepository;

    @Test
    void createMock() {
        // mockito를 통한 생성
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);

        Order order = new Order();
        order.setCost(3000);
        order.setOrderStatus(OrderStatus.CONFIRM);

        Order order2 = new Order();
        order2.setCost(60000);
        order2.setOrderStatus(OrderStatus.DELIVERY);


        // [stubbing :: 객체 생성]
        //  - 특정 값
//        Mockito.when(orderRepository.findById(1L)).thenReturn(order);
        //  - 모든 값 (argument matchers any를 사용하여 모든 값에 대하여 적용)
        Mockito.when(orderRepository.findById(ArgumentMatchers.any()))
                .thenReturn(order);
        // 검증
        Order selectedOrder = orderRepository.findById(100L);
        assertThat(selectedOrder.getCost()).isEqualTo(3000);




        // [stubbing :: exception 발생]
        Mockito.doThrow(new IllegalArgumentException())
                .when(orderRepository).valid(4L);
        // 검증
        assertThrows(IllegalArgumentException.class, () -> orderRepository.valid(4L));




        // [stubbing :: mock 객체 체이닝]
        Mockito.when(orderRepository.findById(ArgumentMatchers.any()))
                .thenReturn(order) // 첫번째 호출
                .thenReturn(order2) // 두번째 호출
                .thenThrow(new RuntimeException()); // 세번째 호출

        // 검증
        Order selectedOrder1 = orderRepository.findById(1L);
        Order selectedOrder2 = orderRepository.findById(2L);

        assertAll(() -> {
            assertThat(selectedOrder1.getCost()).isEqualTo(3000);
            assertThat(selectedOrder2.getCost()).isEqualTo(60000);
            assertThrows(RuntimeException.class, () -> orderRepository.findById(3L));
        });

    }
}
