package xyz.devyu.javatest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

    private OrderStatus orderStatus = OrderStatus.RECEIVED;
    private int cost;

    public OrderStatus getStatus() {
        return this.orderStatus;
    }

    public Order() {
    }

    public Order(int cost) {
        if(cost < 0) {
            throw new IllegalArgumentException("가격이 0원보다 작을 수 없습니다.");
        }
        this.cost = cost;
    }
}
