package xyz.devyu.javatest;

public interface OrderRepository {
    Order findById(Long id);
    void valid(Long id);
}
